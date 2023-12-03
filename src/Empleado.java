public class Empleado {
    public int id;
    public String nombre;
    public String apellido;
    public String ci;
    public int tel;
    public String seccion;
    public String cargo;
    public String fechaI;
    public int sueldo;
    
    public Empleado(int pId, String pNombre, String pApellido, String pCi, int pTel, String pSeccion, String pCargo, String pFecha, int pSueldo) {
        this.id = pId;
        this.nombre = pNombre;
        this.apellido = pApellido;
        this.ci = pCi;
        this.tel = pTel;
        this.seccion = pSeccion;
        this.cargo = pCargo;
        this.fechaI = pFecha;
        this.sueldo = pSueldo;
    }

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
    public String getCargo() {
        return cargo;
    }
    public void setCargo (String cargo){
        this.cargo = cargo;
    }
    public String getFechaI() { return fechaI; }
    public void setFechaI (String fechaI) {this.fechaI = fechaI;}
    public int getSueldo() { return sueldo;}
    public void setSueldo(int sueldo){this.sueldo = sueldo;}

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", seccion='" + seccion + '\'' +
                ", cargo=" + cargo +
                '}';
    }
}
