package clases;

public class Empleador extends Usuario{
    String sector;
    Empresa empresa;
    public Empleador(int dni,String nombre,String apellido,String mail, String contrasena,String sector,String empresa){
        super(dni,nombre,apellido,mail,contrasena);
        this.sector = sector;
        this.empresa = new Empresa();
    }

    public void abrirMenu(){
        System.out.println("logueado como: empleador");
        MenuEmpleador.mostrarMenu();
        
    }
    
  }
