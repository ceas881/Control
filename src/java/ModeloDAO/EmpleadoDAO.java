package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Empleado;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author AMAF
 */
public class EmpleadoDAO implements CRUD{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Empleado empleado = new Empleado();

    @Override
    public List Listar() {
        ArrayList<Empleado> list = new ArrayList<>();
        String sql = "select * from empleados";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setid_empleado(rs.getInt("id_empleado"));
                empleado.setnombre(rs.getString("nombre"));
                empleado.setapellido(rs.getString("apellido"));
                empleado.setdni(rs.getString("dni"));
                empleado.settelefono(rs.getString("telefono"));
                empleado.setEmail(rs.getString("Email"));
                empleado.setid_departamento(rs.getInt("id_departamento"));
                list.add(empleado);
            }//fin listar
        } catch (SQLException e) {
            System.out.println("Error al Listar" + e);
        }
        return list;
    }

    @Override
    public Empleado list(int id) {
        String sql = "select * from empleados where id_empleado=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleado.setid_empleado(rs.getInt("id_empleado"));
                empleado.setnombre(rs.getString("nombre"));
                empleado.setapellido(rs.getString("apellido"));
                empleado.setdni(rs.getString("dni"));
                empleado.settelefono(rs.getString("telefono"));
                empleado.setEmail(rs.getString("Email"));
                empleado.setid_departamento(rs.getInt("id_departamento"));
                System.out.println("Modificando Empleado: " + empleado.getnombre());
            }
        } catch (SQLException e) {
            System.out.println("Error al listar (EmpleadoDAO) en metodo list" + e);
        }
        return empleado;
    }

    @Override
    public boolean Add(Empleado empleado) {

        String sql = "insert into empleados (nombre, apellido, dni, telefono, Email, id_departamento) VALUES ('" + empleado.getnombre() + "','" + empleado.getapellido() + "','" + empleado.getdni() + "','" + empleado.gettelefono() + "','" + empleado.getEmail() + "','" + empleado.getid_departamento() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al Agregar(EmpleadoDAO): " + e);
        }
        return false;
    }

    @Override
    public boolean Edit(Empleado empleado) {
        String sql = "update empleados set nombre='" + empleado.getnombre() + "', apellido='" + empleado.getapellido() + "', dni='" + empleado.getdni() + "', telefono='" + empleado.gettelefono() + "', Email='" + empleado.getEmail() + "', id_departamento='" + empleado.getid_departamento() + "' where id_empleado=" + empleado.getid_empleado();

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Registro Modificando Exitosamente" + empleado.getnombre());
        } catch (SQLException e) {
            System.out.println("Error al Actualizar (Edit) (empleadoDAO): " + e);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from empleados where id_empleado=" + id;
        try{
            con = cn.getConnection();
            ps =con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error al Eliminar (EmpleadoDAO): " + e);
        }
        return false;
    }
}
