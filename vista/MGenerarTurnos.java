package vista;

/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MGenerarTurnos {
    static int selectage = -1; //opción elegida del usuario
    static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola

    // Crear Menu de Generador de Agenda void menuAgendaTurnos()
    
    public void menuAgendaTurnos() {
        limpiarConsola();
        int selectage = -1;
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
                                                                                limpiarConsola(); 
                                                                                pideNumerospres();
                                                                                GGenerarTurnos obj1=new GGenerarTurnos();
                                                                                obj1.gturnos();
                                                                                 limpiarPantalla();
                                                                                break;
				case 2: 
                                                                                limpiarConsola(); 
                                                                                pideNumerospres();
                                                                                LGenerarTurnos obj2=new LGenerarTurnos();
                                                                                obj2.gListTurnosDisp();
                                                                                limpiarPantalla();
                                                                                break;
                                                                        case 0: 
                                                                                limpiarConsola();
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
             public   static void limpiarConsola() {  
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();  
                }  
         
         public static void limpiarPantalla(){

          try {
            System.out.println("Presione enter para continuar...");
            new java.util.Scanner(System.in).nextLine();
            String sistemaOperativo = System.getProperty("os.name");
            ArrayList<String> comando= new ArrayList<>();
            if(sistemaOperativo.contains("Windows")){        
                comando.add("cmd");
                comando.add("/C");
                comando.add("cls");
           } else {
                comando.add("clear");
            } 
            
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process iniciarProceso = pb.inheritIO().start();
            iniciarProceso.waitFor();
            
        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla"+e.getMessage());
        }
        }
}
