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
    public void setId (int id) {
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
                "Id=" + id +
                ", Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", Seccion='" + seccion + '\'' +
                ", Cargo=" + cargo;
    }

    static ArrayList<Empleado> pListaEmpleados = new ArrayList<Empleado>();
    public static void gestionEmpleados(Scanner keyboard){
        limpiarConsola();
        boolean salir = false;
        while(salir == false){
            System.out.println("Ingrese la opcion deseada \n" +
                    "1- Alta Empleado \n" +
                    "2- Actualizar Empleado \n" +
                    "3- Eliminar Empleado \n" +
                    "4- Listar Empleados \n" +
                    "5- Listar Empleados por sección \n" +
                    "6- Subordinados de un empleado \n" +
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
                case 5:
                    listarEmpleadosPorSeccion(keyboard);
                    break;
                case 6:
                    arbolDeEmpleado(keyboard);
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
    public static void altaEmpleado(Scanner keyboard) {
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

        System.out.println("Sección: ");
        System.out.println("Debe elegir una de las siguientes opciones: ");
        System.out.println("1 - Atención al público");
        System.out.println("2 - Contabilidad");
        String pSeccion = null;
        short opcion2 = keyboard.nextShort();
        switch (opcion2) {
            case 1:
                pSeccion = "Atención al público";
                break;
            case 2:
                pSeccion = "Contabilidad";
                break;
            default:
                System.out.println("La opcion ingresada no es correcta");
                break;
        }

        System.out.print("Sucursales habilitadas: ");
        Sucursal.listarSucursales();
        System.out.println("Seleccione nombre de la sucursal: ");
        String nombreSucursal = scanner.nextLine();
        Sucursal pSucursal = Sucursal.buscarSucursal(nombreSucursal);


        String pCargo = null;
        int pNcargo = 0;
        System.out.println("Cargo: ");
        System.out.println("Debe elegir una de las siguientes opciones: ");
        if (pSeccion == "Atención al público") {
            System.out.println("1 - Supervisor de sucursal");
            System.out.println("2 - Encargado");
            System.out.println("3 - Vendedor");
            short opcion6 = keyboard.nextShort();
            switch (opcion6) {
                case 1:
                    pCargo = "Supervisor de sucursal";
                    pNcargo = 1;
                    break;
                case 2:
                    pCargo = "Encargado";
                    pNcargo = 2;
                    break;
                case 3:
                    pCargo = "Vendedor";
                    pNcargo = 3;
                    break;
                default:
                    System.out.println("La opción ingresada no es correcta, debe ingresar uno de los cargos existentes");
                    break;
            }
        } else if (pSeccion == "Contabilidad"){
            System.out.println("1 - Contador de sucursal");
            System.out.println("2 - Analista financiero");
            System.out.println("3 - Analista contable");
            short opcion8 = keyboard.nextShort();
            switch (opcion8) {
                case 1:
                    pCargo = "Contador de sucursal";
                    pNcargo = 1;
                    break;
                case 2:
                    pCargo = "Analista financiero";
                    pNcargo = 2;
                    break;
                case 3:
                    pCargo = "Analista contable";
                    pNcargo = 3;
                    break;
                default:
                    System.out.println("La opción ingresada no es correcta, debe ingresar uno de los cargos existentes");
                    break;
            }
        }

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
            pListaEmpleados.add(pEmpleado);
            ArbolABB arbolABB = new ArbolABB();
            arbolABB.insertar(pEmpleado);
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
    public static void listarEmpleadosPorSeccion(Scanner keyboard){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione sección: ");
        System.out.println("1 - Atención al público");
        System.out.println("2 - Contabilidad");
        String pSeccionE = null;
        short opcion2 = keyboard.nextShort();
        switch (opcion2) {
            case 1:
                pSeccionE = "Atención al público";
                break;
            case 2:
                pSeccionE = "Contabilidad";
                break;
            default:
                System.out.println("La opcion ingresada no es correcta");
                break;
        }

        ArrayList<Empleado> empleadosPorSeccion = new ArrayList<Empleado>();
        for (Empleado pEmpleado : pListaEmpleados){
            if (pEmpleado.seccion == pSeccionE){
                empleadosPorSeccion.add(pEmpleado);
            }
        }

       ArrayList<Empleado> empleadosOrdenados = new ArrayList<Empleado>();
        for (Empleado pEmpleado : empleadosPorSeccion) {
            int i = 0;
            while (i < empleadosOrdenados.size() && pEmpleado.Ncargo > empleadosOrdenados.get(i).Ncargo) {
                i++;
            }
            empleadosOrdenados.add(i, pEmpleado);
        }
        System.out.println("Lista de Empleados en orden jerárgico de una sección" +
                ":");
        for (Empleado pEmpleado : empleadosOrdenados) {
            System.out.println(pEmpleado.toString());
        }

    }
    public static void actualizarEmpleados(Scanner keyboard){
        keyboard.nextLine();
        listarEmpleados();
        System.out.println("Ingrese el ID del empleado que desee modificar:");
        int pID = keyboard.nextInt();
        Empleado pEmpleado = buscarEmpleado(pID);
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
    public static Empleado buscarEmpleado(int pID){
        Empleado elEmpleado = null;
        for (Empleado pEmpleado : pListaEmpleados){
            if(pEmpleado.id == pID){
                elEmpleado = pEmpleado;
                break;
            }
        }
        return elEmpleado;
    }
    public static void arbolDeEmpleado(Scanner keyboard){
        Scanner scanner = new Scanner(System.in);
        listarEmpleados();
        System.out.println("Ingrese el ID del empleado que busca:");
        int pID = scanner.nextInt();
        Empleado Jefecito = buscarEmpleado(pID);

        ArrayList<Empleado> subordinados = new ArrayList<Empleado>();
        subordinados.add(Jefecito);

        for (Empleado pEmpleado : pListaEmpleados){
            if ((pEmpleado.sucursal == Jefecito.sucursal) && (pEmpleado.seccion == Jefecito.seccion) && (pEmpleado.Ncargo > Jefecito.Ncargo)){
                subordinados.add(pEmpleado);
            }
        }

        System.out.println("Los datos del empleado consultado y sus subordinados son:" +
                ":");
        for (Empleado pEmpleado : subordinados) {
            System.out.println(pEmpleado.toString());
        }

    }
    public static void insertar (Empleado pEmpleado){
        pListaEmpleados.add(pEmpleado);
        ArbolABB arbolABB = new ArbolABB();
       // arbolABB.insertar(pEmpleado);
    }
    private static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    //endregion
}
