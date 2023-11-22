package DAO;

import Model.MotorSQL;
import Model.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
    /////////////////////////////////////////ATRIBUTOS/////////////////////////////////////////
    private MotorSQL motorSql;

    /////////////////////////////////////////CONSTRUCTOR/////////////////////////////////////////
    public UsuarioDAO() {
        this.motorSql = new MotorSQL();
    }

    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////
    public ArrayList<Usuario> findAll(){
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        try{
            motorSql.conectar();

            ResultSet rs = motorSql.consultar("SELECT * FROM usuarios");

            while(rs.next()){Usuario usuario = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("contrasena")
            );
                listaUsuarios.add(usuario);
            }
        }catch(SQLException ex){
            ex.getMessage();
        } finally {
            motorSql.desconectar();
        }
        System.out.println(listaUsuarios);
        return listaUsuarios;
    }

    public Usuario returnId(String nombre, String contrasena) {
        Usuario usuario = new Usuario();
        try{
            motorSql.conectar();

            ResultSet rs = motorSql.consultar("SELECT id_usuario FROM usuarios WHERE nombre = '"+nombre+"' AND contrasena = '"+contrasena+"'");

            while(rs.next()){
                usuario.setId_usuario(rs.getInt("id_usuario"));
            }
        }catch(SQLException ex){
            ex.getMessage();
        } finally {
            motorSql.desconectar();
        }
        System.out.println(usuario);
        return usuario;
    }
}
