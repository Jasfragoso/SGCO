package vista;
/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import modelo.Select;

public class LPrestadores {
    Boolean resultado=(true);
    
         public void listarPrestadores() {
                Select  conx = new Select();
                resultado=conx.selectprestador();
             
             if (resultado == (false)) {
                 System.out.println("No funciono el select, error "); 
             }
   }
}
