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
		Scanner scanner = ManagerLogIn.scanner;
		int respuesta = 0;
		while (respuesta != 1 && respuesta != 2) {
			System.out.println("Menu");
			System.out.println("1. Crear publicación ");
			System.out.println("2. Ver publicación ");
			System.out.print("Ingrese el numero de la opción : ");
			respuesta = scanner.nextInt(); 
		}
			int respuestaNum = respuesta;
			switch(respuestaNum){
			case 1:
				crearPublicacion();
			case 2:
				verPublicacion();
		}
	}
	private static void crearPublicacion() {
		Scanner scanner = ManagerLogIn.scanner;
		String respuesta = "";
		System.out.println("Usted ha seleccionado crear publicacion");
		
	}
	private static void verPublicacion() {
		Scanner scanner = ManagerLogIn.scanner;
		int respuesta = 0;
		System.out.println("Usted ha seleccionado ver publicación");
		while ((respuesta != 1) && (respuesta != 2) && (respuesta != 3)) {
			System.out.println("1. Buscar con el Nro de publicación");
			System.out.println("2. Mostrar Listado");
			System.out.println("3. Volver al menu anterior");
			System.out.println("Ingrese el numero de la opción : ");
			respuesta = scanner.nextInt();
			scanner.nextLine();
		}
		switch(respuesta){
		case 1:
			buscarPublicacionXNro();
		case 2:
			verPublicacion();
		case 3:
			mostrarMenu();
			
	}
		
	}
	private static void buscarPublicacionXNro() {

	}
	
}
