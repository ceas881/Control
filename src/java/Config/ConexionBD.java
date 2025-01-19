package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AMAF
 */
public class ConexionBD {

    Connection con;
    String bd = "control_acceso";
    String url = "jdbc:mysql://localhost:3306/" + bd + "?useUnicode=true&use"
            // si es un servidor distinto en donde va localhost va la ip
            + "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
            + "serverTimezone=UTC";
    String usuario = "root";
    String pwd = "Gohengy1";
    String driver = "com.mysql.cj.jdbc.Driver";

    public Connection ConectarBaseDeDatos() {//metodo para conectar a la bd
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, usuario, pwd);
            System.out.println("Conexion con la base de datos: " + bd + " Exitosa");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se tiene conexion con la base de datos: " + bd);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
        conexion.ConectarBaseDeDatos();
    }
}
