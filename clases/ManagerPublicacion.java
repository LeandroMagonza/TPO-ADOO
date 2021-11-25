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
        // leerPublicaciones();
		//creamos publicaciones de prueba
		;
;
;
		crearPublicacion(
			ManagerEmpresa.getManagerEmpresa().getEmpresaPorCuit(20086665), 
			"Desarrollador Web", 
			(Modalidad.transform("PartTime")),
			(Categoria.transform("Sistemas")), 
			"UADE", 
			(TipoTrabajo.transform("Presencial")), 
			350000, 
			"", 
			"", 
			true,  
			2);
		crearPublicacion(
			ManagerEmpresa.getManagerEmpresa().getEmpresaPorCuit(20086665), 
			"Limpieza", 
			Modalidad.transform("PartTime"), 
			Categoria.transform("Administracion"), 
			"UADE", 
			TipoTrabajo.transform("Remoto"), 
			70000, 
			"", 
			"", 
			true, 
			3);
			// for (Publicacion publicacion : listaPublicaciones) {
			// 	System.out.println(publicacion.getDescripcion());
			// }
    }

	public static ManagerPublicacion getManagerPublicacion() {
		if (instanciaPublicacion == null)  { try {
			instanciaPublicacion = new ManagerPublicacion();
		} catch(Exception e){
		} 
        }
		return instanciaPublicacion;
	}

    // public Boolean leerPublicaciones(){
    // 	try {
    // 		FileReader entrada = new FileReader("src/almacenamientos/publicaciones.txt");
    //         BufferedReader miBuffer = new BufferedReader(entrada);
    //         String linea = "";
    //         Publicacion publicacion;
    //         miBuffer.readLine();
	// 		// System.out.println(linea);
    //         while (linea != null) {
	// 			linea = miBuffer.readLine();
	// 			String[] arrayLinea = linea.split(";");
	// 			publicacion = new Publicacion(
	// 				Integer.parseInt(arrayLinea[0]), 
	// 				ManagerEmpresa.getManagerEmpresa().getEmpresaPorCuit(Integer.parseInt(arrayLinea[1])), 
	// 				arrayLinea[2],
	// 				arrayLinea[3],
	// 				arrayLinea[4], 
	// 				arrayLinea[5], 
	// 				arrayLinea[6],  
	// 				Integer.parseInt(arrayLinea[7]), 
	// 				arrayLinea[8],
	// 				arrayLinea[9], 
	// 				arrayLinea[10].equalsIgnoreCase("true"), 
	// 				arrayLinea[11], 
	// 				arrayLinea[13],
	// 				60);
	// 			listaPublicaciones.add(publicacion);
	// 			// System.out.println(publicacion.getDescripcion());
    //         }
    // 		return true;
    // 	}catch (IOException e) {
    //         return false;
    //     }
    	
    // }
  
    //busca la punlicacion con el nro n
    public static Publicacion buscar(int n) {
    	for(Publicacion publicacion: listaPublicaciones) {
    		if(publicacion.getNroPublicacion()==n)
    			return publicacion;
    	}
		return null;
    }
    
    //muestra las publicaciones de la empresa e
    public static ArrayList<Publicacion> listadoPorEmpresa(Empresa empresa) {
    	ArrayList<Publicacion> listaResultado = new ArrayList<Publicacion>();
    	for(Publicacion publicacion: listaPublicaciones) {
    		if(publicacion.getEmpresa() == empresa) {
    			listaResultado.add(publicacion);
    		}
    	}
		return listaResultado;
    }
    public static ArrayList<Publicacion> listadoActivas(){
    	ArrayList<Publicacion> listaResultado = new ArrayList<Publicacion>();
    	for(Publicacion publicacion: listaPublicaciones) {
    		if(publicacion.getEstado() instanceof EstadoAbierta){
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
    		if(publicacion.getEstado() instanceof EstadoAbierta && publicacion.getModalidad().name().equalsIgnoreCase("PartTime") && publicacion.getTipoTrabajo().name().equalsIgnoreCase("Remoto")) {
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
    		if(publicacion.getEstado() instanceof EstadoAbierta && publicacion.getModalidad().name().equalsIgnoreCase("FullTime") && publicacion.getTipoTrabajo().name().equalsIgnoreCase("Presencial")) {
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

	public void pasarDia(){
		for (Publicacion publicacion : listaPublicaciones) {
			publicacion.pasarDia();
		}
	}

	public Publicacion crearPublicacion(
			Empresa empresa, 
			String descripcion,	
			Modalidad modalidad,
    		Categoria categoria, 
			String lugar, 
			TipoTrabajo tipoTrabajo,
    		int sueldo, 
			String requisitosStr, 
			String tareasARealizarStr,
    		boolean requiereTitulo, 
			int cantDiasDeVigencia)  {
				Publicacion publicacionNueva = new Publicacion(
					listaPublicaciones.size()+1, 
					empresa, 
					descripcion, 
					modalidad, 
					categoria, 
					lugar, 
					tipoTrabajo, 
					sueldo, 
					requisitosStr, 
					tareasARealizarStr, 
					requiereTitulo, 
					cantDiasDeVigencia);
				listaPublicaciones.add(publicacionNueva);
				return publicacionNueva;
		// this.requisitos = ManagerRequisito.dividir(requisitosStr);
		// this.tareasARealizar = ManagerTarea.dividir(tareasARealizarStr);
    	
    	
    }
	public void cambiarEstado(Publicacion p) {
		if (p.getEstado() instanceof EstadoAbierta){
			p.cerrar();
		}
		else{
			p.abrir();
		}
	}
	/*
	public void agregarPostulacion(Postulacion postulacion,Publicacion publicacion) {
		for(Publicacion p: listaPublicaciones) {
			if(p.getNroPublicacion()==publicacion.getNroPublicacion()) {
				ArrayList<Postulacion> lista = p.getPostulaciones();
				lista.add(postulacion);
				p.setPostulaciones(lista);
			}
		}
	}
	*/
	
}
