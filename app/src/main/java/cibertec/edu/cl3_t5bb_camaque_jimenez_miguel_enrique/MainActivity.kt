package com.example.wslistadoproveedores

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cibertec.edu.cl3_t5bb_camaque_jimenez_miguel_enrique.Adaptador.AdaptadorServicio
import cibertec.edu.cl3_t5bb_camaque_jimenez_miguel_enrique.R
import cibertec.edu.cl3_t5bb_camaque_jimenez_miguel_enrique.pojo.ObjListum
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    lateinit var oLista:List<ObjListum>
    lateinit var oAdaptadorServicio: AdaptadorServicio
    var TIPOACCION:String = "N"

    lateinit var oNuevoServicio: Dialog
    lateinit var oContexto: Context
    lateinit var oObjPROVEEDOR: ObjListaPROVEEDOR


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        oContexto=this
        btnBuscar.setOnClickListener()
        {
            ConsultarVolley()
            //buscarProveedor();
        }

        btnNuevo.setOnClickListener()
        {
            CargarVentanaProveedor();
        }
    }

  /*  public fun buscarProveedor()
    {
        oLista = ArrayList<ObjListaPROVEEDOR>();
        val oIProveedor: IProveedor
        oIProveedor = RestProveedor().getPROVEEDOR()!!.create( IProveedor::class.java )
        val call: Call<PROVEEDORRESPONSE> = oIProveedor.getLista( 0,
            edtRazonSocial.text.toString(),
            "","")

        call.enqueue(object : Callback<PROVEEDORRESPONSE?> {
            override fun onResponse( call: Call<PROVEEDORRESPONSE?>?,
                                     response: retrofit2.Response<PROVEEDORRESPONSE?>
            ) {
                Log.d("body", response.body().toString())
                try {
                    oLista = response.body()!!.objListaPROVEEDOR
                    MostrarListado()
                } catch (e: java.lang.Exception) {
                    Log.d("app", e.toString())
                }
            }

            override fun onFailure(
                call: Call<PROVEEDORRESPONSE?>?,
                t: Throwable
            ) {
                Log.d("ERROR", t.toString())
            }
        })
    }


*/
    public fun CargarVentanaProveedor()
    {
        oNuevoServicio = Dialog(oContexto)
        oNuevoServicio.requestWindowFeature(Window.FEATURE_NO_TITLE)
        oNuevoServicio.setCancelable(false)
        oNuevoServicio.setContentView(R.layout.activity_registro_servicio)
        // CargarRegistro()
        val obtnagregarNuevoprov = oNuevoServicio.findViewById(R.id.btnAprobar) as Button
        val obtnCancelarNuevoprov = oNuevoServicio.findViewById(R.id.btnCancelar) as Button
        obtnagregarNuevoprov.setOnClickListener {
            GrabarRegistro()
            oNuevoServicio.dismiss() }
        obtnCancelarNuevoprov.setOnClickListener { oNuevoServicio.dismiss() }
        oNuevoServicio.show()
    }

    fun GrabarRegistro()
    {
        val oedtNroServicio = oNuevoServicio.findViewById(R.id.txtOrden) as EditText
        val oedtClienteServicio = oNuevoServicio.findViewById(R.id.txtCliente) as EditText
        val oedFechaProgramada = oNuevoServicio.findViewById(R.id.txtFechaProgramada) as EditText

        if (TIPOACCION == "N")
        {
            oObjPROVEEDOR = ObjListaPROVEEDOR()
            oObjPROVEEDOR.codigoProveedor=0;
        }

        oObjPROVEEDOR.razonSocial = oedtrazonsocialnuevo.text.toString()
        oObjPROVEEDOR.direccion = oedtdireccionnuevo.text.toString()
        oObjPROVEEDOR.ruc = oedtrucnuevo.text.toString()

        val oIProveedor: IProveedor
        oIProveedor = RestProveedor().getPROVEEDOR()!!.create( IProveedor::class.java )
        val call: Call<ObjPROVEEDOR> = oIProveedor.getRegistraModifica( TIPOACCION,oObjPROVEEDOR.codigoProveedor,
            oObjPROVEEDOR.razonSocial,
            oObjPROVEEDOR.direccion,
            oObjPROVEEDOR.ruc)

        call.enqueue(object : Callback<ObjPROVEEDOR?> {
            override fun onResponse( call: Call<ObjPROVEEDOR?>?,
                                     response: retrofit2.Response<ObjPROVEEDOR?>
            ) {
                Log.d("body", response.body().toString())
                try {
                    oObjPROVEEDOR.codigoProveedor = response.body()!!.codigoProveedor
                    ConsultarPRoveedores()
                } catch (e: java.lang.Exception) {
                    Log.d("app", e.toString())
                }
            }

            override fun onFailure(
                call: Call<ObjPROVEEDOR?>?,
                t: Throwable
            ) {
                Log.d("ERROR", t.toString())
            }
        })


    }

    fun MostrarRegistro()
    {
        var oedtrazonsocialnuevo = oNuevoPRoveedor.findViewById(R.id.edtrazonsocialnuevo) as EditText
        var oedtdireccionnuevo = oNuevoPRoveedor.findViewById(R.id.edtdireccionnuevo) as EditText
        var oedtrucnuevo = oNuevoPRoveedor.findViewById(R.id.edtrucnuevo) as EditText


        oedtrazonsocialnuevo.setText(oObjPROVEEDOR.razonSocial)
        oedtdireccionnuevo.setText(oObjPROVEEDOR.direccion)
        oedtrucnuevo.setText(oObjPROVEEDOR.ruc)

    }

    fun MostrarListado()
    {
        oAdaptadorProveedor= AdaptadorPROVEEDOR(oLista)
        {
            oObjPROVEEDOR = it
            TIPOACCION = "A"
            CargarVentanaProveedor()
            MostrarRegistro()
        }
        lvListaProveedor.setAdapter(oAdaptadorProveedor)


        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        lvListaProveedor.setLayoutManager(llm)
        lvListaProveedor.setHasFixedSize(true)
        lvListaProveedor.setAdapter(oAdaptadorProveedor)
    }


    fun ConsultarVolley()
    {
        var oVolley= Volley.newRequestQueue(this)
        var strUrl=Constantes.ENDPOINT + Constantes.GETLISTA_PROVEEDOR
/*
        val objJson=JsonObjectRequest(strUrl,null,
            com.android.volley.Response.Listener {

                Log.d("app",it.toString())
                //print("Response is: ${it.getJSONArray("ObjListaPROVEEDOR")}")
            },
            com.android.volley.Response.ErrorListener {
                Log.d("app","Error:" + it.message)
                print("Response is: ${it.message}")
            }
        )
        oVolley.add(objJson)
*/
        /*
        val stringRequest = StringRequest(
            Request.Method.GET, strUrl,
           com.android.volley.Response.Listener<String> { response ->
                print("Response is: ${response}")
            },
            com.android.volley.Response.ErrorListener {
                print("Response is: ${it.message}") })

        // Add the request to the RequestQueue.
        oVolley.add(stringRequest)
*/
        val params = HashMap<String,String>()
        params["RazonSocial"] = edtRazonSocial.text.toString()

        var objRequest=ObjectRequest<PROVEEDORRESPONSE>(Request.Method.GET,
            strUrl,
            params as Map<String, Any>?,
            PROVEEDORRESPONSE::class.java,
            Response.Listener {
                oLista = it.objListaPROVEEDOR
                MostrarListado()
            },
            Response.ErrorListener {
                print("Response is: ${it.message}")
            }
        )
        oVolley.add(objRequest)
    }


    fun ConsultarPRoveedores()
    {
        var oVolley= Volley.newRequestQueue(this)
        var strUrl=Constantes.ENDPOINT + Constantes.GETLISTA_PROVEEDOR

        val params = HashMap<String,String>()
        params["RazonSocial"] = edtRazonSocial.text.toString()

        var objRequest=ObjectRequest<PROVEEDORRESPONSE>(Request.Method.GET,
            strUrl,
            params as Map<String, Any>?,
            PROVEEDORRESPONSE::class.java,
            Response.Listener {
                oLista = it.objListaPROVEEDOR
                MostrarListado()
            },
            Response.ErrorListener {
                print("Response is: ${it.message}")
            }
        )
        oVolley.add(objRequest)
    }
}