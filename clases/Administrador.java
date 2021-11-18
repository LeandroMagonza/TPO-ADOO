package clases;
import java.util.Date;


public class Administrador extends Usuario {
    Boolean estado;
    Date fechaInicio;


    public Administrador(int dni,String nombre,String apellido,String mail, String contrasena,Boolean estado,Date fechainicio){
        super(dni,nombre,apellido,mail,contrasena);
        this.estado = estado;
        this.fechaInicio = fechainicio;
    }

    public void abrirMenu(){
        System.out.println("logueado como: Administador");
        MenuEmpleador.mostrarMenu();
        
    }
}
