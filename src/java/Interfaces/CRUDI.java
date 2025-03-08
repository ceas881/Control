package Interfaces;

import Modelo.Consultae;
import java.util.List;
/**
 *
 * @author AMAF
 */
public interface CRUDI {
    public List Listar();
    public Consultae list(String dni);
    public boolean Consulta(Consultae Consultae);
    public boolean Agregar(Consultae Consultae);
    public boolean AgregarS(Consultae Consultae);
}