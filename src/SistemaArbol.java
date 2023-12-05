import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaArbol {
    public static void main(String[] args) {
        ArbolABB arbolABB = new ArbolABB();

        Empresa empresa1 = new Empresa("1", "Grido", "18 de julio 2021");
        Sucursal sucursal1 = new Sucursal("2", "Shopping", "Colonia", empresa1, null);
        Empleado empleado1 = new Empleado(1, "Juan", "Pérez", "123456789", 555123456, "Atención al público", sucursal1, "Vendedor", 3, "2023-01-01", 3000);
      //  Empleado empleado2 = new Empleado(2, "María", "López", "987654321", 555987654, "Contabilidad", sucursal1, "Contador de sucursal", 1, "2023-02-01", 4000);
        Empleado empleado3 = new Empleado(3, "Pedro", "González", "456789012", 555456789, "Atención al público", sucursal1, "Encargado", 2, "2023-03-01", 3500);
        Empleado empleado5 = new Empleado(5, "Juan", "Pérez", "123456789", 555123456, "Atención al público", sucursal1, "Vendedor", 3, "2023-01-01", 3000);


        arbolABB.insertar(empleado1);
        //arbolABB.insertar(empleado2);
        arbolABB.insertar(empleado3);
        arbolABB.insertar(empleado5);

        // Realizar un recorrido pre order (NID) del árbol
        //System.out.println("Recorrido de mayor a menor jerarquía del árbol:");
        //arbolABB.preOrder();

        // Realizar un recorrido pre order (NID) del árbol
        //System.out.println("Recorrido de mayor a menor jerarquía del árbol por sección:");
        //arbolABB.preOrderSeccion();

        Scanner keyboard = new Scanner(System.in);
        boolean salir = false;
        while(salir == false) {

            System.out.println("Bienvenido!\n" +
                    "Ingrese la opcion deseada\n" +
                    "1- Listar los empleados dada una sección ordenados de mayor a menor jerarquía \n" +
                    "2- Listar los empleados de una sucursal ordenados de mayor a menor jerarquía \n" +
                    "3- Listar los datos de un empleado dado por su identificador y de todos sus subordinados \n" +
                    "0- Salir");
            try {
                short opcion = keyboard.nextShort();
                keyboard.nextLine();
                switch (opcion) {
                    case 1:
                        arbolABB.preOrderSeccion();
                        break;
                    case 2:
                        arbolABB.preOrderSucursal();
                        break;
                    case 3:
                        arbolABB.preOrderSubordinados();
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
