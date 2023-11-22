package com.example.glovogabrielml.Utils;

import com.example.glovogabrielml.RAddItem.AddItemData;
import com.example.glovogabrielml.RHome.LoadItemData;
import com.example.glovogabrielml.RestauranteLogin.RLoginData;
import com.example.glovogabrielml.UHome.LoadTopVData;
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

    //Devuelve los restaurantes en orden de ventas.
    @GET("MyServlet")
    Call<ArrayList<LoadTopVData>> getTopVentas(@Query("ACTION") String action);

    //Petición de inserción de un usuario, devuelve la cantidad de lineas afectadas, que deberán ser 1.
    @GET("MyServlet")
    Call<AddItemData> insertItem(@Query("ACTION") String action,
                                 @Query("IDRESTAURANTE") Integer id_restaurante,
                                 @Query("NOMBRE") String nombre,
                                 @Query("IMAGEN") String imagen,
                                 @Query("DESCRIPCION") String descripcion,
                                 @Query("PRECIO") Integer precio);
}
