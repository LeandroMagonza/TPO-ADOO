package clases;

public enum Modalidad {
    PartTime, FullTime;

	public static Modalidad transform(String s) {
		if(s.equalsIgnoreCase(PartTime.name()))
			return PartTime;
		else if(s.equalsIgnoreCase(FullTime.name()))
			return FullTime;
		else
			return null;
	}
}
