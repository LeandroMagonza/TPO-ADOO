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
    private static ArrayList<Postulante> listaPostulantes;
    private ArrayList<Empleador> listaEmpleadores;
    private ArrayList<Administrador> listaAdministradores;
    private static ManagerLogIn instanciaLogIn;
    public static Scanner scanner = new Scanner(System.in);

    // constructor
    private ManagerLogIn() {
        listaPostulantes = new ArrayList<Postulante>();
        listaEmpleadores = new ArrayList<Empleador>();
        listaAdministradores = new ArrayList<Administrador>();
        try {
            // date Exception
            leerEmpleadores();
            leerAdministradores();
            leerPostulantes();
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {
        int respuesta = -1;
        mainLoop:
        while (true){
            switch (respuesta) {
                case 1:
                    loguearse();
                    respuesta = -1;
                    break;
                case 2:
                    registrarse();
                    respuesta = -1;
                    break;
                case 0:
                    break mainLoop;
                default:
                    System.out.println("Seleccione una opcion:");
                    System.out.println("1. Loguearse:");
                    System.out.println("2. Registrarse:");
                    System.out.println("0. Salir:");
                    respuesta = scanner.nextInt();
                    scanner.nextLine();
                    break;
            }
            
        }
        
    }
    public static void loguearse(){
        while (true) {
            System.out.println("Ingrese su usuario:");
            String usuario = scanner.nextLine();
            System.out.printf("Usuario :" + usuario + "\n");
            if ("0".equals(usuario)) {
                scanner.close();
                break;
            }
            System.out.println("Ingrese su contrasena:");
            String contrasena = scanner.nextLine();
            System.out.printf("Contrasena :" + contrasena + "\n");
            Usuario usuarioALoguear = getManagerLogIn().checkearLogIn(usuario, contrasena);
            if (usuarioALoguear != null) {
                getManagerLogIn().usuarioLogueado = usuarioALoguear;
                getManagerLogIn().usuarioLogueado.abrirMenu();
                getManagerLogIn().usuarioLogueado = null;
            } else {
                System.out.println("Nombre de usuario o contrasena incorrectas");
            }
        }
    }
    public static void registrarse(){
        while (true) {
            System.out.println("Ingrese su mail:");
            String usuario = scanner.nextLine();
            while (!getManagerLogIn().checkearMailDisponible(usuario)){
                System.out.println("Este mail se encuentra ocupado, intente nuevamente:");
                usuario = scanner.nextLine();
            }
            
            System.out.println("Ingrese su nueva contrasena:");
            String contrasena = scanner.nextLine();
            System.out.printf("Contrasena :" + contrasena + "\n");


            Usuario usuarioALoguear = getManagerLogIn().checkearLogIn(usuario, contrasena);
            if (usuarioALoguear != null) {
                getManagerLogIn().usuarioLogueado = usuarioALoguear;
                getManagerLogIn().usuarioLogueado.abrirMenu();
                getManagerLogIn().usuarioLogueado = null;
            } else {
                System.out.println("Nombre de usuario o contrasena incorrectas");
            }
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
        for (Postulante postulante : listaPostulantes) {
            if (postulante.mail.equals(mail) && postulante.contrasena.equals(password)) {
                return postulante;
            }
        }
        for (Administrador administrador : listaAdministradores) {
            if (administrador.mail.equals(mail) && administrador.contrasena.equals(password)) {
                return administrador;
            }
        }
        return null;
    }
    public Boolean checkearMailDisponible(String mail) {

        for (Empleador empleador : listaEmpleadores) {
            if (empleador.mail.equals(mail)) {
                return false;
            }
        }
        for (Postulante postulante : listaPostulantes) {
            if (postulante.mail.equals(mail)) {
                return false;
            }
        }
        for (Administrador administrador : listaAdministradores) {
            if (administrador.mail.equals(mail)) {
                return false;
            }
        }
        return true;
    }

    public Boolean leerEmpleadores() {
        try {
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
                            arrayLinea[3], arrayLinea[4], arrayLinea[5], Integer.parseInt(arrayLinea[6]));
                    listaEmpleadores.add(empleador);
                }
            }
            entrada.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public Boolean leerPostulantes() throws Exception {
        FileReader entrada = new FileReader("src/almacenamientos/postulantes.txt");
        BufferedReader miBuffer = new BufferedReader(entrada);
        String linea = "";
        miBuffer.readLine();
        Postulante postulante;
        while (linea != null) {
            linea = miBuffer.readLine();
            if (linea != null) {
                String[] arrayLinea = linea.split(";");
                SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaNacimiento = formatter1.parse(arrayLinea[5]);
                ArrayList<Categoria> intereses = new ArrayList<Categoria>();
                String[] interesesAProcesar = arrayLinea[6].split("/");
                for (String interesString : interesesAProcesar) {
                    intereses.add(Categoria.transform(interesString));
                }
                postulante = new Postulante(Integer.parseInt(arrayLinea[0]), arrayLinea[1], arrayLinea[2],
                        arrayLinea[3], arrayLinea[4], fechaNacimiento, intereses);
                listaPostulantes.add(postulante);
            }
        }
        entrada.close();
        return true;
    }

    public Boolean grabarEmpleadores() {
        try {
            FileWriter escritura = new FileWriter("src/almacenamientos/empleadores.txt");
            for (Empleador a : listaEmpleadores) {
                String texto = Integer.toString(a.dni) + ";" + 
                a.nombre + ";" + 
                a.apellido + ";" + 
                a.mail + ";" + 
                a.contrasena + ";" + 
                a.sector + ";" + 
                a.empresa;
                escritura.write(texto + "\n");
            }

            escritura.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // ver como pasar fechaNacimiento a string
    public Boolean grabarPostulantes() {

        try {
            FileReader entrada = new FileReader("src/almacenamientos/postulantes.txt");
            BufferedReader miBuffer = new BufferedReader(entrada);
            String cabecera = miBuffer.readLine();
            FileWriter escritura = new FileWriter("src/almacenamientos/postulantes.txt");
            escritura.write(cabecera);
            for (Postulante p : listaPostulantes) {

                String texto = Integer.toString(p.dni) + ";" + 
                p.nombre + ";" + 
                p.apellido + ";" + 
                unirIdiomas(p.idiomas) + ";" + 
                unirIntereses(p.intereses) + ";" + 
                unirNacionalidades(p.nacionalidades) + ";" + 
                unirPublicacionesFavoritas(p.publicacionesFavoritas);
                escritura.write(texto + "\n");
            }

            escritura.close();
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    public static String unirIdiomas(ArrayList<Idioma> idiomas) {
        String idiomaStr = "";
        for (Idioma i : idiomas) {
            idiomaStr = idiomaStr + ":" + i;
        }
        return idiomaStr;

    }

    public static String unirNacionalidades(ArrayList<Nacionalidad> nacionalidades) {
        String nacionalidadStr = "";
        for (Nacionalidad i : nacionalidades) {
            nacionalidadStr = nacionalidadStr + ":" + i;
        }
        return nacionalidadStr;

    }

    public static String unirIntereses(ArrayList<Categoria> intereses) {
        String interesesStr = "";
        for (Categoria i : intereses) {
            interesesStr = interesesStr + ":" + i;
        }
        return interesesStr;

    }

    public static String unirPublicacionesFavoritas(ArrayList<Publicacion> publicacionesFavoritas) {
        String pubfavStr = "";
        for (Publicacion i : publicacionesFavoritas) {
            pubfavStr = pubfavStr + ":" + i;
        }
        return pubfavStr;

    }

    // ver como pasar fechainicio a string
    public Boolean grabarAdministradores() {
        try {
            FileWriter escritura = new FileWriter("src/almacenamientos/administrador.txt");
            for (Administrador a : listaAdministradores) {
                String texto = a.dni + ";" + 
                a.nombre + ";" + 
                a.apellido + ";" + 
                a.mail + ";" + 
                a.contrasena + ";" + 
                a.estado + ";" + 
                a.fechaInicio;
                escritura.write(texto + "\n");
            }

            escritura.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public Boolean leerAdministradores() throws Exception {
        FileReader entrada = new FileReader("src/almacenamientos/administradores.txt");
        BufferedReader miBuffer = new BufferedReader(entrada);
        String linea = "";
        Administrador administrador;
        miBuffer.readLine();
        while (linea != null) {
            linea = miBuffer.readLine();
            if (linea != null) {
                String[] arrayLinea = linea.split(";");
                SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                Date fechainicio = formatter1.parse(arrayLinea[6]);
                Boolean bull = true;
                String myString = arrayLinea[5];
                if ("true".equals(myString)) {
                    bull = true;
                } else {
                    bull = false;
                }
                administrador = new Administrador(Integer.parseInt(arrayLinea[0]), arrayLinea[1], arrayLinea[2],
                        arrayLinea[3], arrayLinea[4], bull, fechainicio);
                listaAdministradores.add(administrador);
            }
        }
        entrada.close();
        return true;
    }

    // Leer Postulante

    public static Postulante devolverPostulante(int i) {
        for (Postulante postulante : listaPostulantes) {
            if (postulante.dni == i)
                return postulante;
        }
        return null;
    }

}
