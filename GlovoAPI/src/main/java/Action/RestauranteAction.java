package Action;

import DAO.ProductoDAO;
import DAO.RestauranteDAO;
import Model.Producto;
import Model.Restaurante;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class RestauranteAction {
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String respuestaJson = "";
        //Obtenemos la acción a ejecutar.
        String action = request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");

        switch(arrayAction[1]){
            case "FIND_ALL":
                respuestaJson = findAll(request, response);
                break;
            case "FIND_TOP_VENTAS":
                respuestaJson = findTopVentas(request, response);
                break;
            case "LOGIN":
                respuestaJson = findClave(request, response);
                break;
        }
        return respuestaJson;
    }

    private String findClave(HttpServletRequest request, HttpServletResponse response) {
        String nombre = request.getParameter("NOMBRE");
        String clave = request.getParameter("CLAVE");
        RestauranteDAO restauranteDao = new RestauranteDAO();
        Restaurante restaurante = restauranteDao.findId(nombre, clave);
        System.out.println(Restaurante.restauranteToJson(restaurante));
        return Restaurante.restauranteToJson(restaurante);
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        RestauranteDAO restauranteDao = new RestauranteDAO();
        ArrayList<Restaurante> listaRestaurantes = new ArrayList<>();
        listaRestaurantes = restauranteDao.findAll();
        System.out.println(Restaurante.arrayToJson(listaRestaurantes));
        return Restaurante.arrayToJson(listaRestaurantes);
    }

    private String findTopVentas(HttpServletRequest request, HttpServletResponse response) {
        RestauranteDAO restauranteDao = new RestauranteDAO();
        ArrayList<Restaurante> listaRestaurantes = new ArrayList<>();
        listaRestaurantes = restauranteDao.findTopVentas();
        System.out.println(Restaurante.arrayToJson(listaRestaurantes));
        return Restaurante.arrayToJson(listaRestaurantes);
    }
}
