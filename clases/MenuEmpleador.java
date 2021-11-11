package clases;

import static java.lang.System.out;
import java.util.Scanner;

public class MenuEmpleador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerLogIn managerLogIn = ManagerLogIn.getManagerLogIn();
        // Checkear Log In
        while (true) {
            System.out.println("Ingrese su usuario:");
            String usuario = scanner.nextLine();
            System.out.printf("Usuario :" + usuario +"\n");
            System.out.println("Ingrese su contrasena:");
            String contrasena = scanner.nextLine();
            System.out.printf("Contrasena :" + contrasena +"\n");
            Usuario usuarioLogueado = managerLogIn.checkearLogIn(usuario, contrasena);
            if (usuarioLogueado != null) {
                break;
            }
            System.out.println("Nombre de usuario o contrasena incorrectas");
        }
        scanner.close();
    }
}
