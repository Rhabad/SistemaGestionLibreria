/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import conexion.Conexion;
import java.util.Scanner;

/**
 *
 * @author NICOLAS
 */
public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String categoria;
    private int cantidad;
    
    
    Conexion con = new Conexion();
    
    //constructor
    public Libro(){
    }
    
    
    
    
    public void agregarLibro(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Titulo: ");
        titulo = entrada.nextLine();
        System.out.print("Autor: ");
        autor = entrada.nextLine();
        System.out.print("Categoria: ");
        categoria = entrada.nextLine();
        System.out.print("Cantidad: ");
        cantidad = entrada.nextInt();
        
        con.create(titulo, autor, categoria, cantidad);
    }
    
    public void actualizarLibro(){
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("ID libro a modificar");
        id = entrada.nextInt();
        entrada.nextLine();
        
        System.out.println("=== Actualizar ===");
        System.out.print("Titulo: ");
        titulo = entrada.nextLine();
        System.out.print("Autor: ");
        autor = entrada.nextLine();
        System.out.print("Categoria: ");
        categoria = entrada.nextLine();
        System.out.print("Cantidad: ");
        cantidad = entrada.nextInt();
        
        con.update(id, titulo, autor, categoria, cantidad);
    }
}
