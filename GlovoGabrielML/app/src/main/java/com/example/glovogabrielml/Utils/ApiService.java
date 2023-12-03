package com.example.glovogabrielml.Utils;

import com.example.glovogabrielml.Carrito.ConfirmCompra.ConfirmCompraData;
import com.example.glovogabrielml.Carrito.LoadCarrito.LoadCarritoData;
import com.example.glovogabrielml.Carrito.LoadHistorial.LoadHistorialData;
import com.example.glovogabrielml.CategoryList.LoadByCatData;
import com.example.glovogabrielml.PuntuarRestaurante.PuntuarData;
import com.example.glovogabrielml.RAddItem.AddItemData;
import com.example.glovogabrielml.RHome.LoadItemData;
import com.example.glovogabrielml.RInfo.LoadRInfo.LoadRInfoData;
import com.example.glovogabrielml.RInfo.LoadRProducts.LoadRProductsData;
import com.example.glovogabrielml.RestauranteLogin.RLoginData;
import com.example.glovogabrielml.UHome.LoadCategorias.LoadCatData;
import com.example.glovogabrielml.UHome.LoadTopRating.LoadTopRData;
import com.example.glovogabrielml.UHome.LoadTopVentas.LoadTopVData;
import com.example.glovogabrielml.UsuarioLogin.ULoginData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })

    //Devuelve la ID correspondiente a un restaurante que indiquemos.
    @GET("MyServlet")
    Call<RLoginData> getRLogin(@Query("ACTION") String action, @Query("NOMBRE") String nombre, @Query("CLAVE") String pass);

    //Devuelve la ID correspondiente a un usuario que indiquemos.
    @GET("MyServlet")
    Call<ULoginData> getULogin(@Query("ACTION") String action, @Query("NOMBRE") String nombre, @Query("CONTRASENA") String pass);

    //Devuelve los productos correspondientes a un restaurante.
    @GET("MyServlet")
    Call<ArrayList<LoadItemData>> getMyProducts(@Query("ACTION") String action, @Query("IDRESTAURANTE") int id_restaurante);

    //Devuelve los productos correspondientes a un restaurante en la ventana de detalles del restaurante.
    @GET("MyServlet")
    Call<ArrayList<LoadRProductsData>> getRProducts(@Query("ACTION") String action, @Query("IDRESTAURANTE") int id_restaurante);

    //Obtenemos la información descriptiva de un restaurante.
    @GET("MyServlet")
    Call<LoadRInfoData> getMyRInfo(@Query("ACTION") String action, @Query("IDRESTAURANTE") int id_restaurante);

    //Obtenemos la información descriptiva de un restaurante.
    @GET("MyServlet")
    Call<ConfirmCompraData> confirmCompra(@Query("ACTION") String action, @Query("IDUSUARIO") int idUsuario);

    //Devuelve los restaurantes en orden de ventas.
    @GET("MyServlet")
    Call<ArrayList<LoadTopVData>> getTopVentas(@Query("ACTION") String action);

    //Devuelve los restaurantes en orden de nota media.
    @GET("MyServlet")
    Call<ArrayList<LoadTopRData>> getTopRating(@Query("ACTION") String action);

    //Devuelve las categorias con sus IDs.
    @GET("MyServlet")
    Call<ArrayList<LoadCatData>> getCategorias(@Query("ACTION") String action);

    //Devuelve los productos que tien el usuario en su carrito actual.
    @GET("MyServlet")
    Call<ArrayList<LoadCarritoData>> getMyCarrito(@Query("ACTION") String action, @Query("IDUSUARIO") int id_usuario);

    //Devuelve los restaurantes de una categoría.
    @GET("MyServlet")
    Call<ArrayList<LoadByCatData>> getByCategoria(@Query("ACTION") String action,
                                                  @Query("IDCATEGORIA") int id_categoria,
                                                  @Query("RATE_ORDER") String orden);

    //Devuelve el historial de compras.
    @GET("MyServlet")
    Call<ArrayList<LoadHistorialData>> getMyHistorial(@Query("ACTION") String action, @Query("IDUSUARIO") int id_usuario);

    //Petición de inserción de un usuario, devuelve la cantidad de lineas afectadas, que deberán ser 1.
    @GET("MyServlet")
    Call<AddItemData> insertItem(@Query("ACTION") String action,
                                 @Query("IDRESTAURANTE") Integer id_restaurante,
                                 @Query("NOMBRE") String nombre,
                                 @Query("IMAGEN") String imagen,
                                 @Query("DESCRIPCION") String descripcion,
                                 @Query("PRECIO") Integer precio);

    //Petición de inserción de una puntuación a restaurante, devuelve la cantidad de lineas afectadas, que deberán ser 1.
    @GET("MyServlet")
    Call<PuntuarData> insertRating(@Query("ACTION") String action,
                                   @Query("USUARIO") Integer id_usuario,
                                   @Query("RESTAURANTE") Integer id_restaurante,
                                   @Query("NOTA") Integer nota);
}
