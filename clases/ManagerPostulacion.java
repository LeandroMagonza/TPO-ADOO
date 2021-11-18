package clases;

import java.io.BufferedReader;
import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManagerPostulacion {
	// atributo
    private static ArrayList<Postulacion> listaPostulaciones;
    private static ManagerPublicacion instanciaPostulacion;
    //constructor
    private ManagerPostulacion() throws Exception {
        listaPostulaciones = new ArrayList<Postulacion>();
        leerPostulaciones();

    }
    // Publicacion mas popular del año
	public static Publicacion masPopularYear(int year) {
    	HashMap<Integer, Integer> masPop = new HashMap<Integer, Integer>();
    	for(Postulacion postulacion: listaPostulaciones) {
    		if(postulacion.getFecha().getYear() == year) {
    			if(masPop.containsKey(postulacion.getPublicacion().getNroPublicacion())){
    				int i = masPop.get(postulacion.publicacion.getNroPublicacion());
    				masPop.put(postulacion.publicacion.getNroPublicacion(), i++);
    			}else {
    				masPop.put(postulacion.publicacion.getNroPublicacion(), 1);
    			}			
    		}		
    	}
    	int c = 0;
    	int num = 0;
    	for(Integer j : masPop.keySet()) {
    		if(masPop.get(j)>c) {
    			num = j;
    			c = masPop.get(j);
    		}
    	}
    	return ManagerPublicacion.buscar(num);
    }
    
    
    
    
    
	private Boolean leerPostulaciones() throws Exception, Exception {
    	try {
    		FileReader entrada = new FileReader("almacenamientos/postulaciones.txt");
            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = "";
            Postulacion postulacion;
            miBuffer.readLine();
            while (linea != null) {
                linea = miBuffer.readLine();
                if (linea != null) {
                    String[] arrayLinea = linea.split(";");
                    postulacion = new Postulacion(Integer.parseInt(arrayLinea[0]), Integer.parseInt(arrayLinea[1]),  Integer.parseInt(arrayLinea[2])
                    		, Integer.parseInt(arrayLinea[3]), arrayLinea[4].equalsIgnoreCase("true"), arrayLinea[5]);
                    listaPostulaciones.add(postulacion);
                }
            }
    		return false;
    	}catch (IOException e) {
            return false;
        }
		
	}
	public static ArrayList<Postulacion> dividir(String s){
    	ArrayList<Postulacion> lista = null;
    	String[] arrayLinea = s.split(":");
    	int i = arrayLinea.length;
    	while( i > 0) {
    		lista.add(devolverPostulacion(i));
    		i--;
    	}
		return lista;
    	
    }
	private static Postulacion devolverPostulacion(int i) {
		for(Postulacion postulacion: listaPostulaciones) {
			if(postulacion.nroPostulacion == i)
				return postulacion;
		}
		return null;
	}
}
