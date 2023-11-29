package DAO;

import Model.MotorSQL;

public class PuntuacionDAO {
    /////////////////////////////////////////ATRIBUTOS/////////////////////////////////////////
    private MotorSQL motorSql;

    /////////////////////////////////////////CONSTRUCTOR/////////////////////////////////////////
    public PuntuacionDAO() {
        this.motorSql = new MotorSQL();
    }


    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////
    public int addPuntuacion(String usuario, String restaurante, String nota) {
        int respuesta = 0;
        try{
            motorSql.conectar();
            String sql = "INSERT INTO puntuaciones (id_usuario, id_restaurante, nota) VALUES ("
                    + usuario + ", "
                    + restaurante + ", "
                    + nota + ") ON DUPLICATE KEY UPDATE nota = VALUES (nota)";
            System.out.println("Sentencia ->" + sql);
            respuesta = motorSql.modificar(sql);
        } finally {
            motorSql.desconectar();
        }
        System.out.println("Han sido modificadas " + respuesta + " lineas.");
        return respuesta;
    }

}
