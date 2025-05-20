package ModeloDAO;

import java.sql.*;
import java.time.LocalDateTime;
import Config.Conexion;
import Modelo.Producto;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AMAF
 */
public class RegistroDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Modelo.Consultae consultae = new Modelo.Consultae();

// Método para registrar la hora de ingreso de un empleado
    public boolean registrarHoraIngreso(String dni) throws SQLException {
        // SQL para insertar el registro de hora de ingreso
        String sql = "SELECT DATE_FORMAT(NOW(), '%d/%m/%Y') AS fecha, DATE_FORMAT(NOW(), '%H:%i:%s') AS hora_ingreso";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                consultae.setfecha(rs.getString("fecha"));
                consultae.sethora_ingreso(rs.getString("hora_ingreso"));

                // Imprime los datos para verificar que los estás obteniendo
                System.out.println("Fecha: " + consultae.getfecha());
                System.out.println("Hora: " + consultae.gethora_ingreso());

                return true;
            } else {
                System.out.println("No se obtuvieron resultados de la consulta.");
            }
        } catch (SQLException e) {
            System.out.println("Error al Consultar (ConsultaDAO) en método Consulta: " + e.getMessage());
        }
        return false;
    }
    public List<Producto> obtenerProductos() {
    List<Producto> lista = new ArrayList<>();
    String sql = "SELECT * FROM registro_producto";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Producto p = new Producto();
            p.setcodigo(rs.getInt("codigo"));
            p.setnombre(rs.getString("nombre"));
            p.setinventario(rs.getInt("inventario"));
            lista.add(p);
        }
    } catch (Exception e) {
        System.out.println("Error obteniendo productos: " + e);
    }
    return lista;
}
    public void actualizarHoraSalida(String dni){
    String sql = "UPDATE registro_ingreso_salida SET hora_salida = CURTIME() WHERE dni = ? AND hora_salida IS NULL ORDER BY id_registro DESC LIMIT 1";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, dni);
        ps.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error al registrar hora de salida: " + e);
    }
}

    /*public void registrarSalida(String dni, int producto_id, int cantidad) {
    // Consultas SQL
    String sqlInsert = "INSERT INTO historial_movimientos (dni, fecha, hora_salida, producto_id, cantidad) "
            + "VALUES (?, CURDATE(), CURTIME(), ?, ?)";
    String sqlRegistro = "INSERT INTO registro_ingreso_salida (dni, fecha, hora_salida) VALUES (?, CURDATE(), CURTIME())";
    String sqlUpdate = "UPDATE registro_producto SET inventario = inventario - 5 WHERE codigo = 1;";

    try {
        con = cn.getConnection();
        con.setAutoCommit(false); // Iniciar transacción

        // Insertar en historial_movimientos
        ps = con.prepareStatement(sqlInsert);
        ps.setString(1, dni);
        ps.setInt(2, producto_id);
        ps.setInt(3, cantidad);
        ps.executeUpdate();
        
        int filasHistorial = ps.executeUpdate();
        System.out.println("Filas insertadas en historial_movimientos: " + filasHistorial);

        // Insertar en registro_ingreso_salida
        ps = con.prepareStatement(sqlRegistro);
        ps.setString(1, dni);
        ps.setInt(2, producto_id);
        ps.setInt(3, cantidad);
        int filasRegistro = ps.executeUpdate();
        System.out.println("Filas insertadas en registro_ingreso_salida: " + filasRegistro);

        // Actualizar inventario
        ps = con.prepareStatement(sqlUpdate);
        ps.setInt(1, cantidad);
        ps.setInt(2, producto_id);
        ps.executeUpdate();

        int filasInventario = ps.executeUpdate();
        System.out.println("Filas actualizadas en inventario: " + filasInventario);
        con.commit(); // Confirmar transacción
        
        
        System.out.println("Salida registrada y inventario actualizado.");
    } catch (SQLException e) {
        try {
            con.rollback(); // Revertir cambios en caso de error
            System.out.println("Error al registrar salida. Se hizo rollback.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            if (con != null) con.setAutoCommit(true); // Restaurar el autoCommit
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}*/
    public void actualizarInventario(int codigo, int cantidad) {
    String sql = "UPDATE registro_producto SET inventario = inventario + ? WHERE codigo = ?";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, cantidad);
        ps.setInt(2, codigo);
        ps.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error actualizando inventario: " + e);
    }
}


    public List<Producto> listarProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT codigo, nombre FROM registro_producto";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setcodigo(rs.getInt("codigo")); // Asegurar que el nombre del setter es correcto
                prod.setnombre(rs.getString("nombre"));
                lista.add(prod);
                System.out.println("Producto encontrado: " + prod.getcodigo() + " - " + prod.getnombre());
            }
        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error cerrando conexión: " + e);
            }
        }
        return lista;
    }

}
