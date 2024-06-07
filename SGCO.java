/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import java.util.Scanner;

public class SGCO {

    static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
    static int select = -1; //opción elegida del usuario
    
    public static void main(String[] args) {
        
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
					pideNumeros();
                                        Pacientes obj2=new Pacientes();
                                        obj2.Pacientes();
					break;
				case 3: 
					pideNumeros();
                                        Prestadores obj3=new Prestadores();
                                        obj3.menuPrestadores();
					break;
				case 4: 
					pideNumeros();
                                        GenerarTurnos obj4=new GenerarTurnos();
                                        obj4.menuAgendaTurnos();
    					break;
				case 5: 
					pideNumeros();
                                        Usuarios obj5=new Usuarios();
                                        obj5.menuUsuarios();
                                        break;
                                case 0: 
					System.out.println(" HASTA LUEGO ");
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
//		System.out.println("Introduce número 1:");
//		num1 = Integer.parseInt(scanner.nextLine());
		
//		System.out.println("Introduce número 2:");
//		num2 = Integer.parseInt(scanner.nextLine());

		//Mostrar un salto de línea en Java
		System.out.println("\n"); 
	}
    }
    
