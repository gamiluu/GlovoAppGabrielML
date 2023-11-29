package Action;

import DAO.CategoriaDAO;
import DAO.CompraDAO;
import Model.Categoria;
import Model.Compra;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class CompraAction {
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String respuestaJson = "";
        //Obtenemos la acción a ejecutar.
        String action = request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");

        switch(arrayAction[1]){
            case "CONFIRM_COMPRA":
                respuestaJson = confirmCompra(request, response);
                break;
            case "FIND_HISTORIAL":
                respuestaJson = findHistorial(request, response);
                break;
        }
        return respuestaJson;
    }

    private String findHistorial(HttpServletRequest request, HttpServletResponse response) {
        String id_usuario = request.getParameter("IDUSUARIO");
        CompraDAO compraDao = new CompraDAO();
        ArrayList<Compra> lstCompras = new ArrayList<>();
        lstCompras = compraDao.findHistorial(id_usuario);
        System.out.println(Compra.arrayToJson(lstCompras));
        return Compra.arrayToJson(lstCompras);
    }
    public String confirmCompra(HttpServletRequest request, HttpServletResponse response){
        String id_usuario = request.getParameter("IDUSUARIO");
        CompraDAO compraDao = new CompraDAO();
        int respuesta = compraDao.confirmCompra(id_usuario);
        return "{\"lineas_afectadas\":"+respuesta+"}";
    }
}
