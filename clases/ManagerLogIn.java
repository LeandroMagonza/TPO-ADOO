package clases;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ManagerLogIn {
    // atributo
    public Usuario usuarioLogueado;
    private ArrayList<Postulante> listaPostulantes;
    private ArrayList<Empleador> listaEmpleadores;
    private ArrayList<Administrador> listaAdministradores;
    private static ManagerLogIn instanciaLogIn;

    // constructor
    private ManagerLogIn() {
        listaPostulantes = new ArrayList<Postulante>();
        listaEmpleadores = new ArrayList<Empleador>();
        listaAdministradores = new ArrayList<Administrador>();
        leerEmpleadores();

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Checkear Log In
        while (true) {
            System.out.println("Ingrese su usuario:");
            String usuario = scanner.nextLine();
            System.out.printf("Usuario :" + usuario +"\n");
            System.out.println("Ingrese su contrasena:");
            String contrasena = scanner.nextLine();
            System.out.printf("Contrasena :" + contrasena +"\n");
            Usuario usuarioALoguear = getManagerLogIn().checkearLogIn(usuario, contrasena);
            if (usuarioALoguear != null) {
                scanner.close();
                getManagerLogIn().usuarioLogueado = usuarioALoguear;
                getManagerLogIn().usuarioLogueado.abrirMenu();
                break;
            }
            System.out.println("Nombre de usuario o contrasena incorrectas");
        }
    }

    public static ManagerLogIn getManagerLogIn() {
        if (instanciaLogIn == null) {
            instanciaLogIn = new ManagerLogIn();
        }
        return instanciaLogIn;
    }

    public Usuario checkearLogIn(String mail, String password) {

        for (Empleador empleador : listaEmpleadores) {
            if (empleador.mail.equals(mail) && empleador.contrasena.equals(password)) {
            	return empleador;
            }
        }
        return null;
    }

  
    public Boolean leerEmpleadores() {
        try {
        	//borre src solo par martin
            FileReader entrada = new FileReader("almacenamientos/empleadores.txt");
            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = "";
            Empleador empleador;
            miBuffer.readLine();
            while (linea != null) {
                linea = miBuffer.readLine();
                if (linea != null) {
                    String[] arrayLinea = linea.split(";");
                    empleador = new Empleador(Integer.parseInt(arrayLinea[0]), arrayLinea[1], arrayLinea[2],
                            arrayLinea[3], arrayLinea[4], arrayLinea[5], arrayLinea[6]);
                    listaEmpleadores.add(empleador);
                }
            }
            entrada.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }


     public Boolean grabarEmpleador(){
      try{
      		FileWriter escritura = new FileWriter ("src/empeladores.txt");
      		for (Empleador a: listaEmpleadores)
      		{
      			String texto = Integer.toString(a.dni)+";"+a.nombre+";"+a.apellido+";"+a.mail+";"+a.contrasena+";"+a.sector+";"+a.empresa;
      			escritura.write(texto+"\n");
      		}
      
      		escritura.close();
      		return true;
      	} catch (IOException e){
      		return false;
      		}
      }
     
   
     //ver idioma en adelante.
     //ver como pasar fechaNacimiento a string
     public Boolean grabarPostulante(){
         try{
         		FileWriter escritura = new FileWriter ("src/postulante.txt");
         		for (Postulante p: listaPostulantes)
         		{
         		
         			String texto = Integer.toString(p.dni)+";"+p.nombre+";"+p.apellido+";"+p.mail+";"+p.contrasena+";"+p.fechaNacimiento+";"+p.idiomas+";"+p.intereses+";"+p.nacionalidades+";"+p.publicacionesFavoritas;
         			escritura.write(texto+"\n");
         		}
         
         		escritura.close();
         		return true;
         	} catch (IOException e){
         		return false;
         		}
         }
   
     
     //ver como pasar fechainicio a string
    public Boolean grabarAdministrador(){
         try{
         		FileWriter escritura = new FileWriter ("src/administrador.txt");
         		for (Administrador a: listaAdministradores)
         		{
         			String texto = a.dni+";"+a.nombre+";"+a.apellido+";"+a.mail+";"+a.contrasena+";"+a.estado+";"+a.fechaInicio;
         			escritura.write(texto+"\n");
         		}
         
         		escritura.close();
         		return true;
         	} catch (IOException e){
         		return false;
         		}
         }

         

        
        
}
