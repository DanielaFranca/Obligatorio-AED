public class NodoABB {
    private Empleado empleado;
    private NodoABB izq;
    private NodoABB der;

    public NodoABB(Empleado empleado) {
        this.empleado = empleado;
        this.izq = null;
        this.der = null;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public NodoABB getDerecho() {
        return der;
    }
    public void setIzquierdo(NodoABB izq) {
        this.izq = izq;
    }
    public NodoABB getIzquierdo() {
        return izq;
    }
    public void setDerecho(NodoABB der) {
        this.der = der;
    }
}