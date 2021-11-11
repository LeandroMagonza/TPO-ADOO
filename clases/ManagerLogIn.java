package clases;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManagerLogIn {
    // atributo
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
                }
            }
            entrada.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
