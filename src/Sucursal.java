import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sucursal {
    public String id;
    public String nombre;
    public String ciudad;
    public Sucursal(String pid,String pnombre, String pciudad) {
        this.id = pid;
        this.nombre = pnombre;
        this.ciudad = pciudad;

    }

    public String getId() {
        return id;
    }

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

    @Override
    public String toString() {
        return "Sucursal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ciudad=" + ciudad +
                '}';
    }

    public static void gestionSucursal(Scanner keyboard){
        limpiarConsola();
        boolean salir = false;
        while(salir == false){
            System.out.println("Ingrese la opcion deseada\n" +
                    "1- Alta Sucursal \n" +
                    "2- Actualizar Sucursal \n" +
                    "3- Eliminar Sucursal \n" +
                    "4- Listar Sucursal \n" +
                    "0- Volver");
            //     try {
            short opcion4 = keyboard.nextShort();
            switch (opcion4) {
                case 1:
                    altaSucursal(keyboard);
                    break;
                case 2:
                    actualizarSucursal(keyboard);
                    break;
                case 3:
                    eliminarSucursal(keyboard);
                    break;
                case 4:
                    listarSucursal();
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


    static ArrayList<Sucursal> pListaSucursal = new ArrayList<Sucursal>();
    public static void altaSucursal(Scanner keyboard){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos de la sucursal:");

        System.out.print("id: ");
        String pid = scanner.nextLine();

        System.out.print("Nombre: ");
        String pNombre = scanner.nextLine();

        System.out.print("ciudad: ");
        String  pciudad = scanner.nextLine();

        Sucursal pSucursal = new Sucursal(pid,pNombre,pciudad);
        long cantidad = pListaSucursal.size();
        pListaSucursal.add(pSucursal);
        if(pListaSucursal.size() > cantidad){
            System.out.println("Sucursal agregado correctamente");
        }
        else{
            System.out.println("Error al guardar una Sucursal");
        }
    }

    public static void eliminarSucursal(Scanner keyboard){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre la sucursal que quiere eliminar:");
        String Enombre = scanner.nextLine();

        Sucursal sucursalE = null;
        for (Sucursal sucursal : pListaSucursal) {
            if (sucursal.getNombre().equals(Enombre)) {
                sucursalE = sucursal;
                pListaSucursal.remove(sucursalE);
                System.out.println("la sucursal se eliminó correctamente.");
                listarSucursal();
                break;
            }
        }
    }
    public static void listarSucursal(){
        System.out.println("Lista de sucursal:");
        for (Sucursal sucursal : pListaSucursal) {
            System.out.println(sucursal);
        }
    }
    public static void actualizarSucursal(Scanner keyboard){
        keyboard.nextLine();
        listarSucursal();
        System.out.println("Ingresa la id de la sucursal que deseas modificar:");
        String pid = keyboard.nextLine();
        Sucursal pSucursal = buscarSucursal(pid);
        boolean salir = false;
        while(salir == false) {
            if (pSucursal != null) {
                System.out.println("Seleccione lo que desea modificar: \n" +
                        "1 - Nombre: \n" +
                        "2 - Ciudad: \n" +
                        "0 - Volver");
                int opcion = keyboard.nextInt();
                keyboard.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre:");
                        String nuevoNombre = keyboard.nextLine();
                        pSucursal.setNombre(nuevoNombre);
                        System.out.println("Nombre modificado correctamente");
                        break;
                    case 2:
                        System.out.println("Ingrese la nueva Ciudad:");
                        String nuevaCiudad = keyboard.nextLine();
                        pSucursal.setCiudad(nuevaCiudad);
                        System.out.println("Ciudad modificado correctamente");
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
    public static Sucursal buscarSucursal(String pid){
        Sucursal lapSucursal = null;
        for (Sucursal pSucursal : pListaSucursal){
            if(pSucursal.getId().equalsIgnoreCase(pid)){
                lapSucursal = pSucursal;
                break;
            }
        }
        return lapSucursal;
    }


    private static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



}
