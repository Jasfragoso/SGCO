package modelo;

/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class CConexion {
    
    Connection conectar = null;
    String usuario = "Conector";
    String password = "Locomia09";
    String bd = "SGCO";
    String ip = "localhost";
    String port = "3306";
    String cadena = "jdbc:mysql://"+ip+":"+port+"/"+bd;
    
    public Connection estableConexion() {
        try {
             conectar = DriverManager.getConnection(cadena, usuario, password);
        } catch (Exception e) {
            System.out.println("No se conecto a la base, error "+ e.toString());
        }
        return conectar;
    }
    
    public Connection cerrarConexion() {
        try {
            conectar.close();
        } catch (Exception e) {
            System.out.println("No se cerro la conexion a la base, error "+ e.toString());
        }
        return conectar;
    }
    
    
}

