package clases;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MenuEmpleador {
    // crear publicacion
    // ver publicaciones {
    //      modificar publicacion
    //      eliminar publicacion
    //      ver postulantes de publicacion
    // }
	public static void mostrarMenu() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Menu");
			System.out.println("1. Crear publicacion ");
			System.out.println("2. Ver publicacion ");
			System.out.println("Ingrese el numero de la opcion : ");
			String respuesta = scanner.nextLine(); // ATENCION, PROBLEMAS CON EL SCANNER
			if(respuesta == "1" || respuesta == "2") {
				scanner.close();
				int respuestaNum = Integer.parseInt(respuesta);
				switch(respuestaNum){
				case 1:
					crearPublicacion();
				case 2:
					verPublicacion();
				}
				break;
			}
				
		}
		
	}
	private static void crearPublicacion() {
		Scanner scanner = new Scanner(System.in);
		String respuesta = "";
		System.out.println("Usted ha seleccionado crear publiación");
		
	}
	private static void verPublicacion() {
		Scanner scanner = new Scanner(System.in);
		String respuesta = "";
		System.out.println("Usted ha seleccionado ver publicación");
		while (respuesta != "1" || respuesta != "2" || respuesta != "3") {
			System.out.println("1. Buscar con el Nro de publicación");
			System.out.println("2. Mostrar lista de publicaciones");
			System.out.println("3. Volver al menu anterior");
			System.out.println("Ingrese el numero de la opción : ");
			respuesta = scanner.nextLine();//MISMO PROBLEMA
		}
		scanner.close();
		int respuestaNum = Integer.parseInt(respuesta);
		switch(respuestaNum){
		
			case 1:
				buscarPublicacion();
			case 2:
				mostrarListaPublicaciones();
			case 3:
				mostrarMenu();
			}
	}
	//busca la publicacion hay que crear metodo en publicacion conttroler
	private static void buscarPublicacion() {
		
	}
	
	//muestra la lista para luego seleccionar la que quiere
	private static void mostrarListaPublicaciones() {
		
	}
	
}
