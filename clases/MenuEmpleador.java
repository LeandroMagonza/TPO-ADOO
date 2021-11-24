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
    // crear publicacion
    // ver publicaciones {
    //      modificar publicacion
    //      eliminar publicacion
    //      ver postulantes de publicacion
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
		Scanner scanner = ManagerLogIn.scanner;
		String respuesta = "";
		Empleador empleadorLogueado = (Empleador) ManagerLogIn.getManagerLogIn().usuarioLogueado;
		int cuitEmpresa = empleadorLogueado.empresa;
		System.out.println("Usted ha seleccionado Crear Publicacion");
		System.out.println("Ingrese la Descripcion: ");
		String descripcion = scanner.nextLine();
		System.out.println("Seleccione la Modalidad: ");
		String modalidadStr;
		int index = 0;
		for (Modalidad modalidad :Modalidad.values()) {
			index ++;
			System.out.println(index+" "+modalidad.toString());
		}
		String categoriaStr;
		String lugar;
		String tipoTrabajoStr;
		int sueldo;
		String requisitosStr;
		String tareasARealizarStr;
		boolean requiereTitulo;
		String vigenciaStr;
		boolean publicacionActiva;
		
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
					break;
				case 2:
					// cambiarFechaVigencia();
					respuesta = -1;
					break;
				case 0:
					break modificarPublicacion;
				default:
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
					System.out.println("0. Volver");
					System.out.println("Ingrese el numero de la opcion : ");
					respuesta = ManagerLogIn.scanner.nextInt(); 
					ManagerLogIn.scanner.nextLine();
			}

				
		}
	}
	
	//muestra la publicacion
	
	
}
