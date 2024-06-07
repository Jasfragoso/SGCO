/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Date;
import java.sql.Statement;
import java.sql.ResultSet;


public class Pacientes {
    
    static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
    static int selectpaci = -1; //opción elegida del usuario
    static SimpleDateFormat ffecha = new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat bdfecha = new SimpleDateFormat("yyyy-MM-dd");
   
        
    public void Pacientes() {
        
        //Mientras la opción elegida sea 0, preguntamos al usuario
     	while(selectpaci != 0){
			//Try catch para evitar que el programa termine si hay un error
			try{
                            System.out.println("SISTEMA DE GESTION PACIENTES \n");
                            System.out.println("Elige la opcion y luego presione enter:\n\n1.- Generar paciente" +
						"\n2.- Listar pacientes\n" +
						"0.- Volver menu anterior");
				//Recoger una variable por consola
				selectpaci = Integer.parseInt(scanner.nextLine()); 
	
				//Ejemplo de switch case en Java
				switch(selectpaci){
				case 1: 
                                        pideNumerospaci();
                                        Pacientes obj1=new Pacientes();
                                        obj1.agregarPaciente();
					break;
				case 2: 
					pideNumerospaci();
                                        Pacientes obj2=new Pacientes();
                                        obj2.listarPacientes();
					break;
                             case 0: 
					break;
				default:
					System.out.println(" soy opcion ");break;
				}
				
				System.out.println("\n"); //Mostrar un salto de línea en Java
				
			}catch(Exception e){
				System.out.println("Uoop! !!! Tengo un Error !!!");
			}
		}

	}
           //Método para recoger variables por consola
	public static void pideNumerospaci(){
		System.out.println("\n"); 
	}

    
    public void agregarPaciente() {
    
        String pnombre = "" , papellido = "", pdireccion = "", plocalidad = "", ppais = "", pemail = "", pcelwsp = "";
        int pstatus = 0;
        Calendar pfecnac = Calendar.getInstance();
        pfecnac.set(Calendar.YEAR, 1965);
        pfecnac.set(Calendar.MONTH, 8);
        pfecnac.set(Calendar.DATE, 11);
        
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

     
 //       System.out.println("Introduzca la Fecha de Nacimiento");
 //       Scanner entrada8 = new Scanner(System.in);
 //      pfecnac = entrada8.next(pfecnac);
               


// establezco la conexio a la base
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
            paci.setString(8,bdfecha.format(pfecnac.getTime()));
            paci.setInt(9,pstatus);
            paci.executeUpdate();
            System.out.println("Paciente " + papellido+", "+pnombre+" Generado");

         } catch (SQLException ex)
            {
               System.out.println("No se inserto, error "+ ex.toString());            
        }
     //    cierro conexion a la base  
         Connection cnc = con.cerrarConexion();
    }
    
    public void listarPacientes() {
      
       
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
               System.out.println("No funciono el select, error "+ ex.toString());            
        }
   
   } 
}
