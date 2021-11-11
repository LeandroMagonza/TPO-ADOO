package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManagerPublicacion {
    // atributo
    public Publicacion publicacionSeleccionada;
    private ArrayList<Publicacion> listaPublicaciones;
    private static ManagerPublicacion instanciaPublicacion;
    // constructor
    private ManagerPublicacion() {
        listaPublicaciones = new ArrayList<Publicacion>();
        leerPublicaciones();

    }
    public Boolean leerPublicaciones() {
    	try {
    		FileReader entrada = new FileReader("almacenamientos/empleadores.txt");
            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = "";
            Publicacion publicacion;
            miBuffer.readLine();
            while (linea != null) {
                linea = miBuffer.readLine();
                if (linea != null) {
                    String[] arrayLinea = linea.split(";");
                    publicacion = new Publicacion(Integer.parseInt(arrayLinea[0]), arrayLinea[1], arrayLinea[2],
                            arrayLinea[3], arrayLinea[4], arrayLinea[5], arrayLinea[6]);
                    listaPublicaciones.add(publicacion);
                }
    		return false;
    	}catch (IOException e) {
            return false;
        }
    	
    }

}
