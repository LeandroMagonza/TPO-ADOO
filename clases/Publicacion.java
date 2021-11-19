package clases;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
//String sDate1="31/12/1998";  formato en string

public class Publicacion {
    private int nroPublicacion;
    private int cuitEmpresa;
    private String descripcion;
    private Modalidad modalidad;
    private Categoria categoria;
    private String lugar;
    private TipoTrabajo tipoTrabajo;
    private int sueldo;
    private ArrayList<Requisito> requisitos = new ArrayList<Requisito>();
    private ArrayList<Tarea> tareasARealizar =new ArrayList<Tarea>();;
    private Boolean requiereTitulo;
    private Date vigencia;
    private Boolean publicacionActiva;
	private ArrayList<Postulacion> postulaciones;

    public Publicacion(
    		int nroPublicacion, 
			int cuitEmpresa, 
			String descripcion,	
			String modalidadStr,
    		String categoriaStr, 
			String lugar, 
			String tipoTrabajoStr,
    		int sueldo, 
			String requisitosStr, 
			String tareasARealizarStr,
    		boolean requiereTitulo, 
			String vigenciaStr, 
			boolean publicacionActiva, 
			String postulacionesStr) throws Exception {
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");  
		this.nroPublicacion = nroPublicacion;
		this.cuitEmpresa = cuitEmpresa;
		this.descripcion = descripcion;
		this.modalidad = Modalidad.transform(modalidadStr);
		this.categoria = Categoria.transform(categoriaStr);
		this.lugar = lugar;
		this.tipoTrabajo = TipoTrabajo.transform(tipoTrabajoStr);
		this.sueldo = sueldo;
		// this.requisitos = ManagerRequisito.dividir(requisitosStr);
		// this.tareasARealizar = ManagerTarea.dividir(tareasARealizarStr);
		this.requiereTitulo = requiereTitulo;
		this.vigencia= formatter1.parse(vigenciaStr);  
    	this.publicacionActiva = publicacionActiva;
		this.postulaciones = ManagerPostulacion.dividir(postulacionesStr);
    	
    	
    }
    
	public int getNroPublicacion() {
		return nroPublicacion;
	}
	public int getNroEmpresa() {
		return cuitEmpresa;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Modalidad getModalidad() {
		return modalidad;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public String getLugar() {
		return lugar;
	}
	public TipoTrabajo getTipoTrabajo() {
		return tipoTrabajo;
	}
	public int getSueldo() {
		return sueldo;
	}
	public ArrayList<Requisito> getRequisitos() {
		return requisitos;
	}
	public ArrayList<Tarea> getTareasARealizar() {
		return tareasARealizar;
	}
	public Boolean getRequiereTitulo() {
		return requiereTitulo;
	}
	public Date getVigencia() {
		return vigencia;
	}
	public Boolean getPublicacionActiva() {
		return publicacionActiva;
	}
	public ArrayList<Postulacion> getPostulaciones() {
		return postulaciones;
	}
    
    

    
}
