package clases;

public class EstadoAbierta extends Estado {
    int cantDiasDeVigencia;
    public EstadoAbierta(int cantDiasDeVigencia){
        this.cantDiasDeVigencia = cantDiasDeVigencia;
    }
    public EstadoAbierta(){
        this.cantDiasDeVigencia = 60;
    }
    public void cerrar(Publicacion publicacion){
        publicacion.cambiarEstado(new EstadoCerrada());
    }
    public void postular(Publicacion publicacion,Postulante postulante){

    }
    public void pasarDia(Publicacion publicacion){
        cantDiasDeVigencia--;
        if (cantDiasDeVigencia == 0) {
            cerrar(publicacion);
        }
    }
}
