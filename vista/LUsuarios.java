package vista;

/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import modelo.Select;

public class LUsuarios {
      Boolean resultado=(true);
    
         public void listarUsuarios() {
                Select  conx = new Select();
                resultado=conx.selectusuarios();
             
             if (resultado == (false)) {
                 System.out.println("No funciono el select, error "); 
             }
}
}
