import java.util.Scanner;

public class ArbolABB {
    private NodoABB raiz;
    public ArbolABB(){
        this.raiz = null;
    }
    public void insertar (Empleado pEmpleado){
        raiz = insertarR(raiz, pEmpleado);
    }
    public NodoABB insertarR(NodoABB pNodo, Empleado pEmpleado){
        if (pNodo == null){
            return new NodoABB(pEmpleado);
        }
        if (pEmpleado.getId() < pNodo.getEmpleado().getId()) {
            pNodo.setIzquierdo(insertarR(pNodo.getIzquierdo(), pEmpleado));
        } else if (pEmpleado.getId() > pNodo.getEmpleado().getId()) {
            pNodo.setDerecho(insertarR(pNodo.getDerecho(), pEmpleado));
        }

        return pNodo;
    }
    public Empleado buscar(int id) {
        return buscarRec(raiz, id);
    }
    private Empleado buscarRec(NodoABB nodo, int id) {
        if (nodo == null || nodo.getEmpleado().getId() == id) {
            return (nodo != null) ? nodo.getEmpleado() : null;
        }

        if (id < nodo.getEmpleado().getId()) {
            return buscarRec(nodo.getIzquierdo(), id);
        } else {
            return buscarRec(nodo.getDerecho(), id);
        }
    }

    public void preOrder() {
        preOrderRec(raiz);
    }
    private void preOrderRec(NodoABB nodo) {
        if (nodo != null) {
            System.out.println("ID: " + nodo.getEmpleado().getId() +
                    ", Nombre: " + nodo.getEmpleado().getNombre() +
                    ", Apellido: " + nodo.getEmpleado().getApellido() +
                    ", Sección: " + nodo.getEmpleado().getSeccion() +
                    ", Cargo: " + nodo.getEmpleado().getCargo());
            preOrderRec(nodo.getIzquierdo());
            preOrderRec(nodo.getDerecho());
        }
    }


    public void preOrderSeccion(Scanner keyboard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione sección: ");
        System.out.println("1 - Atención al público");
        System.out.println("2 - Contabilidad");
        String pSeccion = null;
        short opcion2 = scanner.nextShort();
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
        preOrderRecSeccion(raiz, pSeccion);
    }
    private void preOrderRecSeccion(NodoABB nodo, String pSeccion) {
        if (nodo != null) {
            if (nodo.getEmpleado().getSeccion().equals(pSeccion)) {
                System.out.println("ID: " + nodo.getEmpleado().getId() +
                        ", Nombre: " + nodo.getEmpleado().getNombre() +
                        ", Apellido: " + nodo.getEmpleado().getApellido() +
                        ", Sección: " + nodo.getEmpleado().getSeccion() +
                        ", Cargo: " + nodo.getEmpleado().getCargo());
                preOrderRecSeccion(nodo.getIzquierdo(), pSeccion);
                preOrderRecSeccion(nodo.getDerecho(), pSeccion);
            }
        }
    }

    public void preOrderSucursal(Scanner keyboard) {
        Scanner scanner = new Scanner(System.in);
        Sucursal.listarSucursal();
        System.out.print("Seleccione nombre de la sucursal: ");
        String nombreSucursal = scanner.nextLine();
        Sucursal pSucursal = Sucursal.buscarSucursal(nombreSucursal);
        preOrderRecSucursal(raiz, pSucursal);
    }
    private void preOrderRecSucursal(NodoABB nodo, Sucursal pSucursal) {
        if (nodo != null) {

            if (nodo.getEmpleado().getSucursal().equals(pSucursal)) {
                System.out.println("ID: " + nodo.getEmpleado().getId() +
                        ", Nombre: " + nodo.getEmpleado().getNombre() +
                        ", Apellido: " + nodo.getEmpleado().getApellido() +
                        ", Sección: " + nodo.getEmpleado().getSeccion() +
                        ", Cargo: " + nodo.getEmpleado().getCargo());
                preOrderRecSucursal(nodo.getIzquierdo(), pSucursal);
                preOrderRecSucursal(nodo.getDerecho(), pSucursal);
            }
        }
    }

    public void preOrderSubordinados(Scanner keyboard) {
        Scanner scanner = new Scanner(System.in);
        Empleado.listarEmpleados();
        System.out.println("Ingrese el ID del empleado que busca:");
        int pID = scanner.nextInt();
        Empleado pEmpleado = Empleado.buscarEmpleado(pID);

        preOrderRecSubordinados(raiz, pEmpleado);
    }
    private void preOrderRecSubordinados(NodoABB nodo, Empleado pEmpleado) {
        if (nodo != null) {
            if (nodo.getEmpleado().getSucursal().equals(pEmpleado.sucursal) && (nodo.getEmpleado().getSeccion().equals(pEmpleado.seccion)) && (nodo.getEmpleado().getNcargo() > pEmpleado.Ncargo)) {
                System.out.println("ID: " + nodo.getEmpleado().getId() +
                        ", Nombre: " + nodo.getEmpleado().getNombre() +
                        ", Apellido: " + nodo.getEmpleado().getApellido() +
                        ", Sección: " + nodo.getEmpleado().getSeccion() +
                        ", Cargo: " + nodo.getEmpleado().getCargo());
                preOrderRecSubordinados(nodo.getIzquierdo(), pEmpleado);
                preOrderRecSubordinados(nodo.getDerecho(), pEmpleado);
            }
        }
    }

}
