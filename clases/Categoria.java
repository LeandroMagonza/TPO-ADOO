package clases;

public enum Categoria {

	IT,Sistemas,RRHH,Administracion,Ingenieria,Abogacia;

	public static Categoria transform(String s) {
		if(s.equalsIgnoreCase(IT.name()))
			return IT;
		else if(s.equalsIgnoreCase(Sistemas.name()))
			return Sistemas;
		else if(s.equalsIgnoreCase(RRHH.name()))
			return RRHH;
		else if(s.equalsIgnoreCase(Administracion.name()))
			return Administracion;
		else if(s.equalsIgnoreCase(Ingenieria.name()))
			return Ingenieria;
		else if(s.equalsIgnoreCase(Abogacia.name()))
			return Abogacia;
		else
			return null;
	}
}
