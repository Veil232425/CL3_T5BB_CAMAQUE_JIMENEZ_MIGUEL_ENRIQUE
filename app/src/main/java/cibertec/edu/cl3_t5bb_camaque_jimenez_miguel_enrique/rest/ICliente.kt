package cibertec.edu.cl3_t5bb_camaque_jimenez_miguel_enrique.rest

import cibertec.edu.cl3_t5bb_camaque_jimenez_miguel_enrique.pojo.ObjListum
import cibertec.edu.cl3_t5bb_camaque_jimenez_miguel_enrique.tools.Constantes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface IProveedor {

    @GET(Constantes.GETLISTA_SERVICIO)
    @Headers( "Content-Type: application/json")
    fun getLista(
        @Query(value = "CodigoServicio") pCodigoServicio:Int
        , @Query(value = "NombreCliente") pNombreCliente:String
        , @Query(value = "NumeroOrdenServicio") pNumeroOrdenServcio: String
        , @Query(value = "FechaProgramada") pFechaProgramada: String
        , @Query(value = "Linea") pLinea: String
        , @Query(value = "Estado") pEstado: String
        , @Query(value = "Observaciones") pObservaciones: String
    ): Call<ObjListum>


    @GET(Constantes.GETRegistraModifica_SERVICIO)
    @Headers( "Content-Type: application/json")
    fun getRegistraModifica(
        @Query(value = "pTipoTransaccion") pTipoTransaccion:String
        , @Query(value = "CodigoServicio") CodigoProveedor:Int
        ,@Query(value = "RazonSocial") RazonSocial: String
        ,@Query(value = "Direccion") Direccion: String
        ,@Query(value = "RazonSocial") Ruc: String
    ): Call<ObjListum>

    ///RegistraModifica?pTipoTransaccion=N&CodigoProveedor=0&RazonSocial=abc&Direccion=av.Brasil&Ruc=10343444445



}