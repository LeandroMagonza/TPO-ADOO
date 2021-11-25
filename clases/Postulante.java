package clases;

import java.util.Date;
import java.util.ArrayList;


public class Postulante extends Usuario {
    Date fechaNacimiento;
    ArrayList<Nacionalidad> nacionalidades = new ArrayList<Nacionalidad>();
    ArrayList<Idioma> idiomas = new ArrayList<Idioma>();
    ArrayList<Categoria> intereses = new ArrayList<Categoria>();
    ArrayList<Publicacion> publicacionesFavoritas = new ArrayList<Publicacion>();

    public Postulante(int dni,String nombre,String apellido,String mail, String contrasena,Date fechaNacimiento,ArrayList<Categoria> intereses){
        super(dni,nombre,apellido,mail,contrasena);
        this.intereses = intereses;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void abrirMenu(){
        System.out.println("logueado como: Postulante");
        MenuPostulante.mostrarMenu();
        
    }
    public ArrayList<Publicacion> getPublicacionesFavoritas(){
        return publicacionesFavoritas;
        
    }

    public void agregarPublicacionAFavoritas(Publicacion publicacion){
        if (!publicacionesFavoritas.contains(publicacion)){
            publicacionesFavoritas.add(publicacion);
        }
    }
    public void removerPublicacionDeFavoritas(Publicacion publicacion){
            publicacionesFavoritas.remove(publicacion);
    }

}
