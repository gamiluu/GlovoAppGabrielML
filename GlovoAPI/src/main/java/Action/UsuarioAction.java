package Action;

import Model.Usuario;
import DAO.UsuarioDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class UsuarioAction {
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String respuestaJson = "";
        //Obtenemos la acción a ejecutar.
        String action = request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");

        switch(arrayAction[1]){
            case "FIND_ALL":
                respuestaJson = findAll(request, response);
                break;
            case "LOGIN":
                respuestaJson = findId(request, response);
                break;
        }
        return respuestaJson;
    }

    private String findId(HttpServletRequest request, HttpServletResponse response) {
        String nombre = request.getParameter("NOMBRE");
        String contrasena = request.getParameter("CONTRASENA");
        UsuarioDAO usuarioDao = new UsuarioDAO();
        Usuario usuario = usuarioDao.returnId(nombre, contrasena);
        System.out.println(Usuario.usuarioToJson(usuario));
        return Usuario.usuarioToJson(usuario);
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios = usuarioDao.findAll();
        System.out.println(Usuario.arrayToJson(listaUsuarios));
        return Usuario.arrayToJson(listaUsuarios);
    }
}
