package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManagerTarea {
    // atributo
    public Tarea RequisitoSeleccionada;
    private static ArrayList<Tarea> listaTareas;
    private static ManagerRequisito instanciaRequisito;
    //constructor
    private ManagerTarea() {
    	listaTareas = new ArrayList<Tarea>();
        leerTareas();

    }
    public Boolean leerTareas() {
    	try {
    		FileReader entrada = new FileReader("almacenamientos/tareas.txt");
            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = "";
            miBuffer.readLine();
            linea = miBuffer.readLine();
            String[] arrayLinea = linea.split(";");
            int i = arrayLinea.length;
            while( i > 0) {
            	listaTareas.add(new Tarea(i,arrayLinea[i-1]));
            	i--;
            }
    		return false;
    	}catch (IOException e) {
            return false;
        }
    	
    }
    public static Tarea devolverTarea(int i){
    	for(Tarea tarea: listaTareas) {
    		if ( tarea.nroTarea==i)
    			return tarea;
    	}
    		return null;
    }
	public static ArrayList<Tarea> dividir(String s){
    	ArrayList<Tarea> lista = null;
    	String[] arrayLinea = s.split(":");
    	int i = arrayLinea.length;
    	while( i > 0) {
    		lista.add(devolverTarea(i));
    		i--;
    	}
		return lista;
    	
    }
}
