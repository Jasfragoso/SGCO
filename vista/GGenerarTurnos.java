
package vista;

/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import java.util.Scanner;
import modelo.Insert;
import modelo.Validador;

public class GGenerarTurnos {
    public void gturnos() {

        int tdfechadia, tdfechames, tdfechaanio, tdhora, tdminu, thhora, thminu, tfrecu;
        String Hora;  
        boolean correcto = false;      
        boolean resultado = (true);
         
        System.out.println("A continuación introduzca la fecha de los turnos a generar");
        System.out.println("Introduzca el dia");
            Scanner entrada = new Scanner(System.in);
            tdfechadia = entrada.nextInt();
        
        System.out.println("Introduzca el mes");
            Scanner entrada1 = new Scanner(System.in);
            tdfechames = entrada1.nextInt();
            
        System.out.println("Introduzca el anio");
            Scanner entrada2 = new Scanner(System.in);
            tdfechaanio = entrada2.nextInt();
        
        // Valido Fecha ( dia mes anio )
        
           Validador obj = new Validador();
           correcto = obj.esFechaValida(tdfechadia, tdfechames, tdfechaanio);

        if (correcto == true){
            System.out.println("la fecha CORRECTA");
        } else
        {
            System.out.println("LA FECHA INGRESADA NO ES VALIDA");
            return;
        }
        
        System.out.println("A continuación introduzca la hora de inicio del primer turno");
        System.out.println("Introduzca la hora");
            Scanner entrada3 = new Scanner(System.in);
            tdhora = entrada3.nextInt();
            
        System.out.println("Introduzca los  minutos");
            Scanner entrada4 = new Scanner(System.in);
            tdminu = entrada4.nextInt();
            
        System.out.println("A continuación introduzca la hora final de ultimo turno");
        System.out.println("Introduzca la hora");
            Scanner entrada5 = new Scanner(System.in);
            thhora = entrada5.nextInt();
            
        System.out.println("Introduzca los  minutos");
            Scanner entrada6 = new Scanner(System.in);
            thminu = entrada6.nextInt();

        System.out.println("Introduzca la frecuencia de los turnos");
            Scanner entrada7 = new Scanner(System.in);
            tfrecu = entrada7.nextInt();
            
         // inserto en base de datos, paso los datos tomados en vista.
          
         Insert  conx4 = new Insert();
          resultado=conx4.insertarAgendaTurnos(tdfechadia, tdfechames, tdfechaanio, tdhora, tdminu, thhora, thminu, tfrecu);
                    
         if (resultado==(true)) {
         } else 
            {
               System.out.println("No se inserto, error ");            
        }
            
            
    }
    
}
