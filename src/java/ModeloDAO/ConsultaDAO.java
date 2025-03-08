package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Interfaces.CRUDI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.Consultae;
import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AMAF
 */
public class ConsultaDAO implements CRUDI {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Consultae consultae = new Consultae();

    @Override
    public List<Consultae> Listar() {
        List<Consultae> list = new ArrayList<>();
        String sql = "SELECT dni, fecha, hora_ingreso, hora_salida FROM registro_ingreso_salida order by fecha desc";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Consultae consultae = new Consultae();
                consultae.setDni(rs.getString("dni"));
                consultae.setfecha(rs.getString("fecha"));
                consultae.sethora_ingreso(rs.getString("hora_ingreso"));
                consultae.sethora_salida(rs.getString("hora_salida"));

                // ✅ Agregar a la lista
                list.add(consultae);

                // Verificar en consola que los datos se están cargando
                System.out.println("Consultando Empleado: " + consultae.getDni());
            }
        } catch (SQLException e) {
            System.out.println("Error al listar (ConsultaeDAO) en método Listar: " + e);
        }
        return list;
    }

    @Override
    public Consultae list(String DNI) {
        String sql = "select nombre, apellido, dni from empleados where dni= ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, DNI);
            rs = ps.executeQuery();
            while (rs.next()) {
                consultae.setDni(rs.getString("dni"));
                consultae.setNombre(rs.getString("nombre"));
                consultae.setApellido(rs.getString("apellido"));
                System.out.println("Consultando Empleado: " + consultae.getDni());
            }
        } catch (SQLException e) {
            System.out.println("Error al listar (ConsultaDAO) en metodo list" + e);
        }
        return consultae;
    }

    public void Agregar(String dni) {
        // Consulta SQL para insertar la fecha y hora actuales
        String sql = "INSERT INTO registro_ingreso_salida (dni, fecha, hora_ingreso) VALUES (?, CURDATE(), CURTIME())";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);  // Asigna el DNI al parámetro
            ps.executeUpdate();
            System.out.println("Registro insertado para DNI: " + dni);
        } catch (SQLException e) {
            System.out.println("Error al agregar (ConsultaDAO) en método Agregar: " + e);
        }
    }

    public void AgregarS(String dni) {
        // Consulta SQL para insertar la fecha y hora actuales
        String sql = "INSERT INTO registro_ingreso_salida (dni, fecha, hora_salida) VALUES (?, CURDATE(), CURTIME())";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);  // Asigna el DNI al parámetro
            ps.executeUpdate();
            System.out.println("Registro insertado para DNI: " + dni);
        } catch (SQLException e) {
            System.out.println("Error al agregar (ConsultaDAO) en método Agregar: " + e);
        }
    }

    @Override
    public boolean Consulta(Consultae Consultae) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Agregar(Consultae Consultae) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean AgregarS(Consultae Consultae) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}