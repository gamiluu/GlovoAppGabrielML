package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Usuario {
    ////////////////////////////////////////ATRIBUTOS////////////////////////////////////////
    private Integer id_usuario;
    private String nombre;
    private String contrasena;

    //////////////////////////////////////CONSTRUCTORES//////////////////////////////////////
    public Usuario () {}
    public Usuario(int id_usuario, String nombre, String contrasena) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
    public Usuario(String contrasena) {
        this.contrasena = contrasena;
    }
    /////////////////////////////////////////MÉTODOS/////////////////////////////////////////
    public Integer getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public static String arrayToJson(ArrayList<Usuario> listaUsuarios){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String json = gson.toJson(listaUsuarios);

        return json;
    }

    public static String usuarioToJson(Usuario usuario){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String json = gson.toJson(usuario);

        return json;
    }
}
