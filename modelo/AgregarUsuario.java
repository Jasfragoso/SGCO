package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

public class AgregarUsuario {
      public Boolean insertarusuarios (String unombre, String uapellido, String upass, String uuser, Integer uniaut, Integer ustatus) {
              
         Boolean ff = (true);
        
        // establezco la conexion a la base
        CConexion con = new CConexion();
        Connection cn4 = con.estableConexion();

        // inserto el usuario a la base
        try {
            PreparedStatement usu = cn4.prepareStatement("INSERT INTO usuario (nombre_usuario,apellido_usuario,nivel_autorizacion,status_usuario,pass_usuario,User) values (?,?,?,?,?,?)");
            usu.setString(1,unombre);
            usu.setString(2,uapellido);
            usu.setInt(3,uniaut);
            usu.setInt(4,ustatus);
            usu.setString(5,upass);
            usu.setString(6,uuser);
                        
            usu.executeUpdate();
//            System.out.println("Usuario " + uapellido+ ", "+unombre+" Generado");
            ff=(true);
         } catch (SQLException ex)
            {
  //             System.out.println("No se inserto, error "+ ex.toString());        
               ff=(false);
        }
 //    cierro conexion a la base   
         Connection cnc = con.cerrarConexion();
     
         return ff;
        }
}
