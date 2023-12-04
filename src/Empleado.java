import java.util.ArrayList;
import java.util.Scanner;

public class Empleado {
    public int id;
    public String nombre;
    public String apellido;
    public String ci;
    public int tel;
    public String seccion;
    public Sucursal sucursal;
    public String cargo;
    public int Ncargo;
    public String fechaI;
    public int sueldo;
    
    public Empleado(int pId, String pNombre, String pApellido, String pCi, int pTel, String pSeccion, Sucursal pSucrusal, String pCargo, int pNcargo, String pFecha, int pSueldo) {
        this.id = pId;
        this.nombre = pNombre;
        this.apellido = pApellido;
        this.ci = pCi;
        this.tel = pTel;
        this.seccion = pSeccion;
        this.sucursal = pSucrusal;
        this.cargo = pCargo;
        this.Ncargo = pNcargo;
        this.fechaI = pFecha;
        this.sueldo = pSueldo;
    }
    public Empleado() {}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido (String apellido){
        this.apellido = apellido;
    }
    public String getCi() { return ci; }
    public void setCi(String ci) {this.ci = ci;}
    public int getTel() {
        return tel;
    }
    public void setTel(int tel) {
        this.tel = tel;
    }
    public String getSeccion() {
        return seccion;
    }
    public void setSeccion (String seccion){
        this.seccion = seccion;
    }
    public Sucursal getSucursal() {
        return sucursal;
    }
    public void setSucursal (Sucursal sucursal){
        this.sucursal = sucursal;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo (String cargo){
        this.cargo = cargo;
    }
    public int getNcargo() {
        return Ncargo;
    }
    public void setNcargo(int Ncargo) {
        this.Ncargo = Ncargo;
    }
    public String getFechaI() { return fechaI; }
    public void setFechaI (String fechaI) {this.fechaI = fechaI;}
    public int getSueldo() { return sueldo;}
    public void setSueldo(int sueldo){this.sueldo = sueldo;}

    @Override
    public String toString() {
        return "Empleado" +
                "Id: " + id +
                ", Nombre: '" + nombre + '\'' +
                ", Apellido: '" + apellido + '\'' +
                ", Seccion: '" + seccion + '\'' +
                ", Cargo: " + cargo ;
    }
    
    static ArrayList<Empleado> pListaEmpleados = new ArrayList<Empleado>();
    
    
    public static void gestionEmpleados(Scanner keyboard){
        limpiarConsola();
        boolean salir = false;
        while(salir == false){
            System.out.println("Ingrese la opcion deseada\n" +
                    "1- Alta Empleado \n" +
                    "2- Actualizar Empleado \n" +
                    "3- Eliminar Empleado \n" +
                    "4- Listar Empleados \n" +
                    "0- Volver");
            //     try {
            short opcion4 = keyboard.nextShort();
            switch (opcion4) {
                case 1:
                    altaEmpleado(keyboard);
                    break;
                case 2:
                    actualizarEmpleados(keyboard);
                    break;
                case 3:
                    eliminarEmpleado(keyboard);
                    break;
                case 4:
                    listarEmpleados();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("La opcion ingresada no es correcta");
                    break;
            }
        }
    }

    //region METODOS ABM
    public static void altaEmpleado(Scanner keyboard){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del empleado:");

        System.out.print("Id: ");
        int pId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre: ");
        String pNombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String pApellido = scanner.nextLine();

        System.out.print("Cédula: ");
        String pCi = scanner.nextLine();

        System.out.print("Teléfono: ");
        int pTel = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Sección: ");
        String pSeccion = scanner.nextLine();

        System.out.print("Sucursales habilitadas: ");
        Sucursal.listarSucursales();
        System.out.print("Seleccione nombre de la sucursal: ");
        String nombreSucursal = scanner.nextLine();
        Sucursal pSucursal = Sucursal.buscarSucursal(nombreSucursal);

        System.out.println("Cargo: ");
        System.out.println("Debe elegir una de las siguientes opciones: ");
        System.out.println("Gerente de sucursal");
        System.out.println("Supervisor");
        System.out.println("Vendedor");
        String pCargo = scanner.nextLine();

        String opcion = pCargo;
        int pNcargo = 0;
        switch (opcion) {
            case "Gerente de sucursal":
                pNcargo = 1;
                break;
            case "Supervisor":
                pNcargo = 2;
                break;
            case "Vendedor":
                pNcargo = 3;
                break;
            default:
                System.out.println("La opcion ingresada no es correcta, debe ingresar uno de los cargos existentes");
                break;
        }
        scanner.nextLine();

        System.out.print("Fecha: ");
        String pFecha = scanner.nextLine();

        System.out.print("Sueldo: ");
        int pSueldo = scanner.nextInt();
        scanner.nextLine();

        Empleado pEmpleado = new Empleado(pId, pNombre, pApellido, pCi, pTel, pSeccion, pSucursal, pCargo, pNcargo, pFecha, pSueldo);
        int cantEmpleadosPuesto = 0;
        for (Empleado pEmpleado2 : pSucursal.empleadosSucursal){
            if (pEmpleado2.Ncargo == pNcargo){
                cantEmpleadosPuesto++;
                break;
            }
        }
          // ver que no haya 2 gerentes
        if (cantEmpleadosPuesto == 1 && pNcargo == 1){
            System.out.println("Ya hay un gerente en esta sucursal");
            // ver que no haya 3 supervisores
        } else if (cantEmpleadosPuesto == 2 && pNcargo == 2) {
            System.out.println("Ya hay suficientes supervisores en esta sucursal");
            // ver que no haya 5 vendedores
        } else if (cantEmpleadosPuesto == 4 && pNcargo == 3) {
            System.out.println("Ya hay suficientes vendedores en esta sucursal");
        } else {
            pSucursal.agregarEmpleado(pEmpleado);
            System.out.println("Empleado agregado a la sucursal correctamente");
        }
    }
    public static void eliminarEmpleado(Scanner keyboard){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la CI del empleado que quiere eliminar:");
        String ciE = scanner.nextLine();

        Empleado empleadoE = null;
        for (Empleado empleado : pListaEmpleados) {
            if (empleado.getCi().equals(ciE)) {
                empleadoE = empleado;
                pListaEmpleados.remove(empleadoE);
                System.out.println("El empleado se eliminó correctamente.");
                listarEmpleados();
                break;
            }
        }
    }
    public static void listarEmpleados(){
        System.out.println("Lista de empleados:");
        for (Empleado empleado : pListaEmpleados) {
            System.out.println(empleado);
        }
    }
    public static void actualizarEmpleados(Scanner keyboard){
        keyboard.nextLine();
        listarEmpleados();
        System.out.println("Ingrese CI del empleado que desee modificar:");
        String pCi = keyboard.nextLine();
        Empleado pEmpleado = buscarEmpleado(pCi);
        boolean salir = false;
        while(salir == false) {
            if (pEmpleado != null) {
                System.out.println("Seleccione lo que desea modificar: \n" +
                        "1 - Nombre: \n" +
                        "2 - Apellido: \n" +
                        "3 - CI: \n" +
                        "4 - Sueldo: \n" +
                        "5 - Cargo: \n" +
                        "6 - Sección: \n" +
                        "0 - Volver");
                int opcion = keyboard.nextInt();
                keyboard.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre:");
                        String nuevoNombre = keyboard.nextLine();
                        pEmpleado.setNombre(nuevoNombre);
                        System.out.println("Nombre modificado correctamente");
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo apellido:");
                        String nuevoApellido = keyboard.nextLine();
                        pEmpleado.setApellido(nuevoApellido);
                        System.out.println("Apellido modificado correctamente");
                        break;
                    case 3:
                        System.out.println("Ingrese la nueva CI:");
                        String nuevaCI = keyboard.nextLine();
                        pEmpleado.setCi(nuevaCI);
                        System.out.println("CI modificada correctamente");
                        break;
                    case 4:
                        System.out.println("Ingrese el nuevo sueldo:");
                        int nuevoSueldo = keyboard.nextInt();
                        pEmpleado.setSueldo(nuevoSueldo);
                        System.out.println("Sueldo modificado correctamente");
                        break;
                    case 5:
                        System.out.println("Ingrese nuevo cargo:");
                        String nuevoCargo = keyboard.nextLine();
                        pEmpleado.setCargo(nuevoCargo);
                        System.out.println("Cargo modificado correctamente");
                        break;
                    case 6:
                        System.out.println("Ingrese nueva sección:");
                        String nuevaSeccion = keyboard.nextLine();
                        pEmpleado.setSeccion(nuevaSeccion);
                        System.out.println("Sección modificada correctamente");
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción Incorrecta");
                        break;
                }
            }
            else{
                System.out.println("El empleado no existe");
            }
        }
    }
    public static Empleado buscarEmpleado(String pCI){
        Empleado elEmpleado = null;
        for (Empleado pEmpleado : pListaEmpleados){
            if(pEmpleado.getCi().equalsIgnoreCase(pCI)){
                elEmpleado = pEmpleado;
                break;
            }
        }
        return elEmpleado;
    }
    private static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    //endregion
}
