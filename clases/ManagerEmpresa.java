package clases;
import java.util.ArrayList;


public class ManagerEmpresa 
{
	//atributo
	private ArrayList<Empresa> empresas;
	private static ManagerEmpresa instanciaEM;
	
	//constructor
	private ManagerEmpresa()
	{
		empresas = new ArrayList<Empresa>();
	}
	
	public static ManagerEmpresa getManagerEmpresa()
	{
		if (instanciaEM == null)
		{
			instanciaEM = new ManagerEmpresa();
		}
		return instanciaEM;
	}
	
}