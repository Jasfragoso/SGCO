package vista;
/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import java.util.Scanner;
import modelo.Insert;


public class GPrestadores {
    public String pnombre;
    public String pplan;
    public Integer pstatus;
    private Integer sss;
    
        public void agregarPrestador() {
       
         pnombre= " " ;
         pplan= " ";
         pstatus=0;
         Boolean resultado = (true);
           
         System.out.println(" Alta de Prestadores");
         System.out.println("Introduzca el nombre del prestador");
         Scanner entrada1 = new Scanner(System.in);
         pnombre  = entrada1.nextLine();

         System.out.println("Introduzca el plan del prestador");
         Scanner entrada2 = new Scanner(System.in);
         pplan = entrada2.next();
         
         Insert  conx4 = new Insert();
         
         resultado=conx4.insertarPrestador(pnombre, pplan, pstatus);
         
         if (resultado == (true)) {
                      System.out.println("Prestador " + pnombre+" Plan => "+pplan+" Se ha generado");
          }else 
         {
                      System.out.println("No se ha generado, Error" );
          }
}
}