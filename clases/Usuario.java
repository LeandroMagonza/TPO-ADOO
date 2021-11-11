package clases;

public class Usuario {
	int dni;
	String nombre;
	String apellido;
	String contrasena;
	String mail;

	public Usuario( int dni,String nombre, String apellido, String mail,String contrasena){
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.contrasena = contrasena;
		this.mail = mail;
	}
}
