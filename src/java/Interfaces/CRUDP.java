package Interfaces;

import Modelo.Producto;
import java.util.List;

/**
 *
 * @author AMAF
 */
public interface CRUDP {
    public List Listar();
    public Producto list(int codigo);
    public boolean Addp(Producto producto);
    public boolean Editp(Producto producto);
    public boolean Eliminar(int codigo);
}
