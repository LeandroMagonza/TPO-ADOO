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
    private ManagerPublicacion() throws Exception {
        listaPublicaciones = new ArrayList<Publicacion>();
        leerPublicaciones();

    }
    public Boolean leerPublicaciones() throws Exception, Exception {
    	try {
    		FileReader entrada = new FileReader("almacenamientos/publicaciones.txt");
            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = "";
            Publicacion publicacion;
            miBuffer.readLine();
            while (linea != null) {
                linea = miBuffer.readLine();
                if (linea != null) {
                    String[] arrayLinea = linea.split(";");
                    publicacion = new Publicacion(Integer.parseInt(arrayLinea[0]), arrayLinea[1], arrayLinea[2],
                            arrayLinea[3], arrayLinea[4], arrayLinea[5],  Integer.parseInt(arrayLinea[6]), arrayLinea[7],
                             arrayLinea[8], arrayLinea[9].equalsIgnoreCase("true"), arrayLinea[10], arrayLinea[11].equalsIgnoreCase("true"));
                    listaPublicaciones.add(publicacion);
                }
            }
    		return false;
    	}catch (IOException e) {
            return false;
        }
    	
    }

}
