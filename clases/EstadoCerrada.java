package clases;

public class EstadoCerrada extends Estado {
    public void abrir(Publicacion publicacion){
        if (publicacion.getPostulaciones().size() == 0) {
            publicacion.cambiarEstado(new EstadoAbierta());
        }
        return;
    }
}
