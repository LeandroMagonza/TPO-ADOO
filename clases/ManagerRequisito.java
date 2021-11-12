package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManagerRequisito {

    // atributo
    public Requisito RequisitoSeleccionada;
    private static ArrayList<Requisito> listaRequisitos;
    private static ManagerRequisito instanciaRequisito;
    //constructor
    private ManagerRequisito() {
        listaRequisitos = new ArrayList<Requisito>();
        leerRequisitos();

    }
    public Boolean leerRequisitos() {
    	try {
    		FileReader entrada = new FileReader("almacenamientos/requisitostxt");
            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = "";
            miBuffer.readLine();
            linea = miBuffer.readLine();
            String[] arrayLinea = linea.split(";");
            int i = arrayLinea.length;
            while( i > 0) {
            	listaRequisitos.add(new Requisito(i,arrayLinea[i-1]));
            	i--;
            }
    		return false;
    	}catch (IOException e) {
            return false;
        }
    	
    }
    public static Requisito devolverRequisito(int i){
    	for(Requisito requisito: listaRequisitos) {
    		if ( requisito.idRequisito==i)
    			return requisito;
    	}
    		return null;
    }
	public static ArrayList<Requisito> dividir(String s){
    	ArrayList<Requisito> lista = null;
    	String[] arrayLinea = s.split(":");
    	int i = arrayLinea.length;
    	while( i > 0) {
    		lista.add(devolverRequisito(i));
    		i--;
    	}
		return lista;
    	
    }
}
