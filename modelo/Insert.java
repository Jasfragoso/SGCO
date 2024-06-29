package modelo;
/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import modelo.CConexion;
import modelo.ModUsuarios;

public class Insert {
        private String xnombre;
        private String xplan;
        private Integer xstatus;
        static Calendar Fecha = Calendar.getInstance();
        static SimpleDateFormat ffecha = new SimpleDateFormat("dd/MM/yyyy HH:mm;ss");
        static SimpleDateFormat hfecha = new SimpleDateFormat("dd/MM/yyyy HH:mm;ss");
        static SimpleDateFormat bdfecha = new SimpleDateFormat("yyyy-MM-dd HH:mm;ss");
        static SimpleDateFormat xfecha = new SimpleDateFormat("dd/MM/yyyy");
        static SimpleDateFormat xhora = new SimpleDateFormat("HH:MM");
      
        
        
        public Boolean insertarPrestador (String pnombre, String pplan, Integer pstatus) {
            
        xnombre=pnombre;
        xplan=pplan;
        xstatus=pstatus;
        Boolean ff = (true);
        
                
        
        // establezco la conexion a la base
        CConexion con = new CConexion();
        Connection cn4 = con.estableConexion();

// inserto el prestador a la base
        try {
            PreparedStatement pres = cn4.prepareStatement("INSERT INTO prestadores (nombre_Prestador,plan_Prestador,status_Prestador) values (?,?,?)");
            pres.setString(1,xnombre);
            pres.setString(2,xplan);
            pres.setInt(3,xstatus);

            pres.executeUpdate();
             ff=(true);
         } catch (SQLException ex)
            {
            //   System.out.println("No se inserto, error "+ ex.toString());   
               ff=(false);
        }
 //    cierro conexion a la base   
        
         Connection cnc = con.cerrarConexion();
         return ff;
        }
        
        
          public Boolean insertarusuarios (String unombre, String uapellido, String upass, String uuser, Integer uniaut, Integer ustatus) {
                          
         Boolean ff = (true);
        
         ModUsuarios oo = new ModUsuarios();
         
        //  System.out.println("Hola mundo "+oo.getUapellido());
        
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
 
            ff=(true);
         } catch (SQLException ex)
            {
               ff=(false);
        }
 //    cierro conexion a la base   
         Connection cnc = con.cerrarConexion();
     
         return ff;
        }
          
       public Boolean insertarPacientes (String pnombre, String papellido, String pdireccion, String  plocalidad, String ppais, String pemail, String pcelwsp, String bdfecha, Integer pstatus) {
             
         Boolean ff = (true);
        
        // establezco la conexion a la base
        CConexion con = new CConexion();
        Connection cn4 = con.estableConexion();
        // inserto el paciente a la base
        try {
            PreparedStatement paci = cn4.prepareStatement("INSERT INTO pacientes (nombre_Paciente,apellido_Paciente,direccion_Paciente,localidad_Paciente,pais_Paciente,email_Paciente,cel_wsp_Paciente,fecnac_Paciente,status_Paciente) values (?,?,?,?,?,?,?,?,?)");
            paci.setString(1,pnombre);
            paci.setString(2,papellido);
            paci.setString(3,pdireccion );
            paci.setString(4,plocalidad);
            paci.setString(5,ppais);
            paci.setString(6,pemail);
            paci.setString(7,pcelwsp);
            paci.setString(8,bdfecha);
            paci.setInt(9,pstatus);
            paci.executeUpdate();
  //          System.out.println("Paciente " + papellido+", "+pnombre+" Generado");

         } catch (SQLException ex)
            {
              System.out.println("No se inserto, error "+ ex.toString());            
               ff=(false);
        }
     //    cierro conexion a la base  
         Connection cnc = con.cerrarConexion();
         return ff;
        }
        
        
       //  ****************************************************************************************************************** //

          public Boolean insertarAgendaTurnos (Integer tdfechadia, Integer tdfechames, Integer tdfechaanio, 
                  Integer  tdhora, Integer  tdminu, Integer thhora, Integer thminu, Integer tfrecu ) {
              
              Boolean ff = (true);
          
   // Asigno los valores a fecha utilizando Calendar
   // Al usar calendar.month tengo que tener presente que enero es el mes 0
   
        tdfechames=tdfechames-1;
   
        Calendar Fecha = Calendar.getInstance();
        Fecha.set(Calendar.YEAR, tdfechaanio);
        Fecha.set(Calendar.MONTH,tdfechames);
        Fecha.set(Calendar.DATE, tdfechadia);
        Fecha.set(Calendar.HOUR_OF_DAY, tdhora);
        Fecha.set(Calendar.MINUTE, tdminu);
        Fecha.set(Calendar.SECOND, 00);
       
        Calendar HoraH = Calendar.getInstance();
        HoraH.set(Calendar.YEAR, tdfechaanio);
        HoraH.set(Calendar.MONTH,tdfechames);
        HoraH.set(Calendar.DATE, tdfechadia);
        HoraH.set(Calendar.HOUR_OF_DAY, thhora);
        HoraH.set(Calendar.MINUTE, tdminu);
        HoraH.set(Calendar.SECOND, 00); 
        

// Genero los turnos desde la hora de inicio hasta la hora del ultimo turno
        CConexion con = new CConexion();
        Connection cn = con.estableConexion();

        
        while (!(bdfecha.format(Fecha.getTime())).equals((bdfecha.format(HoraH.getTime())))){
  
           try{
           
            PreparedStatement pps = cn.prepareStatement("INSERT INTO turnos (fechora_Tunos,Pacientes_id_Pacientes,tipo_Turnos,status_Turnos,Prestadores_id_Prestador,trans_prestador_Turnos) values (?,?,?,?,?,?)");
            pps.setString(1,bdfecha.format(Fecha.getTime()));
            pps.setInt(2,1);
            pps.setInt(3,0);
            pps.setInt(4,0);
            pps.setInt(5,1);
            pps.setInt(6,0);
        
//        System.out.println(pps);
                pps.executeUpdate();
                System.out.println("Turno Fecha " + ffecha.format(Fecha.getTime())+" Generado");
        
                   } catch (SQLException ex)
                    {
                        System.out.println("No se inserto, error "+ ex.toString());      
                        ff=(false);
                    }   
    
                    Fecha.add(Calendar.MINUTE, tfrecu);
                    
                    
                    }
                Connection cnc = con.cerrarConexion();
              return ff;
          }
          
      
    }
            

