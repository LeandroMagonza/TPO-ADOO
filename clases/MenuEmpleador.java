package clases;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuEmpleador {
    // crear publicacion
    // ver publicaciones {
    //      modificar publicacion
    //      eliminar publicacion
    //      ver postulantes de publicacion
    // }
	public static void mostrarMenu() {
		int respuesta =0;
		while (respuesta != 1 && respuesta != 2) {
			System.out.println("Menu");
			System.out.println("1. Crear publicación ");
			System.out.println("2. Ver publicación ");
			System.out.print("Ingrese el numero de la opción : ");
			respuesta = ManagerLogIn.scanner.nextInt(); 
			ManagerLogIn.scanner.nextLine();
		}
			switch(respuesta){
			case 1:
				crearPublicacion();
			case 2:
				verPublicacion();
				
				
		}
		
	}
	private static void crearPublicacion() {
		Scanner scanner = new Scanner(System.in);
		String respuesta = "";
		System.out.println("Usted ha seleccionado crear publiación");
		
	}
	private static void verPublicacion() {
		int respuesta = 0;
		System.out.println("Usted ha seleccionado ver publicación");
		while (respuesta != 1 && respuesta != 2 && respuesta != 3) {
			System.out.println("1. Buscar con el Nro de publicación");
			System.out.println("2. Mostrar Nro y descripción");
			System.out.println("3. Volver al menu anterior");
			System.out.println("Ingrese el numero de la opción : ");
			respuesta = ManagerLogIn.scanner.nextInt();
			ManagerLogIn.scanner.nextLine();
		}
		switch(respuesta){
			case 1:
				buscarNroPublicacion();
			case 2:
				listaPublicaciones();
			case 3:
				mostrarMenu();
		}
		
	}
	
	//se busca por nro de publicacion
	private static void buscarNroPublicacion() {
		System.out.println("Ingrese el nro de la publicacion");
		//modificar para verificar nro de la empresa....
		int nro = ManagerLogIn.scanner.nextInt();
		ManagerLogIn.scanner.nextLine();
		Publicacion publicacion = ManagerPublicacion.buscar(nro);
		mostrarPublicacion(publicacion);
		modificarPublicacion(publicacion);
	}
	
	//se muestra la lista d elas publicaciones de la empresa
	private static void listaPublicaciones() {
		System.out.println("Ingrese el nro de la empresa");
		int empleador = ManagerLogIn.scanner.nextInt();
		ManagerLogIn.scanner.nextLine();
		ArrayList<Publicacion> lista = ManagerPublicacion.listado(empleador);
		for(Publicacion publicacion: lista) {
			System.out.println("Nro: "+publicacion.getNroPublicacion());
			System.out.println("Descripcion: "+publicacion.getDescripcion());
		}
		System.out.println("Escriba el nro de la publicacion deseada: ");
		int nroPublicacion = ManagerLogIn.scanner.nextInt();
		ManagerLogIn.scanner.nextLine();
		Publicacion respuesta = ManagerPublicacion.buscar(nroPublicacion);
		mostrarPublicacion(respuesta);
		modificarPublicacion(respuesta);
		
		
	}
	
	//muestra la opcion una vez que seleccionamos una publicacion
	private static void modificarPublicacion(Publicacion p) {
		int respuesta =0;
		while (respuesta != 1 && respuesta != 2 && respuesta != 3) {
			System.out.println("1. Cambiar estado");
			System.out.println("2. Cambiar fecha de vigencia");
			System.out.println("3. Dar de baja");
			System.out.println("3. Dar de baja");
			System.out.println("3. Dar de baja");
			System.out.println("3. Dar de baja");
			System.out.println("3. Dar de baja");
			System.out.println("3. Dar de baja");
			System.out.println("3. Dar de baja");
			System.out.println("3. Dar de baja");
			System.out.println("3. Dar de baja");
			System.out.println("Ingrese el numero de la opción : ");
			respuesta = ManagerLogIn.scanner.nextInt(); 
			ManagerLogIn.scanner.nextLine();
		}
			switch(respuesta){
			case 1:
				crearPublicacion();
			case 2:
				verPublicacion();
				
				
		}
	}
	
	//muestra la publicacion
 	private static void mostrarPublicacion(Publicacion p) {
		System.out.println("Código de la publicacion: "+p.getNroPublicacion());
		System.out.println("Descripcion: "+p.getDescripcion());
		System.out.println("Modalidad: "+p.getModalidad().name() );
		System.out.println("Categoria: "+p.getCategoria().name());
		System.out.println("Lugar: "+p.getLugar());
		System.out.println("Tipo: "+p.getTipoTrabajo());
		System.out.println("Sueldo: $"+p.getSueldo());
		System.out.println("Requisitos: ");
		for(Requisito requisito: p.getRequisitos())
			System.out.println(requisito.descripcion);
		System.out.println("Tareas");
		for(Tarea tarea: p.getTareasARealizar())
			System.out.println(tarea.descripcion);
		if(p.getRequiereTitulo())
			System.out.print("Si ");
		else
			System.out.print("No ");
		System.out.println("requiere titulacion");
		System.out.println("Fecha limite: "+p.getVigencia());//revisar como se muestra
		System.out.print("La busqueda ");
		if(p.getPublicacionActiva())
			System.out.print(" SI ");
		else
			System.out.print(" No ");
		System.out.println("sigue abierta");
		
	}
	
	
}
