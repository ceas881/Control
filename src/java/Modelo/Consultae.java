package Modelo;

/**
 *
 * @author AMAF
 */
public class Consultae {
    private String dni;
    private String nombre;
    private String apellido;
    private String fecha;
    private String hora_ingreso;
    private String hora_salida;
    private String actualizarHoraSalida;

    public Consultae() {
        
    }
    
    // Constructor
    public Consultae(String dni, String nombre, String apellido, String fecha, String hora_ingreso,String hora_salida) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.hora_ingreso = hora_ingreso;
        this.hora_salida = hora_salida;
    }

    // Getters y setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getfecha() {
        return fecha;
    }

    public void setfecha(String fecha) {
        this.fecha = fecha;
    }

    public String gethora_ingreso() {
        return hora_ingreso;
    }

    public void sethora_ingreso(String hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    public String gethora_salida() {
        return hora_salida;
    }

    public void sethora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }
}