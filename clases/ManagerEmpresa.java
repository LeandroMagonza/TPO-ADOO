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

		//Empresas de ejemplo
		empresas.add(new Empresa(1111111,"Uade","Independencia","CABA",46417903,"rrhh@uade.edu.ar"));
		empresas.add(new Empresa(2222222, "Cinemark Palermo", "Santa Fe y Cnel Diaz", "CABA", 46431038, "empleos@cinemark.com"));
		empresas.add(new Empresa(3333333, "Mcdonalds", "Rivadavia y Alberdi", "CABA", 46431838, "empleos@mickyds.com"));
		empresas.add(new Empresa(18273940,"Uca","Alicia Moreau","CABA",42856935,"rrhh@uca.edu.ar"));
		empresas.add(new Empresa(78623518,"UP","Mario Bravo","CABA",42656512,"rrhh@up.edu.ar"));
		empresas.add(new Empresa(41587231,"Torcuato DiTella","FigueroaAlcorta","CABA",42856194,"rrhh@tdt.edu.ar"));
		empresas.add(new Empresa(77442144,"Uai","San Juan","CABA",42159753,"rrhh@uai.edu.ar"));
	}
	
	public static ManagerEmpresa getManagerEmpresa()
	{
		if (instanciaEM == null)
		{
			instanciaEM = new ManagerEmpresa();
		}
		return instanciaEM;
	}
	public ArrayList<Empresa> getListaEmpresas()
	{
		return empresas;
	}

	public Empresa getEmpresaPorCuit(long cuitEmpresa){
		for (Empresa empresa : empresas) {
			if (empresa.cuitEmpresa == cuitEmpresa) {
				return empresa;
			}
		}
		return null;
	}
	
}