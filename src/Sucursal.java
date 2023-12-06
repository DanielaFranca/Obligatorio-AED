import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sucursal {
    public String id;
    public String nombre;
    public String ciudad;
    public Empresa empresa;
    public ArrayList<Empleado> empleadosSucursal;

    public Sucursal(String pId, String pNombre, String pCiudad, Empresa pEmpresa, ArrayList<Empleado> pListaEmpleados) {
        this.id = pId;
        this.nombre = pNombre;
        this.ciudad = pCiudad;
        this.empresa = pEmpresa;
        this.empleadosSucursal = pListaEmpleados;
    }

    public Sucursal() { }



    @Override
    public String toString() {
        return "Sucursal" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ciudad=" + ciudad;
    }

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public List<Empleado> getEmpleadosSucursal() {
        return empleadosSucursal;
    }
    public void setEmpleadosSucursal(ArrayList<Empleado> empleadosSucursal) {
        this.empleadosSucursal = empleadosSucursal;
    }

    public List<Empleado> obtenerEmpleados() {
        return empleadosSucursal;
    }


    public void agregarEmpleado(Empleado empleado) {
        empleadosSucursal.add(empleado);
    }
    static ArrayList<Sucursal> pListaSucursal = new ArrayList<Sucursal>();
    public static void gestionSucursales(Scanner keyboard){
        limpiarConsola();
        boolean salir = false;
        while(salir == false){
            System.out.println("Ingrese la opcion deseada\n" +
                    "1- Alta Sucursal \n" +
                    "2- Actualizar Sucursal \n" +
                    "3- Eliminar Sucursal \n" +
                    "4- Listar sucursales \n" +
                    "5- Listar empleados de la sucursal en orden jerárgico \n" +
                    "0- Volver");
            //     try {
            short opcion4 = keyboard.nextShort();
            switch (opcion4) {
                case 1:
                    altaSucursal(keyboard);
                    break;
                case 2:
                    // actualizarSucursal(keyboard);
                    break;
                case 3:
                    // eliminarSucursal(keyboard);
                    break;
                case 4:
                    listarSucursales();
                    break;
                case 5:
                    listarEmpleadosEnOrden(keyboard);
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
    public static void listarSucursales(){
        System.out.println("Lista de Sucursales:");
        for (Sucursal pSucursal : pListaSucursal) {
            System.out.println(pSucursal.toString());
        }
    }
    public static Sucursal buscarSucursal(String pNombreSucursal){
        Sucursal LAsucursal = null;
        for (Sucursal pSucursal : pListaSucursal){
            if(pSucursal.getNombre().equalsIgnoreCase(pNombreSucursal)){
                LAsucursal = pSucursal;
            }
        }
        return LAsucursal;
    }

    public static void altaSucursal(Scanner keyboard){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos de la sucursal:");

        System.out.print("id: ");
        String pid = scanner.nextLine();

        System.out.print("Nombre: ");
        String pNombre = scanner.nextLine();

        System.out.print("ciudad: ");
        String  pciudad = scanner.nextLine();

        System.out.println("Empresas habilitadas:");
        Empresa.listarEmpresa();
        System.out.print("Seleccione el nombre de su empresa: ");
        String idEmpresa = scanner.nextLine();
        Empresa pEmpresa = Empresa.buscarEmpresa(idEmpresa);

        ArrayList<Empleado> pListaE = new ArrayList<Empleado>();

        Sucursal pSucursal = new Sucursal(pid, pNombre, pciudad, pEmpresa, pListaE);
        long cantidad = pListaSucursal.size();
        pListaSucursal.add(pSucursal);
        if(pListaSucursal.size() > cantidad){
            System.out.println("Sucursal agregado correctamente");
        }
        else{
            System.out.println("Error al guardar una Sucursal");
        }
    }

    public static void listarEmpleadosEnOrden(Scanner keyboard){
        Scanner scanner = new Scanner(System.in);
        listarSucursales();
        System.out.print("Seleccione nombre de la sucursal: ");
        String nombreSucursal = scanner.nextLine();
        Sucursal pSucursal = Sucursal.buscarSucursal(nombreSucursal);

       /* for (int i = 0; i < pSucursal.empleadosSucursal.size(); i++){
            for (int j = 0; j < pSucursal.empleadosSucursal.size() - 1; j++){
                if (pSucursal.empleadosSucursal.get(j).Ncargo < pSucursal.empleadosSucursal.get(j+1).Ncargo){
                    Empleado burbuja = pSucursal.empleadosSucursal.get(j);
                    pSucursal.empleadosSucursal.set(j, pSucursal.empleadosSucursal.get(j+1));
                    pSucursal.empleadosSucursal.set(j+1, burbuja);
                    //pSucursal.empleadosSucursal.get(j) = pSucursal.empleadosSucursal.get(j+1);
                    //pSucursal.empleadosSucursal.get(j+1) = burbuja;
                    //Collections.swap(pSucursal.empleadosSucursal, j, j+1);

                }
            }
        } */
        ArrayList<Empleado> empleadosOrdenados = new ArrayList<Empleado>();

        //ordenar lista
        /*for (Empleado pEmpleado : pSucursal.empleadosSucursal){
            for (int i = 0; i < 4; i++){
              //  for (int j = 0; i < 4; j++){
                    if (pEmpleado.Ncargo == i){
                        empleadosOrdenados.add(pEmpleado);
                    }
               // }

            }
        } */
        for (Empleado pEmpleado : pSucursal.empleadosSucursal) {
            int i = 0;
            while (i < empleadosOrdenados.size() && pEmpleado.Ncargo > empleadosOrdenados.get(i).Ncargo) {
                i++;
            }
            empleadosOrdenados.add(i, pEmpleado);
        }
        System.out.println("Lista de Empleados en orden jerárgico:");
        for (Empleado pEmpleado : empleadosOrdenados) {
            System.out.println(pEmpleado.toString());
        }



      /*  for (Empleado pEmpleado : pSucursal.empleadosSucursal) {
            for (pEmpleado.Ncargo = 1; pEmpleado.Ncargo < 4; pEmpleado.Ncargo++){
                if (pEmpleado.Ncargo == 1){
                    System.out.println("Gerente: " + pEmpleado.nombre + " " + pEmpleado.apellido);
                } else if (pEmpleado.Ncargo == 2) {
                    System.out.println("Supervisor: " + pEmpleado.nombre + " " + pEmpleado.apellido);
                } else if (pEmpleado.Ncargo == 3) {
                    System.out.println("Vendedor: " + pEmpleado.nombre + " " + pEmpleado.apellido);
                }
            }
        } */
    }
    public static void insertar (Sucursal pSucursal){
        pListaSucursal.add(pSucursal);
    }
    private static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
