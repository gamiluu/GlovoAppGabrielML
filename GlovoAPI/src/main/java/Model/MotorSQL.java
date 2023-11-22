package Model;

import java.sql.*;

public class MotorSQL {
    //////////////////////////////////////////ATRIBUTOS//////////////////////////////////////////
    private String url = "jdbc:mysql://localhost:3307/glovo";
    private String user = "root";
    private String password = "asir2021";

    private Statement st;
    private Connection conn;
    private ResultSet rs;

    ////////////////////////////////////////////MÉTODOS///////////////////////////////////////////
    //Conexión con la base de datos.
    public void conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            st = conn.createStatement();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error en la conexión al servidor de bases de datos.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //Mostramos por consola una sentencia.
    public ResultSet consultar(String sentencia){
        try{
            rs = st.executeQuery(sentencia);
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error en la obtención de datos de la base de datos.");
        }
        return rs;
    }

    //Ejecutamos una sentencia de modificación de base de datos().
    public int modificar(String sentencia){
        int respuesta = 0;
        try{
            respuesta = st.executeUpdate(sentencia);
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error en la obtención de datos de la base de datos.");
        }
        return respuesta;
    }

    //Cerramos la conexión con la base de datos.
    public void desconectar(){
        try{
            if(rs != null){
                rs.close();
            }
            if(st != null){
                st.close();
            }
            if(conn != null){
                conn.close();
            }
        }catch(SQLException ex){
            ex.getMessage();
            System.out.println("Error en la desconexión del servidor de bases de datos.");
        }
    }
}
