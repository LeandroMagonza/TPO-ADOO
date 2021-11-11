package clases;

import java.util.ArrayList;

public class ManagerIdioma {
//atributo
private ArrayList<Idioma> idiomas;
private static ManagerIdioma instanciaI;

//constructor
private ManagerIdioma()
{
    idiomas = new ArrayList<Idioma>();
}

public static ManagerIdioma getManagerIdioma()
{
    if (instanciaI == null)
    {
        instanciaI = new ManagerIdioma();
    }
    return instanciaI;
}
}
