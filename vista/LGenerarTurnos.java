
package vista;

/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import modelo.Select;

public class LGenerarTurnos {
     public void gListTurnosDisp() {
       Boolean resultado=(true);
       Select  conx = new Select();
       resultado=conx.selectAgendaTurnos();
       if (resultado == (false)) {
                 System.out.println("No funciono el select, error "); 
             }
         }
   }

