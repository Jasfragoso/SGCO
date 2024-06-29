package modelo;
/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Select {
    static SimpleDateFormat xfecha = new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat xhora = new SimpleDateFormat("HH:MM");
    
    public Boolean selectprestador (){
        
        Boolean ff=(true);
        
         // establezco la conexion a la base
        CConexion con = new CConexion();
        Connection cn4 = con.estableConexion();
        
        try {
        // Listo los registros de tabla prestadores            
        
        Statement st = cn4.createStatement();
        ResultSet results = st.executeQuery("Select nombre_prestador,plan_prestador,status_Prestador from prestadores");
                
            System.out.println("  LISTA DE PRESTADORES \n");
            System.out.println("  ID  "+" PRESTADOR "+"  PLAN "+ " ESTADO ");
            System.out.println("--------------------------------------------");        
        while (results.next()){
            String prestador = results.getString("nombre_prestador");
            String plan = results.getString("plan_Prestador");
            Integer nivel = results.getInt("status_Prestador");
            String nivela = "";
               
          if(nivel == 0){
                nivela = "Habilitado";
            } else {
               nivela = "Deshabilitado";
             }

          System.out.println(results.getRow()+" "+prestador+", "+plan+"    "+nivela);
        }
         
        } catch (SQLException ex)
            {
            ff=(false);
        }
        Connection cnc = con.cerrarConexion();
   
        return ff;
        
    }
     public Boolean selectusuarios (){
      
         Boolean ff =(true);
      
           
       // establezco la conexion a la base
        CConexion con = new CConexion();
        Connection cn4 = con.estableConexion();
        
        
        try {
        // Listo los registros de tabla usuarios            
        
        Statement st = cn4.createStatement();
        ResultSet results = st.executeQuery("Select nombre_usuario,apellido_usuario,nivel_autorizacion,status_usuario,pass_usuario,User from usuario");
                
            System.out.println("  LISTA DE USUARIOS \n");
            System.out.println("  ID  "+" Apellido "+"  Nombre  "+" Usuario "+ " Autorizacion ");
            System.out.println("-----------------------------");        
        while (results.next()){
            String apellido = results.getString("apellido_usuario");
            String name = results.getString("nombre_usuario");
            String user = results.getString("User");
            Integer nivel = results.getInt("nivel_autorizacion");
            String nivela = "";
               
          if(nivel == 0){
                nivela = "Admin";
            } else {
               nivela = "Operador";
             }

          System.out.println(results.getRow()+" "+apellido+", "+name+"  "+user+"  "+nivela);
        }
         
        } catch (SQLException ex)
            {
            //   System.out.println("No funciono el select, error "+ ex.toString());            
               ff=(false);
        }
        Connection cnc = con.cerrarConexion();
        return ff;
   
     }
    
     //////
     
     public Boolean selectpacientes() {
      
       Boolean ff=(true);
       // establezco la conexion a la base
        CConexion con = new CConexion();
        Connection cn4 = con.estableConexion();
        
        
        try {
            
        // Listo los registros de tabla pacientes
        
        Statement st = cn4.createStatement();
        ResultSet results = st.executeQuery("Select nombre_Paciente,apellido_Paciente,email_Paciente,cel_wsp_Paciente,status_Paciente from pacientes");
              
            System.out.println("  LISTA DE PACIENTES \n");
            System.out.println("  ID  "+" Apellido "+"  Nombre  "+"    Email    "+ " Celular - WSP " + " Estado ");
            System.out.println("--------------------------------------------------------------------------------------");        
        while (results.next()){
            String apellido = results.getString("apellido_Paciente");
            String name = results.getString("nombre_Paciente");
            String email = results.getString("email_Paciente");
            String celu = results.getString("cel_wsp_Paciente");
            Integer nivel  = results.getInt("status_Paciente");
            String nivela = "";
               
          if(nivel == 0){
                nivela = "Habilitado";
            } else {
               nivela = "De Baja";
             }

          System.out.println(results.getRow()+" "+apellido+", "+name+"  "+email+"  "+celu+"  "+nivela);
        }
         
        } catch (SQLException ex)
            {
        //       System.out.println("No funciono el select, error "+ ex.toString()); 
               ff=(false);
               
        }
   Connection cnc = con.cerrarConexion();
   return ff;
   
    } 
     
     ////*********************************************************************************************
     public Boolean selectAgendaTurnos() {
         
         Boolean ff=(true);
         
            // establezco la conexion a la base
        CConexion con = new CConexion();
        Connection cn4 = con.estableConexion();
        
        
        try {
        // Listo los registros de tabla turnos

        Statement st = cn4.createStatement();
        ResultSet results = st.executeQuery("Select fechora_Tunos from turnos where status_Turnos=0 order by fechora_Tunos");
        
         System.out.println("  LISTA DE TURNOS DISPONIBLES \n");
         System.out.println("  ID  "+" FECHA HORA ");
         System.out.println("-----------------------------");        
         while (results.next()){
                String fecha = (xfecha.format(results.getDate("fechora_Tunos")));
                String hora = (xhora.format(results.getTime("fechora_Tunos")));

                System.out.println(results.getRow()+" "+fecha+" "+hora);
         }
         
        } catch (SQLException ex)
            {
              // System.out.println("No funciono el select, error "+ ex.toString());         
               ff=(false);
        }
    Connection cnc = con.cerrarConexion();
    return ff;
     }
}
