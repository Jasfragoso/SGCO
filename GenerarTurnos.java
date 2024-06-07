/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.LocalDate;
import java.util.Date;


public class GenerarTurnos {

    static Calendar Fecha = Calendar.getInstance();
    static SimpleDateFormat ffecha = new SimpleDateFormat("dd/MM/yyyy HH:mm;ss");
    static SimpleDateFormat hfecha = new SimpleDateFormat("dd/MM/yyyy HH:mm;ss");
    static SimpleDateFormat bdfecha = new SimpleDateFormat("yyyy-MM-dd HH:mm;ss");
    static SimpleDateFormat xfecha = new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat xhora = new SimpleDateFormat("HH:MM");
    
    boolean correcto = false;
    static int selectage = -1; //opción elegida del usuario
    static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola

    // Crear Menu de Generador de Agenda void menuAgendaTurnos()
    
    public void menuAgendaTurnos() {
       
        //Mientras la opción elegida sea 0, preguntamos al usuario
     	while(selectage != 0){
			//Try catch para evitar que el programa termine si hay un error
			try{
                            System.out.println("SISTEMA DE GESTION AGENDA DE TURNOS \n");
                            System.out.println("Elige la opcion y luego presione enter:\n\n1.- Generar de Agenda" +
						"\n2.- Listar Turnos Disponibles\n" +
						"0.- Volver menu anterior");
				//Recoger una variable por consola
				selectage = Integer.parseInt(scanner.nextLine()); 
                                                                
				//Ejemplo de switch case en Java
				switch(selectage){
				case 1: 
                                        pideNumerospres();
                                        GenerarTurnos obj1=new GenerarTurnos();
                                        obj1.gturnos();
					break;
				case 2: 
					pideNumerospres();
                                        GenerarTurnos obj2=new GenerarTurnos();
                                        obj2.gListTurnosDisp();
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
    
    
    public void gturnos() {

        int tdfechadia, tdfechames, tdfechaanio, tdhora, tdminu, thhora, thminu, tfrecu;
        String Hora;  
        boolean correcto = false;      
                
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
        GenerarTurnos obj = new GenerarTurnos();
        correcto = obj.esFechaValida(tdfechadia, tdfechames, tdfechaanio);
        
        if (correcto == true){
            System.out.println("la fecha CORRECTA");
        } else
        {
            System.out.println("la fecha es incorrecta");
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

   // validar hora y min desde < a hasta
    
   
    // Asigno los valores a fecha utilizando Calendar
         
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
             
        while (!Fecha.equals(HoraH)){ 

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
        }
    
         Fecha.add(Calendar.MINUTE, tfrecu);
        }
        Connection cnc = con.cerrarConexion();
        }

  private boolean esFechaValida(int dia, int mes, int anio) {
      boolean esFechaValida = true;
    
      try {
          LocalDate.of(dia, mes, anio);
      } catch(DateTimeException e) {
          esFechaValida = false;
      }
      return correcto;
      
  }
   public void gListTurnosDisp() {
      
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
               System.out.println("No funciono el select, error "+ ex.toString());            
        }
   
   }
}
