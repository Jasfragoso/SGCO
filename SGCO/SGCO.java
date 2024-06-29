package SGCO;

/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

//import SGCO.Pacientes;

import vista.MPacientes;
import java.util.Scanner;
import vista.MUsuarios;
import vista.Mprestadores;
import vista.MGenerarTurnos;

public class SGCO {

    static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
    static int select = -1; //opción elegida del usuario
    
    public static void main(String[] args) {
                limpiarConsola();
        //Mientras la opción elegida sea 0, preguntamos al usuario
     	while(select != 0){
			//Try catch para evitar que el programa termine si hay un error
			try{
                                                        
                            System.out.println("SISTEMA DE GESTION - CONSULTORIO OFTALMOLOGICO \n");
                            System.out.println("Elige la opcion y luego presione enter:\n\n1.- Asignar Turnos a Pacientes" +
						"\n2.- Pacientes\n" +
						"3.- Prestadores\n" +
						"4.- Generar Agenda de Turnos\n" +
                                                                                                            "5.- Usuarios del Sistema\n" +
						"0.- Salir");
				//Recoger una variable por consola
				select = Integer.parseInt(scanner.nextLine()); 
	
				//Ejemplo de switch case en Java
				switch(select){
				case 1: 
					
                                                                                           pideNumeros();
					System.out.println(" Modulo En Desarrollo ");
                                                                                            
					break;
				case 2: 
					limpiarConsola(); 
                                                                                           pideNumeros();
                                                                                          MPacientes obj2=new MPacientes();
                                                                                          obj2.menuPacientes();
                                                                                          limpiarConsola();
					break;
				case 3: 
                                                                                         limpiarConsola(); 
					pideNumeros();
                                                                                          Mprestadores obj3=new Mprestadores();
                                                                                          obj3.menuPrestadores();
                                                                                          limpiarConsola();
					break;
				case 4: 
                                                                                          limpiarConsola(); 
					pideNumeros();
                                                                                           MGenerarTurnos obj4=new MGenerarTurnos();
                                                                                           obj4.menuAgendaTurnos();
                                                                                           limpiarConsola();
    					break;
				case 5: 
                                                                                         limpiarConsola(); 
					pideNumeros();
                                                                                          MUsuarios obj5=new MUsuarios();
                                                                                         obj5.menuUsuarios();
                                                                                         limpiarConsola();
                                                                                         break;
                                                                        case 0: 
                                                                                         limpiarConsola(); 
					System.out.println(" HASTA LA PROXIMA, BYE BYE ");
                                        
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
	public static void pideNumeros(){

		//Mostrar un salto de línea en Java
		System.out.println("\n"); 
	}
                 public   static void limpiarConsola() {  
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();  
                }  
   
 }
    
