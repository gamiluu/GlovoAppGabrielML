package DAO;

import Model.Compra;
import Model.EnvioCorreo;
import Model.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CompraDAO {
    /////////////////////////////////////////ATRIBUTOS/////////////////////////////////////////
    private MotorSQL motorSql;

    /////////////////////////////////////////CONSTRUCTOR/////////////////////////////////////////
    public CompraDAO() {
        this.motorSql = new MotorSQL();
    }

    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////
    public ArrayList<Compra> findHistorial(String id_usuario){
        ArrayList<Compra> lstCompras = new ArrayList<>();
        try{
            motorSql.conectar();

            String sql = "SELECT C.id_compra, C.fecha, sum(P.precio) as precio_total FROM "
                    +"compras C inner join lineas_compra LC ON C.id_compra=LC.id_compra "
                    +"INNER JOIN productos P ON LC.id_producto=P.id_producto "
                    +"WHERE C.id_usuario="+id_usuario+" AND C.confirmada=1 "
                    +"GROUP BY C.id_compra";
            System.out.println(sql);
            ResultSet rs = motorSql.consultar(sql);

            while(rs.next()){
                //Transformamos la fecha a String.
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                String fechaString = formato.format(rs.getDate("fecha"));
                //Creamos el objeto compra y lo guardamos.
                Compra compra = new Compra(rs.getInt("id_compra"), fechaString, rs.getInt("precio_total"));
                lstCompras.add(compra);
            }
        }catch(SQLException ex){
            ex.getMessage();
        } finally {
            motorSql.desconectar();
        }
        System.out.println(lstCompras);
        return lstCompras;

    }
    public int confirmCompra(String id_usuario){
        int respuesta = 0;
        try{
            motorSql.conectar();
            int idCompraActual = 0;
            String destinatario = "";
            //Obtenemos la ID de la compra que se a a confirmar.
            ResultSet rsCompra = motorSql.consultar("SELECT id_compra FROM compras WHERE id_usuario = "+id_usuario+" AND confirmada = 0");
            while(rsCompra.next()){
                idCompraActual = rsCompra.getInt("id_compra");
            }
            ResultSet rsCorreo = motorSql.consultar("SELECT correo FROM usuarios WHERE id_usuario = "+id_usuario);
            while(rsCorreo.next()){
                destinatario = rsCorreo.getString("correo");
            }
            //Modificamos la compra para dejarla confirmada.
            String sql = "UPDATE compras SET confirmada = 1, fecha = current_date() WHERE id_compra = "+idCompraActual;
            respuesta += motorSql.modificar(sql);
            //Añadimos al usuario la nueva compra.
            respuesta += motorSql.modificar("INSERT INTO compras(id_usuario, confirmada) VALUES ("+id_usuario+", 0)");
            //Creamos un nuevo enviador para enviar el correo.
            System.out.println("Se va a enviar un correo a "+destinatario+" del pedido "+idCompraActual);
            EnvioCorreo enviador = new EnvioCorreo();
            enviador.createEmail(destinatario, idCompraActual);
            enviador.sendEmail();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            motorSql.desconectar();
        }
        System.out.println("Han sido modificadas " + respuesta + " lineas.");
        return respuesta;
    }
}
