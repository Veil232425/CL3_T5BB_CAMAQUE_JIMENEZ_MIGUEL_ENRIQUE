package cibertec.edu.cl3_t5bb_camaque_jimenez_miguel_enrique.Adaptador
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cibertec.edu.cl3_t5bb_camaque_jimenez_miguel_enrique.R
import cibertec.edu.cl3_t5bb_camaque_jimenez_miguel_enrique.pojo.ObjListum
import kotlinx.android.synthetic.main.registro_cliente.view.*

public class AdaptadorServicio(val ListaInterna:List<ObjListum>, val clickListener: (ObjListum) -> Unit):RecyclerView.Adapter<AdaptadorServicio.AdaptadorServicioViewHolder>() {
    var onItemClick: ((ObjListum) -> Unit)? = null
    public class AdaptadorServicioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bindItems(oObjListaServicio: ObjListum)
        {
            val tvTextoSuperior = itemView.findViewById(R.id.edTextNroServicio) as TextView
            val tvTextoDescripcion = itemView.findViewById(R.id.edTextClienteServicio) as TextView
            val tvTextoInferior = itemView.findViewById(R.id.edTextFechaServicio) as TextView
            tvTextoSuperior.text = oObjListaServicio.numeroOrdenServicio.toString()
            tvTextoDescripcion.text =  oObjListaServicio.nombreCliente.toString()
            tvTextoInferior.text = oObjListaServicio.fechaProgramada.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorServicioViewHolder {
        val v: View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.registro_cliente,parent,false)
        return AdaptadorServicioViewHolder(v)
    }
    override fun getItemCount(): Int {
        return ListaInterna.size
    }
    override fun onBindViewHolder(holder: AdaptadorServicioViewHolder, position: Int) {
        holder?.itemView.edTextNroServicio?.text  = ListaInterna.get(position).numeroOrdenServicio.toString()
        holder?.itemView.edTextClienteServicio?.text =  ListaInterna.get(position).nombreCliente.toString()
        holder?.itemView.edTextFechaServicio?.text = ListaInterna.get(position).fechaProgramada.toString()
        holder?.itemView?.setOnClickListener { clickListener(ListaInterna.get(position)) }
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var tvTitle: TextView = itemView.findViewById(R.id.edTextNroServicio)
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(ListaInterna[adapterPosition])
            }
        }
        override fun onClick(v: View) {
            onItemClick?.invoke(ListaInterna[adapterPosition])
        }
    }
}