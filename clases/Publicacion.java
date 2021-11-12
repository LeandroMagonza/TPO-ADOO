package clases;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
//String sDate1="31/12/1998";  formato en string

public class Publicacion {
    int nroPublicacion;
    String descripcion;
    Modalidad modalidad;
    Categoria categoria;
    String lugar;
    TipoTrabajo tipoTrabajo;
    int sueldo;
    ArrayList<Requisito> requisitos;
    ArrayList<Tarea> tareasARealizar;
    Boolean requiereTitulo;
    Date vigencia;
    Boolean publicacionActiva;
    public Publicacion(
    		int nroPublicacion, String descripcion,	String modalidadStr,
    		String categoriaStr, String lugar, String tipoTrabajoStr,
    		int sueldo, String requisitosStr, String tareasARealizarStr,
    		boolean requiereTitulo, String vigenciaStr, boolean publicacionActiva) throws Exception {
    	SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
    	this.nroPublicacion = nroPublicacion;
    	this.descripcion = descripcion;
    	this.modalidad = Modalidad.transform(modalidadStr);
    	this.categoria = Categoria.transform(categoriaStr);
    	this.lugar = lugar;
    	this.tipoTrabajo = TipoTrabajo.transform(tipoTrabajoStr);
    	this.sueldo = sueldo;
    	this.requisitos = ManagerRequisito.dividir(requisitosStr);
    	this.tareasARealizar = ManagerTarea.dividir(tareasARealizarStr);
    	this.requiereTitulo = requiereTitulo;
    	this.vigencia= formatter1.parse(vigenciaStr);  
    	this.publicacionActiva = publicacionActiva;
    	
    	
    }

    

    
}
