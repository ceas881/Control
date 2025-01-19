package Modelo;

/**
 *
 * @author AMAF
 */
public class Empleado {
    int id_empleado;
    String nombre;
    String apellido;
    String dni;
    String telefono;
    String Email;
    int id_departamento;

    public Empleado(){
    }

    public Empleado(String nombre, String apellido, String dni, String telefono, String Email, int id_departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.Email = Email;
        this.id_departamento = id_departamento;
    }

    public int getid_empleado() {
        return id_empleado;
    }

    public void setid_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getapellido() {
        return apellido;
    }

    public void setapellido(String apellido) {
        this.apellido = apellido;
    }

    public String getdni() {
        return dni;
    }

    public void setdni(String dni) {
        this.dni = dni;
    }

    public String gettelefono() {
        return telefono;
    }

    public void settelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getid_departamento() {
        return id_departamento;
    }

    public void setid_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }
}
