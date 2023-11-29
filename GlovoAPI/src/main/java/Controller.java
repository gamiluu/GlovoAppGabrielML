import Action.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyServlet")
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //Obtenemos el ACTION. Ejemplo: "ACTION=PRODUCTOS.FIND_ALL"
        String action = request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        out.print("");
        switch(arrayAction[0]){
            case "PRODUCTOS":
                out.print(new ProductoAction().execute(request, response));
                break;
            case "USUARIOS":
                out.print(new UsuarioAction().execute(request, response));
                break;
            case "RESTAURANTES":
                out.print(new RestauranteAction().execute(request, response));
                break;
            case "PUNTUACIONES":
                out.print(new PuntuacionAction().execute(request, response));
                break;

            case "CATEGORIAS":
                out.print(new CategoriaAction().execute(request, response));
                break;
            case "COMPRAS":
                out.print(new CompraAction().execute(request, response));
                break;
        }
    }

}

