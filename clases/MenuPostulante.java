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
				System.out.println("1. Elegir Publicacion ");
				System.out.println("2. Ver publicaciones Favoritas ");
				System.out.println("3. Ver recomedaciones ");
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
		System.out.println("Usted ha seleccionado elegir publicacion");
		System.out.println("Listado de Publicaciones: ");

		listaPublicaciones(); // Listar Publics

		elegirPublicaciones: while (true) {
			switch (respuesta) {
			case 1:
				postularse();
				respuesta = -1;
				break;
			case 2:
				agregarFavoritos();
				respuesta = -1;
				break;
			case 0:
				respuesta = -1;
				break elegirPublicaciones;
			default:
				System.out.println("Que desea hacer? ");
				System.out.println("1. Postularse ");
				System.out.println("2. Agregar a Favoritos ");
				System.out.println("0. Volver ");

				respuesta = scanner.nextInt();

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