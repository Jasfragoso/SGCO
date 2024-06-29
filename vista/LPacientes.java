package vista;
/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import modelo.Select;

public class LPacientes {
     Boolean resultado=(true);
    
         public void listarPacientes() {
                Select  conx = new Select();
                resultado=conx.selectpacientes();
             
             if (resultado == (false)) {
                 System.out.println("No funciono el select, error "); 
             }
         }
}
