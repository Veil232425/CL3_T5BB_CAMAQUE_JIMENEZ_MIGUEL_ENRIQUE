
package cibertec.edu.cl3_t5bb_camaque_jimenez_miguel_enrique.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjListum implements Serializable, Parcelable
{

    @SerializedName("CodigoServicio")
    @Expose
    private Integer codigoServicio;
    @SerializedName("NombreCliente")
    @Expose
    private String nombreCliente;
    @SerializedName("NumeroOrdenServicio")
    @Expose
    private String numeroOrdenServicio;
    @SerializedName("FechaProgramada")
    @Expose
    private String fechaProgramada;
    @SerializedName("Linea")
    @Expose
    private String linea;
    @SerializedName("Estado")
    @Expose
    private String estado;
    @SerializedName("Observaciones")
    @Expose
    private String observaciones;
    @SerializedName("Eliminado")
    @Expose
    private Boolean eliminado;
    @SerializedName("CodigoError")
    @Expose
    private Integer codigoError;
    @SerializedName("DescripcionError")
    @Expose
    private String descripcionError;
    @SerializedName("MensajeError")
    @Expose
    private Object mensajeError;
    public final static Creator<ObjListum> CREATOR = new Creator<ObjListum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ObjListum createFromParcel(Parcel in) {
            return new ObjListum(in);
        }

        public ObjListum[] newArray(int size) {
            return (new ObjListum[size]);
        }

    }
    ;
    private final static long serialVersionUID = 399847380756190646L;

    protected ObjListum(Parcel in) {
        this.codigoServicio = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nombreCliente = ((String) in.readValue((String.class.getClassLoader())));
        this.numeroOrdenServicio = ((String) in.readValue((String.class.getClassLoader())));
        this.fechaProgramada = ((String) in.readValue((String.class.getClassLoader())));
        this.linea = ((String) in.readValue((String.class.getClassLoader())));
        this.estado = ((String) in.readValue((String.class.getClassLoader())));
        this.observaciones = ((String) in.readValue((String.class.getClassLoader())));
        this.eliminado = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.codigoError = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.descripcionError = ((String) in.readValue((String.class.getClassLoader())));
        this.mensajeError = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public ObjListum() {
    }

    public Integer getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(Integer codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroOrdenServicio() {
        return numeroOrdenServicio;
    }

    public void setNumeroOrdenServicio(String numeroOrdenServicio) {
        this.numeroOrdenServicio = numeroOrdenServicio;
    }

    public String getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(String fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Integer getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(Integer codigoError) {
        this.codigoError = codigoError;
    }

    public String getDescripcionError() {
        return descripcionError;
    }

    public void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }

    public Object getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(Object mensajeError) {
        this.mensajeError = mensajeError;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(codigoServicio);
        dest.writeValue(nombreCliente);
        dest.writeValue(numeroOrdenServicio);
        dest.writeValue(fechaProgramada);
        dest.writeValue(linea);
        dest.writeValue(estado);
        dest.writeValue(observaciones);
        dest.writeValue(eliminado);
        dest.writeValue(codigoError);
        dest.writeValue(descripcionError);
        dest.writeValue(mensajeError);
    }

    public int describeContents() {
        return  0;
    }

}
