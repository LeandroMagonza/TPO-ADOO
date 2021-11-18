package clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Postulacion {
    int nroPostulacion;
    Postulante postulante;
    Publicacion publicacion;
    int sueldoPretendido;
    Boolean cumpleRequisitos;
    Date fecha;
    
    public Postulacion(int nroPostulacion, int dniPostulante, int nroPublicacion, int sueldo,
    		boolean cumpleRequisitos, String Fecha ) throws ParseException {
    	SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy"); 
    	this.nroPostulacion = nroPostulacion;
    	this.postulante = ManagerLogIn.devolverPostulante(dniPostulante);
    	this.publicacion = ManagerPublicacion.buscar(nroPublicacion);
    	this.sueldoPretendido = sueldo;
    	this.cumpleRequisitos = cumpleRequisitos;
    	this.fecha = formatter1.parse(Fecha);
    }

	public int getNroPostulacion() {
		return nroPostulacion;
	}

	public Postulante getPostulante() {
		return postulante;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public int getSueldoPretendido() {
		return sueldoPretendido;
	}

	public Boolean getCumpleRequisitos() {
		return cumpleRequisitos;
	}

	public Date getFecha() {
		return fecha;
	}
    
    
}
