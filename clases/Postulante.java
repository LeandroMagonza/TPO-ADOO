package clases;

import java.util.Date;
import java.util.ArrayList;


public class Postulante extends Usuario {
    Date fechaNacimiento;
    ArrayList<Nacionalidad> nacionalidades;
    ArrayList<Idioma> idiomas;
    ArrayList<Categoria> intereses;
    ArrayList<Publicacion> publicacionesFavoritas;

    public Postulante(int dni,String nombre,String apellido,String mail, String contrasena,Date fechaNacimiento){
        super(dni,nombre,apellido,mail,contrasena);
        this.fechaNacimiento = fechaNacimiento;
    }

    public void abrirMenu(){
        System.out.println("logueado como: Postulante");
        MenuPostulante.mostrarMenu();
        
    }

}
