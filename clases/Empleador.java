package clases;

public class Empleador extends Usuario{
    String sector;
    int empresa;
    public Empleador(int dni,String nombre,String apellido,String mail, String contrasena,String sector,int empresa){
        super(dni,nombre,apellido,mail,contrasena);
        this.sector = sector;
        this.empresa = empresa;
    }

    public void abrirMenu(){
        System.out.println("logueado como: Empleador");
        MenuEmpleador.mostrarMenu();
    }
}
