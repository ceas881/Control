package Modelo;

/**
 *
 * @author AMAF
 */
public class Producto {
    private int codigo;
    private String nombre;
    private int inventario;

    public Producto() {
    }
    
    //Constructor para agregar
    public Producto(String nombre, int inventario) {
        this.nombre = nombre;
        this.inventario = inventario;
    }

    //Constructor para actualizar
    public Producto(int codigo, String nombre, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.inventario = inventario;
    }

    //getter y setter  -- Modificadores de acceso
    public int getcodigo() {//get es = a optener
        return codigo;
    }

    public void setcodigo(int codigo) {// set es = a asignar
        this.codigo = codigo;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public int getinventario() {
        return inventario;
    }

    public void setinventario(int inventario) {
        this.inventario = inventario;
    }
}
