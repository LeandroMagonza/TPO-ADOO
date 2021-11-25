package clases;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuPostulante extends Menu {
	/*
	 * Menu principal postulante
	 * 
	 * 1. Ver publicaciones 1. Elegir Publicacion 1. Postularse 2. Agregarla a
	 * Favoritos 0. Volver Volver 0. 2. Ver publicaciones Favoritas 1. Elegir
	 * publicacion Favorita 1. Postularse 2. Elimiar de favoritos 0. Volver 0.
	 * Volver
	 * 
	 * 3. Ver recomedaciones 1. Elegir publicacion Favorita 1. Postularse 2.
	 * Agregarla a favoritos 0. Volver 0. Volver
	 */

	public static void mostrarMenu() {
		Scanner scanner = ManagerLogIn.scanner;
		int respuesta = -1;
		menuPostulante: while (true) {
			switch (respuesta) {
			case 1:
				elegirPublicaciones();
				respuesta = -1;
			case 2:
				verPublicacionesFavoritas();
				respuesta = -1;
			case 3:
				verRecomendaciones();
				respuesta = -1;
			case 0:
				respuesta = -1;
				break menuPostulante;
			default:
				System.out.println("Menu - Postulante");
				System.out.println("1. Ver Publicaciones Abiertas ");
				System.out.println("2. Ver Publicaciones Favoritas ");
				// System.out.println("3. Ver recomedaciones ");
				System.out.print("Ingrese el numero de la opcion : ");
				respuesta = scanner.nextInt();
				scanner.nextLine();
			}
		}
	}

	private static void elegirPublicaciones() {
		ManagerPublicacion managerPublicacion = ManagerPublicacion.getManagerPublicacion();
		Scanner scanner = ManagerLogIn.scanner;
		int respuesta = -1;
		System.out.println("Listado de Publicaciones: ");

		listaPublicacionesActivas(); // Listar Publics

		elegirPublicaciones: while (true) {
			if (respuesta == 0) {
				respuesta = -1;
				break elegirPublicaciones;
			} else if (respuesta > 0 && respuesta < managerPublicacion.listadoActivas().size()) {
				verOpcionesDePublicacion(managerPublicacion.listadoActivas().get(respuesta - 1));
				respuesta = -1;
			} else {
				System.out.println("Ingrese N° de Publicacion o 0 para volver ");
				respuesta = scanner.nextInt();
			}

		}

	}

	private static void verOpcionesDePublicacion(Publicacion publicacion) {
		ManagerPublicacion managerPublicacion = ManagerPublicacion.getManagerPublicacion();
		Postulante postulante = (Postulante) ManagerLogIn.getManagerLogIn().usuarioLogueado;
		Scanner scanner = ManagerLogIn.scanner;
		int respuesta = -1;
		opcionesDePublicacion: while (true) {

			switch (respuesta) {
			case 0:
				respuesta = -1;
				break opcionesDePublicacion;
			case 1:
				managerPublicacion.postularEnPublicacion(publicacion, postulante);
				System.out.println("Postulacion Agregada!");
				respuesta = -1;
				break;
			case 2:
				postulante.agregarPublicacionAFavoritas(publicacion);
				System.out.println("Publicacion Agregada!");
				respuesta = -1;
				break;
			default:
				System.out.println("Seleccione una opcion : ");
				System.out.println("1. Postularse ");
				System.out.println("2. Agregar a Favoritas ");
				System.out.println("0. Volver ");
				respuesta = scanner.nextInt();
				scanner.nextLine();
				break;
			}
		}
	}

	private static void verPublicacionesFavoritas() {
		ManagerPublicacion managerPublicacion = ManagerPublicacion.getManagerPublicacion();
		Scanner scanner = ManagerLogIn.scanner;
		int respuesta = 0;
		System.out.println("Usted ha seleccionado ver publicaciones favoritas");
		System.out.println("Listado de Publicaciones Favoritas : ");
		// !!ACA insertar codigo que lea archivo publicacionesfavoritas.txt
		for (Publicacion publicacionActiva : managerPublicacion.listadoActivas()) {
			System.out.println("");
		}

		Scanner scanner2 = ManagerLogIn.scanner;
		int respuesta2 = 0;
		System.out.println("Elija una publicacion : ");

		while ((respuesta != 1) && (respuesta != 2) && (respuesta != 0)) {
			System.out.println("1. Postularse");
			System.out.println("2. Eliminar de favoritos");
			System.out.println("0. Volver al menu anterior");
			System.out.println("Ingrese el numero de la opcion : ");
			respuesta = scanner.nextInt();
			scanner.nextLine();
		}
		switch (respuesta) {
		case 1:
			postularse();
		case 2:
			// eliminarFavoritos();
		case 0:
			mostrarMenu();
		}

	}

	private static void verRecomendaciones() {
		Scanner scanner = ManagerLogIn.scanner;
		String respuesta = "";
		System.out.println("Usted ha seleccionado ver recomendaciones");
		System.out.println("Listado de Publicaciones Recomendadas para sus intereses: ");
		// !!ACA insertar codigo que lea archivo recomendaciones.txt

	}

	private static void postularse() {
	}

	private static void agregarFavoritos() {
	}

}