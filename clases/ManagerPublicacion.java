package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManagerPublicacion {
    // atributo
    private static ArrayList<Publicacion> listaPublicaciones;
    private static ManagerPublicacion instanciaPublicacion;
    // constructor
    private ManagerPublicacion() throws Exception {
        listaPublicaciones = new ArrayList<Publicacion>();
        leerPublicaciones();
    }

	public static ManagerPublicacion getManagerPublicacion() {
		if (instanciaPublicacion == null)  { try {
			instanciaPublicacion = new ManagerPublicacion();
		} catch(Exception e){
		} 
        }
		return instanciaPublicacion;
	}

    public Boolean leerPublicaciones() throws Exception, Exception {
    	try {
    		FileReader entrada = new FileReader("src/almacenamientos/publicaciones.txt");
            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = "";
            Publicacion publicacion;
            miBuffer.readLine();
            while (linea != null) {
				linea = miBuffer.readLine();
				String[] arrayLinea = linea.split(";");
				publicacion = new Publicacion(
					Integer.parseInt(arrayLinea[0]), 
					Integer.parseInt(arrayLinea[1]), 
					arrayLinea[2],
					arrayLinea[3],
					arrayLinea[4], 
					arrayLinea[5], 
					arrayLinea[6],  
					Integer.parseInt(arrayLinea[7]), 
					arrayLinea[8],
					arrayLinea[9], 
					arrayLinea[10].equalsIgnoreCase("true"), 
					arrayLinea[11], 
					arrayLinea[12].equalsIgnoreCase("true"),
					arrayLinea[13]);
				listaPublicaciones.add(publicacion);
            }
    		return true;
    	}catch (IOException e) {
            return false;
        }
    	
    }
  
    //busca la punlicacion con el nro n
    public static Publicacion buscar(int n) {
    	for(Publicacion publicacion: listaPublicaciones) {
    		if(publicacion.getNroPublicacion()==n)
    			return publicacion;
    	}
		return null;
    }
    
    //muestra las publicaciones de la empresa e
    public static ArrayList<Publicacion> listadoPorEmpresa(int e){
    	ArrayList<Publicacion> listaResultado = new ArrayList<Publicacion>();
    	for(Publicacion publicacion: listaPublicaciones) {
    		if(publicacion.getNroEmpresa()== e) {
    			listaResultado.add(publicacion);
    		}
    	}
		return listaResultado;
    }
    public static ArrayList<Publicacion> listadoActivas(){
    	ArrayList<Publicacion> listaResultado = new ArrayList<Publicacion>();
    	for(Publicacion publicacion: listaPublicaciones) {
    		if(publicacion.getPublicacionActiva()){
    			listaResultado.add(publicacion);
    		}
    	}
		return listaResultado;
    	
    }
    
    //devuelve la lista de publicaciones de la categoria c
    public static ArrayList<Publicacion> filtradoCategoria(Categoria c){
    	ArrayList<Publicacion> listaResultado = new ArrayList<Publicacion>();
    	for(Publicacion publicacion: listaPublicaciones) {
    		if(publicacion.getCategoria().equals(c)){
    			listaResultado.add(publicacion);
    		}
    	}
		return listaResultado;
    }

    //oferta labora mas accesible modalidad part, remoto, requisitos tareas
    public static Publicacion masAccesible() {
    	Publicacion masAc = null;
    	for(Publicacion publicacion: listaPublicaciones) {
    		if(publicacion.getPublicacionActiva() && publicacion.getModalidad().name().equalsIgnoreCase("PartTime") && publicacion.getTipoTrabajo().name().equalsIgnoreCase("Remoto")) {
    			if(masAc == null)
    				masAc = publicacion;
    			else {
    				if(masAc.getRequisitos().size()> publicacion.getRequisitos().size())
    					masAc = publicacion;
    				if(masAc.getRequisitos().size()== publicacion.getRequisitos().size() && masAc.getTareasARealizar().size() > publicacion.getTareasARealizar().size())
    					masAc = publicacion;
    			}
    		}
    	}
    	return masAc;
    }
    
    //oferta menos accesible
    public static Publicacion menosAccesible() {
    	Publicacion menosAc = null;
    	for(Publicacion publicacion: listaPublicaciones) {
    		if(publicacion.getPublicacionActiva() && publicacion.getModalidad().name().equalsIgnoreCase("FullTime") && publicacion.getTipoTrabajo().name().equalsIgnoreCase("Presencial")) {
    			if(menosAc == null)
    				menosAc = publicacion;
    			else {
    				if(menosAc.getRequisitos().size()< publicacion.getRequisitos().size())
    					menosAc = publicacion;
    				if(menosAc.getRequisitos().size()== publicacion.getRequisitos().size() && menosAc.getTareasARealizar().size() < publicacion.getTareasARealizar().size())
    					menosAc = publicacion;
    			}
    		}
    	}
    	return menosAc;
    }
}
