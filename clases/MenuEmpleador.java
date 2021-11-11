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
			respuesta = scanner.nextLine();
		}
			scanner.close();
			System.out.println("exito");
			int respuestaNum = Integer.parseInt(respuesta);
			switch(respuestaNum){
			case 1:
				;
			case 2:
				;
				
		}
		
	}
	
}
