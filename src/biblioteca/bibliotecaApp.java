/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

/**
 *
 * @author NICOLAS
 */
import conexion.Conexion;
import java.util.Scanner;


public class bibliotecaApp {
    public static void main (String[] args){
        Libro lib = new Libro();
        Conexion con = new Conexion();
        Scanner entrada = new Scanner(System.in);
        int opc;
        
        /*aqui me encontre con un problema, en la 3 y 4.
        este problema tenia que ver al momento de poner la id del libro a actualizar o borrar
        colocaba 4, pero algo salia mal... no fue sino que al mirar en mysql, que el id 4 no existia
        pero si existia el 1 2 3 7 8 9... al parecer mientras probaba el 4, se borraron y
        yo pense que al borrar el id se bajaria el que estaba encima... pues no*/
        do {            
            menu();
            opc = entrada.nextInt();
            entrada.nextLine();
            
            switch (opc) {
                case 1:
                    lib.agregarLibro();
                    break;
                case 2:
                    con.read();
                    break;
                case 3:
                    lib.actualizarLibro();
                    break;
                case 4:
                    System.out.println("ID libro a Eliminar: ");
                    int id = entrada.nextInt();
                    con.delete(id);
                    break;
                case 0:
                    System.out.println("Noh vemoh");
                    break;
                default:
                    throw new AssertionError();
            }
            
        } while (opc != 0);
        
        
        
        
    }
    
    private static void menu(){
        System.out.println("====== Biblioteca =====");
        System.out.println("1. Agregar Libro");
        System.out.println("2. Mostrar los Libros");
        System.out.println("3. Actualizar Libro");
        System.out.println("4. Eliminar Libro");
        System.out.println("0. noh vimo");
    }
}
