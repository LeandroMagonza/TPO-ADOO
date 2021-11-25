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

public class MenuEmpleador extends Menu {
	// .crear publicacion
	// .ver publicaciones {
	// ....modificar publicacion
	// ....eliminar publicacion
	// ....ver postulantes de publicacion
	// }
	public static void mostrarMenu() {
		Scanner scanner = ManagerLogIn.scanner;
		int respuesta1 = -1;
		menuEmpleador: while (true) {
			switch (respuesta1) {
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
		Empleador empleadorLogueado = (Empleador) ManagerLogIn.getManagerLogIn().usuarioLogueado;
		Empresa empresa = empleadorLogueado.empresa;
		System.out.println("Ingrese la Descripcion: ");
		String descripcion = scanner.nextLine();
		
		System.out.println("Modalidades: ");
		int index = 0;
		int indiceSeleccionado = -1;
		for (Modalidad modalidad : Modalidad.values()) {
			index++;
			System.out.println(index + " " + modalidad.toString());
		}
		while (indiceSeleccionado <1 || indiceSeleccionado > Modalidad.values().length ) {
			System.out.println("Seleccione una Modalidad: ");
			indiceSeleccionado = scanner.nextInt();
			scanner.nextLine();
		}
		Modalidad modalidad = Modalidad.values()[indiceSeleccionado-1];
		
		System.out.println("Categorias: ");
		index = 0;
		indiceSeleccionado = -1;
		for (Categoria categoria : Categoria.values()) {
			index++;
			System.out.println(index + " " + categoria.toString());
		}
		while (indiceSeleccionado <1 || indiceSeleccionado > Categoria.values().length ) {
			System.out.println("Seleccione una Categoria: ");
			indiceSeleccionado = scanner.nextInt();
			scanner.nextLine();
		}
		Categoria categoria = Categoria.values()[indiceSeleccionado-1];
		
		System.out.println("Ingrese el Lugar: ");
		String lugar = scanner.nextLine();

		System.out.println("Tipo de Trabajo: ");
		index = 0;
		indiceSeleccionado = -1;
		for (TipoTrabajo tipoTrabajo : TipoTrabajo.values()) {
			index++;
			System.out.println(index + " " + tipoTrabajo.toString());
		}
		while (indiceSeleccionado <1 || indiceSeleccionado > TipoTrabajo.values().length ) {
			System.out.println("Seleccione un Tipo de Trabajo: ");
			indiceSeleccionado = scanner.nextInt();
			scanner.nextLine();
		}
		TipoTrabajo tipoTrabajo = TipoTrabajo.values()[indiceSeleccionado-1];
		
		
		System.out.println("Ingrese Sueldo: ");
		int sueldo = scanner.nextInt();
		scanner.nextLine();
		
		String requisitosStr = "";
		String tareasARealizarStr = "";

		indiceSeleccionado = 0;
		System.out.println("Requiere Titulo? ");
		System.out.println("1. SI ");
		System.out.println("2. NO ");
		while (indiceSeleccionado <1 || indiceSeleccionado > 2) {
			System.out.println("Seleccione una opción: ");
			indiceSeleccionado = scanner.nextInt();
			scanner.nextLine();
		}
		boolean requiereTitulo = false;
		if (indiceSeleccionado == 1) {
			requiereTitulo = true;
		}
		System.out.println("Ingrese Cantidad de dias de vigencia: ");
		int cantDiasDeVigencia = scanner.nextInt();
		scanner.nextLine();
		ManagerPublicacion.getManagerPublicacion().crearPublicacion(
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
	}

	private static void administrarPublicaciones() {
		Scanner scanner = ManagerLogIn.scanner;
		int respuesta = -1;
		System.out.println("Usted ha seleccionado Adminstrar Publicaciones");
		administrarPublicaciones: while (true) {
			switch (respuesta) {
			case 1:
				buscarPublicacionParaEditar();
				respuesta = -1;
				break;
			case 2:
				Empleador empleador = (Empleador) ManagerLogIn.getManagerLogIn().usuarioLogueado;
				listaPublicacionesDeEmpresa(empleador.empresa);
				respuesta = -1;
				break;
			case 3:
				ManagerPublicacion.getManagerPublicacion().pasarDia();
				respuesta = -1;
				break;
			case 0:
				break administrarPublicaciones;
			default:
				System.out.println("1. Buscar con el Nro de publicacion");
				System.out.println("2. Mostrar Listado");
				System.out.println("3. Pasar Dia");
				System.out.println("0. Volver al menu anterior");
				System.out.println("Ingrese el numero de la opcion : ");
				respuesta = scanner.nextInt();
				scanner.nextLine();
				break;
			}
		}

	}

	// se busca por nro de publicacion
	private static void buscarPublicacionParaEditar() {
		Scanner scanner = ManagerLogIn.scanner;
		int respuesta = -1;
		System.out.println("Usted ha seleccionado Buscar Publicacion");
		buscarPublicacionParaEditar: while (true) {
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

	// muestra la opcion una vez que seleccionamos una publicacion
	private static void modificarPublicacion(Publicacion p) {
		int respuesta = -1;
		modificarPublicacion: while (true) {
			switch (respuesta) {
			case 1:
				cambiarEstado(p);
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
				// System.out.println("2. Cambiar fecha de vigencia");
				// System.out.println("3. Dar de baja");
				System.out.println("0. Volver");
				System.out.println("Ingrese el numero de la opcion : ");
				respuesta = ManagerLogIn.scanner.nextInt();
				ManagerLogIn.scanner.nextLine();
			}

		}
	}
	private static void cambiarEstado(Publicacion p) {
		ManagerPublicacion.getManagerPublicacion().cambiarEstado(p);
	}
	// muestra la publicacion

}
