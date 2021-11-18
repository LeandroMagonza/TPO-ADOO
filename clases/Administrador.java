package clases;
import java.util.Date;

public class Administrador extends Usuario {
   
	Boolean estado;
    Date fechaInicio;
    
    public Administrador(int dni, String nombre, String apellido, String mail, String contrasena) {
		super(dni, nombre, apellido, mail, contrasena);
		this.estado = estado;
		
	}
    
    public void abrirMenu() {
    	System.out.println("logueado como: Administrador");
    	MenuEmpleador.mostrarMenu();
    }
}
