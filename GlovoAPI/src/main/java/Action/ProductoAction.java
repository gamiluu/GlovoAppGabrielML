package Action;

import Model.Producto;
import DAO.ProductoDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ProductoAction {
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String respuestaJson = "";
        //Obtenemos la acción a ejecutar.
        String action = request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");

        switch(arrayAction[1]){
            case "FIND_ALL":
                respuestaJson = findAll(request, response);
                break;
            case "FIND_BY_ID":
                respuestaJson = findById(request, response);
                break;
            case "ADD_PRODUCTO":
                respuestaJson = addProducto(request, response);
                break;
            case "FIND_CURRENT_CART":
                respuestaJson = findCurrentCart(request, response);
                break;
        }
        return respuestaJson;
    }

    private String findCurrentCart(HttpServletRequest request, HttpServletResponse response) {
        String id_usuario = request.getParameter("IDUSUARIO");
        ProductoDAO productoDao = new ProductoDAO();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        listaProductos = productoDao.findCurrentCart(id_usuario);
        System.out.println(Producto.arrayToJson(listaProductos));
        return Producto.arrayToJson(listaProductos);
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        ProductoDAO productoDao = new ProductoDAO();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        listaProductos = productoDao.findAll();
        System.out.println(Producto.arrayToJson(listaProductos));
        return Producto.arrayToJson(listaProductos);
    }

    private String findById(HttpServletRequest request, HttpServletResponse response) {
        String id_restaurante = request.getParameter("IDRESTAURANTE");
        ProductoDAO productoDao = new ProductoDAO();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        listaProductos = productoDao.findById(id_restaurante);
        System.out.println(Producto.arrayToJson(listaProductos));
        return Producto.arrayToJson(listaProductos);
    }

    private String addProducto(HttpServletRequest request, HttpServletResponse response){
        String id_restaurante = request.getParameter("IDRESTAURANTE");
        String nombre = request.getParameter("NOMBRE");
        String imagen = request.getParameter("IMAGEN");
        String descripcion = request.getParameter("DESCRIPCION");
        String precio = request.getParameter("PRECIO");
        ProductoDAO productoDao = new ProductoDAO();
        int respuesta = productoDao.addProducto(id_restaurante, nombre, imagen, descripcion, precio);
        return "{\"lineas_afectadas\":"+respuesta+"}";
    }
}
