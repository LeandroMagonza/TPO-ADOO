package clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Postulacion {
    Postulante postulante;
    Boolean cumpleRequisitos;
    Date fecha;
    
    public Postulacion(Postulante postulante, boolean cumpleRequisitos ) {
    	//SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy"); 
    	this.postulante = postulante;
    	this.cumpleRequisitos = cumpleRequisitos;
    	//this.fecha = formatter1.parse(Fecha);
    	this.fecha = new Date();
    	
    }

	public Postulante getPostulante() {
		return postulante;
	}

	public Boolean getCumpleRequisitos() {
		return cumpleRequisitos;
	}

	public Date getFecha() {
		return fecha;
	}
    
    
}
