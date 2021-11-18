package clases;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuPostulante {
    /*
	Menu principal postulante

    1. Ver publicaciones
        1. Elegir Publicacion
            1. Postularse 
            2. Agregarla a Favoritos
            0. Volver
        0. Volver

    2. Ver publicaciones Favoritas
        1. Elegir publicacion Favorita
            1. Postularse
            2. Elimiar de favoritos
            0. Volver
        0. Volver

    3. Ver recomedaciones
        1. Elegir publicacion Favorita
            1. Postularse
            2. Agregarla a favoritos
            0. Volver
        0. Volver
    */      
  
	public static void mostrarMenu() {
		Scanner scanner = ManagerLogIn.scanner;
		
		int respuesta = 0;
		while (respuesta != 1 && respuesta != 2 && respuesta != 3) {
			System.out.println("Menu");
			System.out.println("1. Elegir Publicacion ");
			System.out.println("2. Ver publicaciones Favoritas ");
			System.out.println("3. Ver recomedaciones ");
			System.out.print("Ingrese el numero de la opcion : ");
			respuesta = scanner.nextInt(); 
			scanner.nextLine();
		}
			switch(respuesta){
			case 1:
				elegirPublicaciones();
			case 2:
				verPublicacionesFavoritas();
			case 3:
				verRecomendaciones();
		}
	}
	/*
	1. Ver publicaciones
		1. Elegir Publicacion
			1. Postularse 
			2. Agregarla a Favoritos
			0. Volver
		0. Volver
	*/
	private static void elegirPublicaciones() {
		ManagerPublicacion managerPublicacion = ManagerPublicacion.getManagerPublicacion();
		Scanner scanner = ManagerLogIn.scanner;
		String respuesta = "";
		System.out.println("Usted ha seleccionado elegir publicacion");
		System.out.println("Listado de Publicaciones: ");
		
		for (Publicacion publicacionActiva : managerPublicacion.listadoActivas()) {
			System.out.println("");
		}
	}

	/*
	2. Ver publicaciones Favoritas
        1. Elegir publicacion Favorita
            1. Postularse
            2. Elimiar de favoritos
            0. Volver
        0. Volver
		*/

	private static void verPublicacionesFavoritas() {
		Scanner scanner = ManagerLogIn.scanner;
		int respuesta = 0;
		System.out.println("Usted ha seleccionado ver publicaciones favoritas");
		System.out.println("Listado de Publicaciones Favoritas : ");
		//!!ACA insertar codigo que lea archivo publicacionesfavoritas.txt

		while ((respuesta != 1) && (respuesta != 2) && (respuesta != 0)) {
			System.out.println("1. Postularse");
			System.out.println("2. Eliminar de favoritos");
			System.out.println("0. Volver al menu anterior");
			System.out.println("Ingrese el numero de la opcion : ");
			respuesta = scanner.nextInt();
			scanner.nextLine();
		}
		switch(respuesta){
			case 1:
				//postularse();
			case 2:
				//eliminarFavoritos();
			case 0:
				mostrarMenu();
		}
		
	}

	private static void verRecomendaciones() {
		Scanner scanner = ManagerLogIn.scanner;
		String respuesta = "";
		System.out.println("Usted ha seleccionado ver recomendaciones");
		System.out.println("Listado de Publicaciones Recomendadas para sus intereses: ");
		//!!ACA insertar codigo que lea archivo recomendaciones.txt
	
	}

	/*
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
			System.out.println("Ingrese el numero de la opcion : ");
			respuesta = ManagerLogIn.scanner.nextInt(); 
			ManagerLogIn.scanner.nextLine();
		}
			switch(respuesta){
			case 1:
				crearPublicacion();
			case 2:
				administrarPublicaciones();
				
				
		}
	}
	
	//muestra la publicacion
 	private static void mostrarPublicacion(Publicacion p) {
		System.out.println("Codigo de la publicacion: "+p.getNroPublicacion());
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
	private static void buscarPublicacionXNro() {

	}
	*/
	
}