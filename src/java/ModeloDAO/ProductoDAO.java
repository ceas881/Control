package ModeloDAO;

import Config.ConexionBD; //maneja todos los controladores 
import Interfaces.CRUDP;
import Modelo.Producto;
import java.sql.Connection;//biblioteca conexion
import java.sql.PreparedStatement;// para manejar registros de las consultas sql
import java.sql.ResultSet;// resultado de los registros
import java.sql.SQLException;// errores 
import java.util.ArrayList;// arreglos para menejar lista de datos
import java.util.List;// lista

/**
 *
 * @author AMAF
 */
public class ProductoDAO implements CRUDP{
    ConexionBD conexion = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Producto producto = new Producto();

    public List listar() {
        String sql = "select * from registro_producto";
        List<Producto> lista = new ArrayList<>();

        try {
            con = conexion.ConectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Producto producto = new Producto();
                producto.setcodigo(rs.getInt(1));
                producto.setnombre(rs.getString(2));
                producto.setinventario(rs.getInt(3));
                lista.add(producto);
            }

        } catch (SQLException e) {
            System.out.println("error al listar: " + e);
        }
        return lista;

    } // fin clase listar

    @Override
    public Producto list(int codigo) {
        String sql = "select * from registro_producto where codigo= " + codigo;
        try {
            con = conexion.ConectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto.setcodigo(rs.getInt("codigo"));
                producto.setnombre(rs.getString("nombre"));
                producto.setinventario(rs.getInt("inventario"));
                System.out.println("Modificando Producto: " + producto.getnombre());
            }
        } catch (SQLException e) {
            System.out.println("Error al listar (ProductoDAO) en metodo list" + e);
        }
        return producto;
    }

    //Metodo para agregar
    @Override
    public boolean Addp(Producto producto) {
        String sql = "INSERT INTO registro_producto(nombre, inventario) VALUES (?,?)";
        try {
            con = conexion.ConectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getnombre());
            ps.setInt(2, producto.getinventario());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error en el metodo Agregar clase ProductoDAO: " + e);
        }
        return false;
    }
    //Metodo actualizar
    /*public void editar(Producto producto){
        String sql = "update registro_producto set nombre = ?, inventario = ? where codigo = ?";
        try{
            con = conexion.ConectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getnombre());
            ps.setInt(2, producto.getinventario());
            ps.setInt(3, producto.getcodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al Actualizar ProductoDAO: " + e);
        }
    }*/
    
    @Override
    public List Listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Editp(Producto producto) {
        String sql = "update registro_producto set nombre = ?, inventario = ? where codigo = ?";
        try{
            con = conexion.ConectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getnombre());
            ps.setInt(2, producto.getinventario());
            ps.setInt(3, producto.getcodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al Actualizar ProductoDAO: " + e);
        }
        return false;
    }

    @Override
    public boolean Eliminar(int codigo) {
        String sql = "delete from registro_producto where codigo =" + codigo;
        try{
            con = conexion.ConectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();            
        }catch(SQLException e){
            System.err.println("Error al realizar el borrado(EliminarDAO)" + e);
        }
        return false;
    }// Fin del metodo Borrar
}
