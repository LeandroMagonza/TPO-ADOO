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
		Scanner scanner = new Scanner(System.in);
		String respuesta = "";
		while (respuesta != "1" || respuesta != "2") {
			System.out.println("Menu");
			System.out.println("1. Crear publicación ");
			System.out.println("2. Ver publicación ");
			System.out.print("Ingrese el numero de la opción : ");
			respuesta = scanner.nextLine(); // ATENCION, PROBLEMAS CON EL SCANNER
		}
			scanner.close();
			int respuestaNum = Integer.parseInt(respuesta);
			switch(respuestaNum){
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
		Scanner scanner = new Scanner(System.in);
		String respuesta = "";
		System.out.println("Usted ha seleccionado ver publicación");
		while (respuesta != "1" || respuesta != "2" || respuesta != "3") {
			System.out.println("1. Buscar con el Nro de publicación");
			System.out.println("2. Mostrar Nro y descripción");
			System.out.println("3. Volver al menu anterior");
			System.out.println("Ingrese el numero de la opción : ");
			respuesta = scanner.nextLine();//MISMO PROBLEMA
		}
		scanner.close();
		int respuestaNum = Integer.parseInt(respuesta);
		switch(respuestaNum){
		/* FALTA MODIFICAR
		case 1:
			crearPublicacion();
		case 2:
			verPublicacion();
			*/
			
	}
		
	}
	
}
