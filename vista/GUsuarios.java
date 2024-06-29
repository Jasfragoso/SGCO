package vista;

/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import java.util.Scanner;
import modelo.Insert;
import java.util.ArrayList;
import modelo.ModUsuarios;
import controlador.CUsuarios;
import modelo.Insert;



public class GUsuarios {
    
    public void agregarUsuario() {
        
        Boolean resultado = (true);
        String unombre , uapellido,  upass , uuser;
        int uniaut , ustatus;
                     
       ModUsuarios xuser= new ModUsuarios();
       
       unombre = xuser.getUnombre();
       uapellido =xuser.getUapellido();
       upass= xuser.getUpass();
       uuser= xuser.getUuser();
       uniaut=xuser.getUniaut();
       ustatus=xuser.getUstatus();
              
       
        //creo un arraylist para nivel de autorizacion de usuario
        
        ArrayList<String> univelautorizacion;
        univelautorizacion= new ArrayList<>();
        
        univelautorizacion.add("0 = Admin");
        univelautorizacion.add("1 = Operador");
        
        System.out.println(" Alta de Usuarios");
        System.out.println("Introduzca el nombre del usuario");
        Scanner entrada1 = new Scanner(System.in);
        unombre  = entrada1.nextLine();
         xuser.setUnombre(unombre);
        
        System.out.println("Introduzca el apellido del usuario");
        Scanner entrada2 = new Scanner(System.in);
        uapellido = entrada2.next();
        xuser.setUapellido(uapellido);
        
        for (int i = 0; i < univelautorizacion.size(); i++) {
             System.out.println("Niveles de autorizacion");
             System.out.println("==================");
             System.out.println(" - "+univelautorizacion.get(i));
        }
        
        System.out.println("Introduzca nivel autorizacion");
        Scanner entrada3 = new Scanner(System.in);
        uniaut= entrada3.nextInt();
        xuser.setUniaut(uniaut);
        
        System.out.println("Introduzca user");
        Scanner entrada4 = new Scanner(System.in);
        uuser = entrada4.next();
        uuser = uuser.toUpperCase();
        xuser.setUuser(uuser);
        
        System.out.println("Introduzca password");
        Scanner entrada5 = new Scanner(System.in);
        upass = entrada5.next();  
        xuser.setUpass(upass);
        
       // System.out.println("nombre estoy aca antes del insert " + xuser.getUnombre());
          
         Insert cnn4 = new Insert();
         
         resultado= cnn4.insertarusuarios(xuser.getUnombre(), xuser.getUapellido(), xuser.getUpass(),  xuser.getUuser(), xuser.getUniaut(), xuser.getUstatus());
         
                 
          if (resultado==(true))  {
             System.out.println("El usuario " + xuser.getUapellido()+ ", "+xuser.getUnombre()+" ha sido Generado");
         } else {
            System.out.println("Usuario " + xuser.getUapellido()+ ", "+xuser.getUnombre()+"  No ha sido Generado");
          }
            
          
}
 
}


