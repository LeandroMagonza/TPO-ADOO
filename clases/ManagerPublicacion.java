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
                    publicacion = new Publicacion(Integer.parseInt(arrayLinea[0]),Integer.parseInt(arrayLinea[1]),  arrayLinea[2], arrayLinea[3],
                            arrayLinea[4], arrayLinea[5], arrayLinea[6],  Integer.parseInt(arrayLinea[7]), arrayLinea[8],
                             arrayLinea[9], arrayLinea[10].equalsIgnoreCase("true"), arrayLinea[11], arrayLinea[12].equalsIgnoreCase("true"));
                    listaPublicaciones.add(publicacion);
                }
            }
    		return false;
    	}catch (IOException e) {
            return false;
        }
    }
    
    public Publicacion buscarPublicacion(int nro) {
    	Publicacion correcto = null;
    	for(Publicacion publicacion: listaPublicaciones) {
    		if(publicacion.getNroPublicacion() == nro)
    			correcto = publicacion;
    	}
		return correcto;
    }
    
    public ArrayList<Publicacion> mostrarLista(){
		return null;
    	
    }
    

}
