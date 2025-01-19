package Interfaces;

import Modelo.Empleado;
import java.util.List;

/**
 *
 * @author AMAF
 */
public interface CRUD {
    public List Listar();
    public Empleado list(int id_empleado);
    public boolean Add(Empleado empleado);
    public boolean Edit(Empleado empleado);
    public boolean eliminar(int id_empleado);
}
