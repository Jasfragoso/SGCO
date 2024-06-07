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



public class Usuarios {
    
    static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
    static int selectusu = -1; //opción elegida del usuario
    
    public void menuUsuarios() {
        
        //Mientras la opción elegida sea 0, preguntamos al usuario
     	while(selectusu != 0){
			//Try catch para evitar que el programa termine si hay un error
			try{
                            System.out.println("SISTEMA DE GESTION USUARIOS \n");
                            System.out.println("Elige la opcion y luego presione enter:\n\n1.- Generar usuario" +
						"\n2.- Listar usuarios\n" +
						"0.- Volver menu anterior");
				//Recoger una variable por consola
				selectusu = Integer.parseInt(scanner.nextLine()); 
	
				//Ejemplo de switch case en Java
				switch(selectusu){
				case 1: 
                                        pideNumerosusu();
                                        Usuarios obj1=new Usuarios();
                                        obj1.agregarUsuario();
					break;
				case 2: 
					pideNumerosusu();
                                        Usuarios obj2=new Usuarios();
                                        obj2.listarUsuarios();
					break;
                             case 0: 
					System.out.println("Adios!");
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
	public static void pideNumerosusu(){
		System.out.println("\n"); 
	}
              
     public void agregarUsuario() {
         
        String unombre = "" , uapellido = "", upass = "", uuser = "";
        int uniaut = 0, ustatus = 0 ;
        
  
        System.out.println(" Alta de Usuarios");
        System.out.println("Introduzca el nombre del usuario");
        Scanner entrada1 = new Scanner(System.in);
        unombre  = entrada1.nextLine();

        System.out.println("Introduzca el apellido del usuario");
        Scanner entrada2 = new Scanner(System.in);
        uapellido = entrada2.next();
        
        System.out.println("Introduzca nivel autorizacion");
        Scanner entrada3 = new Scanner(System.in);
        uniaut= entrada3.nextInt();
        
        System.out.println("Introduzca user");
        Scanner entrada4 = new Scanner(System.in);
        uuser = entrada4.next();
                
        System.out.println("Introduzca password");
        Scanner entrada5 = new Scanner(System.in);
        upass = entrada5.next();  
        
// establezco la conexion a la base
        CConexion con = new CConexion();
        Connection cn4 = con.estableConexion();

// inserto el prestador a la base
        try {
            PreparedStatement usu = cn4.prepareStatement("INSERT INTO usuario (nombre_usuario,apellido_usuario,nivel_autorizacion,status_usuario,pass_usuario,User) values (?,?,?,?,?,?)");
            usu.setString(1,unombre);
            usu.setString(2,uapellido);
            usu.setInt(3,uniaut);
            usu.setInt(4,ustatus);
            usu.setString(5,upass);
            usu.setString(6,uuser);
                        
            usu.executeUpdate();
            System.out.println("Usuario " + uapellido+ ", "+unombre+" Generado");

         } catch (SQLException ex)
            {
               System.out.println("No se inserto, error "+ ex.toString());            
        }
 //    cierro conexion a la base   
         Connection cnc = con.cerrarConexion();
     }
   public void listarUsuarios() {
      
       
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
                nivela = "Operador";
            } else {
               nivela = "Admin";
             }

          System.out.println(results.getRow()+" "+apellido+", "+name+"  "+user+"  "+nivela);
        }
         
        } catch (SQLException ex)
            {
               System.out.println("No funciono el select, error "+ ex.toString());            
        }
   
   }
}

