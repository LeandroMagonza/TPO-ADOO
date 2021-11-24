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


public class MenuEmpleador extends Menu{
    // .crear publicacion
    // .ver publicaciones {
    //  ....modificar publicacion
    //  ....eliminar publicacion
    //  ....ver postulantes de publicacion
    // }
	public static void mostrarMenu() {
		Scanner scanner = ManagerLogIn.scanner;
		int respuesta1 = -1;
		menuEmpleador:
		while (true) {
			switch(respuesta1){
				case 1:
					crearPublicacion();
					respuesta1 = -1;
					break;
				case 2:
					administrarPublicaciones();
					respuesta1 = -1;
					break;
				case 0:
					break menuEmpleador;
				default:
					System.out.println("Menu - Empleador");
					System.out.println("1. Crear publicacion ");
					System.out.println("2. Administrar publicaciones ");
					System.out.println("0. Desloguearse");
					System.out.print("Ingrese el numero de la opcion : ");
					respuesta1 = scanner.nextInt(); 
					scanner.nextLine();
					break;
			}
		}
	}
	private static void crearPublicacion() {
		System.out.println("Usted ha seleccionado Crear Publicacion: ");
		Scanner scanner = ManagerLogIn.scanner;
		String respuesta = "";
		//NroPublicacion;cuitEmpresa;Descripcion;Modalidad;Categoria;Lugar;TipoTrabajo;Sueldo;Requisitos;Tareas;Titulo;Vigencia;Activa		// 20086665;Desarrollador Web;PartTime;;Sistemas;UADE;Presencial;350000;1;1:3;true;20/12/2021;true;

		System.out.println("Nro Publicacion: "); //Nro Publicacion
		int respuesta1 = scanner.nextInt();

		System.out.println("CUIT: ");			//Cuit
		int cuit = scanner.nextInt();

		System.out.println("Descripcion: ");	// Descripcion
		String descrip = scanner.nextLine();

		System.out.println("Modalidad: ");      //Modalidad
		int index2 = 0;
		for (Modalidad modalidad : Modalidad.values()) {
			index2++;
			System.out.println( index2 + "." + modalidad);
		}
		String tipomodalidad = " ";
		int idmodalidad = scanner.nextInt();
		scanner.nextLine();
		if (idmodalidad == 1) {
			tipomodalidad = "Partime";
		}else{
			tipomodalidad = "Fulltime";
		}
	
		System.out.println("Categoria: ");		//Categoria
		int index3 = 0;
		for (Categoria categoria : Categoria.values()) {
			index3++;
			System.out.println( index3 + "." + categoria);
		}
		String tipocategoria = scanner.nextLine();

		System.out.println("Lugar: ");			//Lugar
		String lugar = scanner.nextLine();

		System.out.println(" Tipo de Trabajo: ");	 //Tipo de Trabajo
		String tipot  = "";
		int index = 0;
		for (TipoTrabajo tipotrabajo : TipoTrabajo.values()) {
			index++;
			System.out.println( index + "." + tipotrabajo);
		}
		String idtrabajo = scanner.nextLine();
		if (idtrabajo == "1") {
			tipot = "Presencial";
		}else{
			tipot = "Remoto";
		}

		System.out.println("Sueldo: ");
		int sueldo = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Requisitos: "); //Vacios
		String requisitos = scanner.nextLine();

		System.out.println("Tareas: "); //Vacios
		String tareas = scanner.nextLine();

		System.out.println("Titulo: ");
		System.out.println("1. SI ");
		System.out.println("2. NO ");
		String titulo = scanner.nextLine();
		boolean typeboolean = true;
		if (titulo == "1") {
			typeboolean = true;
		}else{
			typeboolean = false;
		}
		//System.out.println("Vigencia: ");
		//Date vigencia = scanner.nextInt();
		System.out.println("Activa: ");
		System.out.println("1. SI ");
		System.out.println("2. NO ");
		String activa = scanner.nextLine();
		boolean typeboolean2 = true;
		if (activa == "1") {
			typeboolean2 = true;
		}else{
			typeboolean2 = false;
		}
	}
	private static void administrarPublicaciones() {
		Scanner scanner = ManagerLogIn.scanner;
		int respuesta = -1;
		System.out.println("Usted ha seleccionado Adminstrar Publicaciones");
		administrarPublicaciones:
		while (true) {
			switch(respuesta){
				case 1:
					buscarPublicacionParaEditar();
					respuesta = -1;
					break;
				case 2:
					Empleador empleador = (Empleador) ManagerLogIn.getManagerLogIn().usuarioLogueado;
					listaPublicacionesDeEmpresa(empleador.empresa);
					respuesta = -1;
					break;
				case 0:
					break administrarPublicaciones;
				default:
					System.out.println("1. Buscar con el Nro de publicacion");
					System.out.println("2. Mostrar Listado");
					System.out.println("0. Volver al menu anterior");
					System.out.println("Ingrese el numero de la opcion : ");
					respuesta = scanner.nextInt();
					scanner.nextLine();
					break;
			}
		}
		
	}
	
	//se busca por nro de publicacion
	private static void buscarPublicacionParaEditar(){
		Scanner scanner = ManagerLogIn.scanner;
		int respuesta = -1;
		System.out.println("Usted ha seleccionado Buscar Publicacion");
		buscarPublicacionParaEditar:
		while (true) {
			Publicacion publicacion = buscarNroPublicacion();
			if (publicacion != null) {
				System.out.println("1. Editar");
				System.out.println("0. Volver al menu anterior");
				System.out.println("Ingrese el numero de la opcion : ");
				respuesta = scanner.nextInt();
				scanner.nextLine();
				switch (respuesta) {
					case 0:
						break buscarPublicacionParaEditar;
					case 1:
						modificarPublicacion(publicacion);
				}
			}
			
			break;
		}
	}
	//muestra la opcion una vez que seleccionamos una publicacion
	private static void modificarPublicacion(Publicacion p) {
		int respuesta = -1;
		modificarPublicacion:
		while (true) {
			switch(respuesta){
				case 1:
					// cambiarEstado();
					respuesta = -1;
				case 2:
					// cambiarFechaVigencia();
					respuesta = -1;
				case 0:
					break modificarPublicacion;
				default:
					System.out.println("1. Cambiar estado");
					System.out.println("2. Cambiar fecha de vigencia");
					System.out.println("3. Dar de baja");
					/*System.out.println("3. Dar de baja");
					System.out.println("3. Dar de baja");
					System.out.println("3. Dar de baja");
					System.out.println("3. Dar de baja");
					System.out.println("3. Dar de baja");
					System.out.println("3. Dar de baja");
					System.out.println("3. Dar de baja");*/
					System.out.println("0. Volver");
					System.out.println("Ingrese el numero de la opcion : ");
					respuesta = ManagerLogIn.scanner.nextInt(); 
					ManagerLogIn.scanner.nextLine();
			}

				
		}
	}
	
	//muestra la publicacion
	
	
}
