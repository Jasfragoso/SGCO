package vista;

/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import modelo.Insert;



public class GPaciente {
    
    static SimpleDateFormat ffecha = new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat bdfecha = new SimpleDateFormat("yyyy-MM-dd");

     public void agregarPaciente() {
        boolean resultado = (true);
        String pnombre = "" , papellido = "", pdireccion = "", plocalidad = "", ppais = "", pemail = "", pcelwsp = "", pfecha="";
        int pstatus = 0,fechaanio=0,fechames=01,fechadia=1;
               
        Calendar pfecnac = Calendar.getInstance();
        
        System.out.println(" Alta de Pacientes");
        
        System.out.println("Introduzca el nombre");
        Scanner entrada1 = new Scanner(System.in);
        pnombre  = entrada1.nextLine();

        
        System.out.println("Introduzca el apellido");
            Scanner entrada2 = new Scanner(System.in);
            papellido = entrada2.next();    
           
        System.out.println("Introduzca Direccion");
            Scanner entrada3 = new Scanner(System.in);
            pdireccion = entrada3.next();
        
        System.out.println("Introduzca la localidad");
            Scanner entrada4 = new Scanner(System.in);
            plocalidad = entrada4.next();
                
        System.out.println("Introduzca el Pais");
            Scanner entrada5 = new Scanner(System.in);
            ppais = entrada5.next();        

        System.out.println("Introduzca el email");
            Scanner entrada6 = new Scanner(System.in);
            pemail = entrada6.next();
        
        System.out.println("Introduzca el Cel o Wsp");
            Scanner entrada7 = new Scanner(System.in);
            pcelwsp = entrada7.next();

            
            System.out.println("Introduzca fecha de nacimiento");
            System.out.println("Introduzca el dia");
            Scanner entrada8 = new Scanner(System.in);
            fechadia= entrada8.nextInt();
            System.out.println("Introduzca el mes");
            Scanner entrada9 = new Scanner(System.in);
            fechames= entrada9.nextInt();
            System.out.println("Introduzca el anio");
            Scanner entrada10 = new Scanner(System.in);
            fechaanio= entrada10.nextInt();
            fechames = fechames-1;
            pfecnac.set(Calendar.YEAR, fechaanio);
            pfecnac.set(Calendar.MONTH,fechames);
            pfecnac.set(Calendar.DATE, fechadia);              
            pfecha = bdfecha.format(pfecnac.getTime());
            
          //     System.out.println(pfecha);            
                    
          Insert  conx4 = new Insert();
          resultado=conx4.insertarPacientes(pnombre, papellido, pdireccion, plocalidad, ppais, pemail, pcelwsp, pfecha, pstatus);
         
        if (resultado==(true)) {
         } else 
            {
               System.out.println("No se inserto, error ");            
        }
 
    }
    
}
