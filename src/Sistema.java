import java.util.InputMismatchException;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean salir = false;
        while(salir == false) {

            System.out.println(" !\n" +
                    "Ingrese la opcion deseada\n" +
                    "1- Gestionar Empleados \n" +
                    "2- Gestionar Empresas \n" +
                    "3- Gestionar Sucursales \n" +
                    "4- Listar los empleados dada una sección ordenados de mayor a menor jerarquía \n" +
                    "5- Listar los empleados de una sucursal ordenados de mayor a menor jerarquía \n" +
                    "6- Listar los datos de un empleado dado por su identificador y de todos sus subordinados \n" +
                    "0- Salir");
            try {
                short opcion = keyboard.nextShort();
                switch (opcion) {
                    case 1:
                        Empleado pEmpleado = new Empleado();
                        pEmpleado.gestionEmpleados(keyboard);
                        break;
                    case 2:
                        Empresa pEmpresa = new Empresa();
                        pEmpresa.gestionEmpresas(keyboard);
                        break;
                    case 3:
                        Sucursal pSucursal = new Sucursal();
                        pSucursal.gestionSucursal(keyboard);
                        break;
                    case 4:
                        ArbolABB pArbolABB = new ArbolABB();
                        pArbolABB.preOrderSeccion(keyboard);
                        break;
                    case 5:
                        ArbolABB aArbolABB = new ArbolABB();
                        aArbolABB.preOrderSucursal(keyboard);
                        break;
                    case 6:
                        ArbolABB bArbolABB = new ArbolABB();
                        bArbolABB.preOrderSubordinados(keyboard);
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
