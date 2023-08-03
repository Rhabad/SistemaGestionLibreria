/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

/**
 *
 * @author NICOLAS
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexion {
    //atributos
    private String bd = "biblioteca";
    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "prueba";
    private String pass = "123";
    private String driver = "com.mysql.cj.jdbc.Driver";
    Connection cn;
    
    //constructor
    public Conexion(){
    }
    
    public void conectar(){
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url+bd, user, pass);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //crear nuevos registrs en la bd
    public void create(String titulo, String autor, String categoria, int cantidad){
        try {
            conectar();
            
            String sql = "insert into libros (titulo, autor, categoria, cantidad)\n" +
                            "VALUES\n" +
                            "	(\""+titulo+"\", \""+autor+"\", \""+categoria+"\", \""+cantidad+"\")";
            Statement stm = cn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Agregado perrin");
            
        } catch (Exception e) {
            System.out.println("Hubo un error");
        }
    }
    
    //mostrar la bd
    public void read(){
        
    }
    
    //actualizar un registro
    public void update(){
    }
    
    //borrar un registro
    public void delete(){
    }
    
    
}
