package clases;

public class Empresa {
    long cuitEmpresa;
    String nombre;
    String direccion;
    String localidad;
    int telefono;
    String cuit;
    String correo;

    public Empresa(long cuitEmpresa, String nombre, String direccion, String localidad, int telefono, String correo) {
        this.cuitEmpresa = cuitEmpresa;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
        this.correo = correo;
    }
}
