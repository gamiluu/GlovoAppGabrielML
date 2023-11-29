package Action;

import DAO.PuntuacionDAO;
import DAO.RestauranteDAO;
import Model.Restaurante;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PuntuacionAction {
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String respuestaJson = "";
        //Obtenemos la acción a ejecutar.
        String action = request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");

        switch(arrayAction[1]){
            case "PUNTUAR":
                respuestaJson = addPuntuacion(request, response);
                break;
        }
        return respuestaJson;
    }

    private String addPuntuacion(HttpServletRequest request, HttpServletResponse response) {
        String usuario = request.getParameter("USUARIO");
        String restaurante = request.getParameter("RESTAURANTE");
        String nota = request.getParameter("NOTA");
        PuntuacionDAO puntuacionDao = new PuntuacionDAO();
        int respuesta = puntuacionDao.addPuntuacion(usuario, restaurante, nota);
        return "{\"lineas_afectadas\":"+respuesta+"}";
    }
}
