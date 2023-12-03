import java.util.InputMismatchException;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean salir = false;
        while(salir == false) {

            System.out.println("Bienvenido!\n" +
                    "Ingrese la opcion deseada\n" +
                    "1- Gestionar Empleados \n" +
                    "2- Gestionar Empresas \n" +
                    "3- Gestionar Sucursales \n" +
                    "0- Salir");
            try {
                short opcion = keyboard.nextShort();
                switch (opcion) {
                    case 1:
                        Empleado pEmpleado = new Empleado();
                        pEmpleado.gestionEmpleados(keyboard);
                        break;
                    case 2:
                    //    MetodosTecnico pMetodoT = new MetodosTecnico();
                    //    pMetodoT.gestionTecnicos(keyboard);
                        break;
                    case 3:
                    //    MetodosEquipo pMetodoE = new MetodosEquipo();
                    //    pMetodoE.gestionarEquipos(keyboard);
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("La opción ingresada no es correcta");
                        break;
                }
            } catch (InputMismatchException e) {
                String ingreso = keyboard.nextLine();
                System.err.println("Debe ingresar un numero, no '" + ingreso + "'");
            }
        }
        keyboard.close();
    }
}
