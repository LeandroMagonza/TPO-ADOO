package clases;
import java.util.ArrayList;
import java.util.Date;

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
    		int nroPublicacion,
    		String descripcion,
    		Modalidad modalidad,
    		Categoria categoria,
    		String lugar,
    		TipoTrabajo tipoTrabajo,
    		int sueldo,
    		ArrayList<Requisito> requisitos,
    		ArrayList<Tarea> tareasARealizar,
    		Boolean requiereTitulo,
    		Date vigencia,
    		Boolean publicacionActiva) {
    	super();//nose si supuer te guarda los elementos
    	
    }

    
}
