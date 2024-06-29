package vista;
/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Mprestadores {
    static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
    static int selectpres = -1; //opción elegida del usuario
    
    public void menuPrestadores() {
        limpiarConsola();
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
                                                                                limpiarConsola(); 
                                                                                 pideNumerospres();
                                                                                GPrestadores obj1=new GPrestadores();
                                                                                obj1.agregarPrestador();
                                                                                limpiarPantalla();
					break;
				case 2: 
                                                                                           limpiarConsola(); 
					pideNumerospres();
                                                                                           LPrestadores obj2=new LPrestadores();
                                                                                           obj2.listarPrestadores();
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
