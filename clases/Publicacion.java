package clases;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
//String sDate1="31/12/1998";  formato en string

public class Publicacion {
	private Estado estado;
    private int nroPublicacion;
    private Empresa empresa;
    private String descripcion;
    private Modalidad modalidad;
    private Categoria categoria;
    private String lugar;
    private TipoTrabajo tipoTrabajo;
    private int sueldo;
    private ArrayList<Requisito> requisitos = new ArrayList<Requisito>();
    private ArrayList<Tarea> tareasARealizar = new ArrayList<Tarea>();
    private Boolean requiereTitulo;
    private Date vigencia;
    private ArrayList<Postulacion> postulaciones = new ArrayList<Postulacion>();
    public Publicacion(
    		int nroPublicacion, 
			Empresa empresa, 
			String descripcion,	
			Modalidad modalidad,
    		Categoria categoria, 
			String lugar, 
			TipoTrabajo tipoTrabajo,
    		int sueldo, 
			String requisitosStr, 
			String tareasARealizarStr,
    		boolean requiereTitulo, 
			int cantDiasDeVigencia)  {
		// SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");  
		this.nroPublicacion = nroPublicacion;
		this.empresa = empresa;
		this.descripcion = descripcion;
		this.modalidad = modalidad;
		this.categoria = categoria;
		this.lugar = lugar;
		this.tipoTrabajo = tipoTrabajo;
		this.sueldo = sueldo;
		// this.requisitos = ManagerRequisito.dividir(requisitosStr);
		// this.tareasARealizar = ManagerTarea.dividir(tareasARealizarStr);
		this.cambiarEstado(new EstadoAbierta(cantDiasDeVigencia));
		this.requiereTitulo = requiereTitulo;
		// this.postulaciones = ManagerPostulacion.dividir(postulacionesStr);
    	
    	
    }
    
	public int getNroPublicacion() {
		return nroPublicacion;
	}
	public Estado getEstado() {
		return estado;
	}
	public int getDiasRestantes() {
		return estado.getCantDiasDeVigencia();
	}
	public long getNroEmpresa() {
		return empresa.cuitEmpresa;
	}
	public Empresa getEmpresa() {
		return empresa;
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
	public ArrayList<Postulacion> getPostulaciones() {
		return postulaciones;
	}
	public void setPostulaciones(ArrayList<Postulacion> postulaciones) {
		this.postulaciones = postulaciones;
	}

	public void abrir(){
		estado.abrir(this);
    }
    public void cerrar(){
		estado.cerrar(this);
    }
    public void postular(Postulante postulante){
		estado.postular(this,postulante);
    }
	public void cambiarEstado(Estado nuevoEstado){
		estado = nuevoEstado;
	}
	public void pasarDia(){
		estado.pasarDia(this);
	}

    
}
