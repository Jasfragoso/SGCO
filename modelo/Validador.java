package modelo;

/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import java.time.DateTimeException;
import java.time.LocalDate;

public class Validador {
     
     public boolean esFechaValida(int xdia, int xmes, int xanio) {
       boolean esFechaValida= true;  

      try {
          LocalDate.of(xanio, xmes, xdia);
      } catch(DateTimeException e) {
          esFechaValida = false;
      }
      return esFechaValida;
  }
    
}
