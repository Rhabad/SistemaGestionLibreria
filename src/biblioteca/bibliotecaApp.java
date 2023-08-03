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
        Scanner entrada = new Scanner(System.in);
        Conexion con = new Conexion();
        
        con.conectar();
        
        System.out.println("Titulo Autor Categoria Cantidad");
        String titulo = entrada.nextLine();
        String autor = entrada.nextLine();
        String categoria = entrada.nextLine();
        int cantidad = entrada.nextInt();
        
        con.create(titulo, autor, categoria, cantidad);
    }
}
