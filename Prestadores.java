
/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;



public class Prestadores {
    static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
    static int selectpres = -1; //opción elegida del usuario
    
    public void menuPrestadores() {
        int selectpres = -1;
        
        //Mientras la opción elegida sea 0, preguntamos al usuario
     	while(selectpres != 0){
			//Try catch para evitar que el programa termine si hay un error
			try{
                            System.out.println("SISTEMA DE GESTION Prestadores \n");
                            System.out.println("Elige la opcion y luego presione enter:\n\n1.- Generar prestador" +
						"\n2.- Listar prestadores\n" +
						"0.- Volver menu anterior");
				//Recoger una variable por consola
				selectpres = Integer.parseInt(scanner.nextLine()); 
	
				//Ejemplo de switch case en Java
				switch(selectpres){
				case 1: 
                                        pideNumerospres();
                                        Prestadores obj1=new Prestadores();
                                        obj1.agregarPrestador();
					break;
				case 2: 
					pideNumerospres();
                                        Prestadores obj2=new Prestadores();
                                        obj2.listarPrestadores();
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
	public static void pideNumerospres(){
		System.out.println("\n"); 
	}
        
     public void agregarPrestador() {
         
        String pnombre = "" , pplan = "";
        int pstatus = 0;
  
        System.out.println(" Alta de Prestadores");
        System.out.println("Introduzca el nombre del prestador");
        Scanner entrada1 = new Scanner(System.in);
        pnombre  = entrada1.nextLine();

        System.out.println("Introduzca el plan del prestador");
        Scanner entrada2 = new Scanner(System.in);
        pplan = entrada2.next();
        
// establezco la conexion a la base
        CConexion con = new CConexion();
        Connection cn4 = con.estableConexion();

// inserto el prestador a la base
        try {
            PreparedStatement pres = cn4.prepareStatement("INSERT INTO prestadores (nombre_Prestador,plan_Prestador,status_Prestador) values (?,?,?)");
            pres.setString(1,pnombre);
            pres.setString(2,pplan);
            pres.setInt(3,pstatus);

            pres.executeUpdate();
            System.out.println("Prestador " + pnombre+" Plan => "+pplan+" Generado");

         } catch (SQLException ex)
            {
               System.out.println("No se inserto, error "+ ex.toString());            
        }
 //    cierro conexion a la base   
         Connection cnc = con.cerrarConexion();
     }

      public void listarPrestadores() {
             
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
               System.out.println("No funciono el select, error "+ ex.toString());            
        }
   
   }
}
