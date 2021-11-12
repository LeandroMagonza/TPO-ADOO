package clases;

public enum TipoTrabajo {
	    Remoto, Presencial;

		public static TipoTrabajo transform(String s) {
			if(s.equalsIgnoreCase(Presencial.name()))
				return Presencial;
			else if(s.equalsIgnoreCase(Remoto.name()))
				return Remoto;
			else
				return null;
		}
}
