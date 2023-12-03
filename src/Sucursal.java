import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sucursal {
    public String nombre;
    public String ciudad;
    public List<Empleado> empleadosSucursal;

    public Sucursal(String pnombre, String pciudad) {
        this.nombre = pnombre;
        this.ciudad = pciudad;
        this.empleadosSucursal = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleadosSucursal.add(empleado);
    }
    public List<Empleado> obtenerEmpleados() {
        return empleadosSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleadosSucursal() {
        return empleadosSucursal;
    }

    public void setEmpleadosSucursal(List<Empleado> empleadosSucursal) {
        this.empleadosSucursal = empleadosSucursal;
    }

    static ArrayList<Sucursal> pListaSucursal = new ArrayList<Sucursal>();
    public static void altaSucursal(Scanner keyboard){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos de la sucursal:");

        System.out.print("Nombre: ");
        String pNombre = scanner.nextLine();

        System.out.print("ciudad: ");
        String  pciudad = scanner.nextLine();

        System.out.print("ciudad: ");


        Sucursal pSucursal = new Sucursal(pNombre,pciudad);
        long cantidad = pListaSucursal.size();
        pListaSucursal.add(pSucursal);
        if(pListaSucursal.size() > cantidad){
            System.out.println("Sucursal agregado correctamente");
        }
        else{
            System.out.println("Error al guardar una Sucursal");
        }
    }


    private static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



}
