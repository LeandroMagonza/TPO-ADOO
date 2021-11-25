package clases;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

public class EstadoAbierta extends Estado {
    int cantDiasDeVigencia;
    public EstadoAbierta(int cantDiasDeVigencia){
        this.cantDiasDeVigencia = cantDiasDeVigencia;
    }
    public EstadoAbierta(){
        this.cantDiasDeVigencia = 60;
    }
    public int getCantDiasDeVigencia(){
        return cantDiasDeVigencia;
    }
    public void cerrar(Publicacion publicacion){
        publicacion.cambiarEstado(new EstadoCerrada());
    }
    /*
     * Chequear porque nose si esto modifica o no a la publicacion original,
     * en caso de no hacerlo generé un agregarPostulacion en ManagerPublicacion lo cual
     * si directamente corremos eso mandando la publicacion y todo te anda.
     * 
     */
    public void postular(Publicacion publicacion,Postulante postulante){
    	Postulacion postulacion = new Postulacion(postulante,true);
    	ArrayList<Postulacion> lista = publicacion.getPostulaciones();
    	lista.add(postulacion);
    	publicacion.setPostulaciones(lista);
    	
    }
    public void pasarDia(Publicacion publicacion){
        cantDiasDeVigencia--;
        if (cantDiasDeVigencia == 0) {
            cerrar(publicacion);
        }
    }
}
