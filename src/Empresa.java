import java.util.ArrayList;
import java.util.Scanner;
public class Empresa {
   public String id;
   public String nombre;
   public String direccion;
   public Empresa(String pid, String pNombre, String pDireccion){
      this.id =pid;
      this.nombre = pNombre;
      this.direccion = pDireccion;
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

   public String getDireccion() {
      return direccion;
   }

   public void setDireccion(String direccion) {
      this.direccion = direccion;
   }

   @Override
   public String toString() {
      return "Empresa{" +
              "id=" + id +
              ", nombre='" + nombre + '\'' +
              ", direccion=" + direccion +
              '}';
   }
   static ArrayList<Empresa> pListaEmpresas = new ArrayList<Empresa>();

   public static void gestionEmpleados(Scanner keyboard){
      limpiarConsola();
      boolean salir = false;
      while(salir == false){
         System.out.println("Ingrese la opcion deseada\n" +
                 "1- Alta Empresa \n" +
                 "2- Actualizar Empresa \n" +
                 "3- Eliminar Empresa \n" +
                 "4- Listar Empresa \n" +
                 "0- Volver");
         //     try {
         short opcion4 = keyboard.nextShort();
         switch (opcion4) {
            case 1:
               altaEmpresa(keyboard);
               break;
            case 2:
               actualizarEmpresa(keyboard);
               break;
            case 3:
               eliminarEmpresa(keyboard);
               break;
            case 4:
               listarEmpresa();
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

   public static void altaEmpresa(Scanner keyboard){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Ingrese los datos de la Empresa:");

      System.out.print("Id: ");
      String pId = scanner.nextLine();

      System.out.print("Nombre: ");
      String pNombre = scanner.nextLine();

      System.out.print("Direccion: ");
      String pdireccion  = scanner.nextLine();


      Empresa pEmpresa = new Empresa(pId, pNombre, pdireccion);
      long cantidad = pListaEmpresas.size();
      pListaEmpresas.add(pEmpresa);
      if(pListaEmpresas.size() > cantidad){
         System.out.println("Empresa agregado correctamente");
      }
      else{
         System.out.println("Error al guardar una Empresa");
      }
   }
//equals(Eid)
   public static void eliminarEmpresa(Scanner keyboard){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Ingrese el nombre la empresa que quiere eliminar:");
      String Enombre = scanner.nextLine();

      Empresa empresaE = null;
      for (Empresa empresa : pListaEmpresas) {
         if (empresa.getNombre().equals(Enombre)) {
            empresaE = empresa;
            pListaEmpresas.remove(empresaE);
            System.out.println("la empresa se eliminó correctamente.");
            listarEmpresa();
            break;
         }
      }
   }
   public static void listarEmpresa(){
      System.out.println("Lista de empresas:");
      for (Empresa empresa : pListaEmpresas) {
         System.out.println(empresa);
      }
   }
   public static void actualizarEmpresa(Scanner keyboard){
      keyboard.nextLine();
      listarEmpresa();
      System.out.println("Ingresa la id de la empresa que deseas modificar:");
      String pid = keyboard.nextLine();
      Empresa pEmpresa = buscarEmpresa(pid);
      boolean salir = false;
      while(salir == false) {
         if (pEmpresa != null) {
            System.out.println("Seleccione lo que desea modificar: \n" +
                    "1 - Nombre: \n" +
                    "2 - Direccion: \n" +
                    "0 - Volver");
            int opcion = keyboard.nextInt();
            keyboard.nextLine();
            switch (opcion) {
               case 1:
                  System.out.println("Ingrese el nuevo nombre:");
                  String nuevoNombre = keyboard.nextLine();
                  pEmpresa.setNombre(nuevoNombre);
                  System.out.println("Nombre modificado correctamente");
                  break;
               case 2:
                  System.out.println("Ingrese la nueva Direccion:");
                  String nuevaDireccion = keyboard.nextLine();
                  pEmpresa.setDireccion(nuevaDireccion);
                  System.out.println("Direccion modificado correctamente");
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
   public static Empresa buscarEmpresa(String pid){
      Empresa laEmpresa = null;
      for (Empresa pEmpresa : pListaEmpresas){
         if(pEmpresa.getId().equalsIgnoreCase(pid)){
            laEmpresa = pEmpresa;
            break;
         }
      }
      return laEmpresa;
   }



   private static void limpiarConsola() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
   }
}


