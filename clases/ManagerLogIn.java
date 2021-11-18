package clases;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat; 
import java.text.ParseException;

public class ManagerLogIn {
    // atributo
    public Usuario usuarioLogueado;
    private ArrayList<Postulante> listaPostulantes;
    private ArrayList<Empleador> listaEmpleadores;
    private ArrayList<Administrador> listaAdministradores;
    private static ManagerLogIn instanciaLogIn;
    public static Scanner scanner = new Scanner(System.in);
    // constructor
    private ManagerLogIn() {
        listaPostulantes = new ArrayList<Postulante>();
        listaEmpleadores = new ArrayList<Empleador>();
        listaAdministradores = new ArrayList<Administrador>();
        leerEmpleadores();

    }
    public static void main(String[] args) {
        
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
                getManagerLogIn().usuarioLogueado = usuarioALoguear;
                getManagerLogIn().usuarioLogueado.abrirMenu();
                break;
            }
            System.out.println("Nombre de usuario o contrasena incorrectas");
        }
        scanner.close();
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
            FileReader entrada = new FileReader("src/almacenamientos/empleadores.txt");
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
                    System.out.println(empleador.mail);
                }
            }
            entrada.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // Leer Administrador
    //Boolean estado; 
    //Date fechaInicio;

    public Boolean leerAdministrador()throws Exception {
        try {
            FileReader entrada = new FileReader("almacenamientos/administrador.txt");
            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = "";
            Administrador administrador;
            miBuffer.readLine();
            while (linea != null) {
                linea = miBuffer.readLine();
                if (linea != null) {
                    String[] arrayLinea = linea.split(";");
                    SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy"); 
                    Date fechainicio = formatter1.parse(arrayLinea[6]);
                    Boolean bull  = true;
                    String myString = arrayLinea[5];
                    if ("true".equals(myString)){
                        bull = true;
                    }
                    else{
                        bull = false;
                    }
                    administrador = new Administrador(Integer.parseInt(arrayLinea[0]), arrayLinea[1], arrayLinea[2],
                            arrayLinea[3], arrayLinea[4], bull, fechainicio);
                    listaAdministradores.add(administrador);
                }
            }
            entrada.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    
    // Leer Postulante
   
    public Boolean leerPostulante()throws Exception {
        try {
            FileReader entrada = new FileReader("almacenamientos/postulante.txt");
            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = "";
            Postulante postulante;
            miBuffer.readLine();
            while (linea != null) {
                linea = miBuffer.readLine();
                if (linea != null) {
                    String[] arrayLinea = linea.split(";");
                    SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy"); 
                    Date fechaNacimiento = formatter1.parse(arrayLinea[5]);
                    postulante = new Postulante(Integer.parseInt(arrayLinea[0]), arrayLinea[1], arrayLinea[2],
                            arrayLinea[3], arrayLinea[4], fechaNacimiento);
                    listaPostulantes.add(postulante);
                }
            }
            entrada.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }




    
}
