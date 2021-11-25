package clases;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Menu {
    // crear publicacion
    // ver publicaciones {
    //      modificar publicacion
    //      eliminar publicacion
    //      ver postulantes de publicacion
    // }
	public static void mostrarMenu() {
		
	}
	
	//se busca por nro de publicacion
	protected static Publicacion buscarNroPublicacion() {
		System.out.println("Ingrese el nro de la publicacion");
		//modificar para verificar nro de la empresa....
		int nro = ManagerLogIn.scanner.nextInt();
		ManagerLogIn.scanner.nextLine();
		Publicacion publicacion = ManagerPublicacion.getManagerPublicacion().buscar(nro);
		mostrarPublicacion(publicacion);
        return publicacion;
	}
	
	//se muestra la lista d elas publicaciones de la empresa
	protected static void listaPublicacionesActivas() {
		ArrayList<Publicacion> lista = ManagerPublicacion.getManagerPublicacion().listadoActivas();
		mostrarListaPublicaciones(lista);
		// System.out.println("Escriba el nro de la publicacion deseada: ");
		// int nroPublicacion = ManagerLogIn.scanner.nextInt();
		// ManagerLogIn.scanner.nextLine();
		// Publicacion respuesta = ManagerPublicacion.getManagerPublicacion().buscar(nroPublicacion);
		// mostrarPublicacion(respuesta);
	}

	protected static void listaPublicacionesDeEmpresa(Empresa empresa) {
		ArrayList<Publicacion> lista = ManagerPublicacion.getManagerPublicacion().listadoPorEmpresa(empresa);
		mostrarListaPublicaciones(lista);
	}
	protected static void mostrarListaPublicaciones(ArrayList<Publicacion> listaPublicaciones) {
		for(Publicacion publicacion: listaPublicaciones) {
			System.out.printf("Nro: "+publicacion.getNroPublicacion());
			System.out.printf("    Descripcion: "+publicacion.getDescripcion());
			System.out.println("	Dias Restantes: "+publicacion.getDiasRestantes());
		}
	}
    // System.out.println("Escriba el nro de la publicacion deseada: ");
    // int nroPublicacion = ManagerLogIn.scanner.nextInt();
    // ManagerLogIn.scanner.nextLine();
    // Publicacion respuesta = ManagerPublicacion.getManagerPublicacion().buscar(nroPublicacion);
    // mostrarPublicacion(respuesta);

	protected static void listaPublicacionesDeEmpresa() {
		System.out.println("Ingrese el nro de la empresa");
		int empleador = ManagerLogIn.scanner.nextInt();
		ManagerLogIn.scanner.nextLine();
		listaPublicacionesDeEmpresa(ManagerEmpresa.getManagerEmpresa().getEmpresaPorCuit(empleador));
	}
	
	//muestra la opcion una vez que seleccionamos una publicacion
	
	
	//muestra la publicacion
 	protected static void mostrarPublicacion(Publicacion p) {
		System.out.println("Codigo de la publicacion: "+p.getNroPublicacion());
		System.out.println("Descripcion: "+p.getDescripcion());
		System.out.println("Modalidad: "+p.getModalidad().name() );
		System.out.println("Categoria: "+p.getCategoria().name());
		System.out.println("Lugar: "+p.getLugar());
		System.out.println("Tipo: "+p.getTipoTrabajo());
		System.out.println("Sueldo: $"+p.getSueldo());
		// System.out.println("Requisitos: ");
		// for(Requisito requisito: p.getRequisitos())
		// 	System.out.println(requisito.descripcion);
		// System.out.println("Tareas");
		// for(Tarea tarea: p.getTareasARealizar())
		// 	System.out.println(tarea.descripcion);
		if(p.getRequiereTitulo())
			System.out.print("Si ");
		else
			System.out.print("No ");
		System.out.println("requiere titulacion");
		System.out.println("Dias Restantes: "+p.getEstado().getCantDiasDeVigencia());//revisar como se muestra
		System.out.print("La busqueda ");
		if(p.getEstado() instanceof EstadoCerrada)
			System.out.print("No ");
		System.out.println("esta abierta");
		
	}

	
	
}
