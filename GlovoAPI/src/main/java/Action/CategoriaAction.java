package Action;

import DAO.CategoriaDAO;
import DAO.RestauranteDAO;
import Model.Categoria;
import Model.Restaurante;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class CategoriaAction {
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String respuestaJson = "";
        //Obtenemos la acción a ejecutar.
        String action = request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");

        switch(arrayAction[1]){
            case "FIND_ALL":
                respuestaJson = findAll(request, response);
                break;
        }
        return respuestaJson;
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        CategoriaDAO categoriaDao = new CategoriaDAO();
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        listaCategorias = categoriaDao.findAll();
        System.out.println(Categoria.arrayToJson(listaCategorias));
        return Categoria.arrayToJson(listaCategorias);
    }
}
