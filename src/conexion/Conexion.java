/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

/**
 *
 * @author NICOLAS
 */

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

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
            System.out.println("error");
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
        try {
            conectar();
            
            String sql = "select * from libros;";
            
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while (rs.next()) {      
                /*aca tuve un error al colocar los numeros en los parentesis
                empece del 1 al 4, siendo que son 5 campos, siendo el primero
                un auto increment y primary. Coloque el que era el segundo
                campo como primero y me daba error*/
                String titulo = rs.getString(2);
                String autor = rs.getString(3);
                String categoria = rs.getString(4);
                int cantidad = rs.getInt(5);
                
                System.out.println(titulo+" "+autor+"  "+categoria+"  "+cantidad);
            }
        } catch (Exception e) {
            System.out.println("Hubo un error");
        }
        
        
        
    }
    
    //actualizar un registro
    public void update(int id, String titulo, String autor, String categoria, int cantidad){
        try {
            conectar();
            
            String sql = "UPDATE libros SET titulo = ?, autor = ?, categoria = ?, cantidad = ? WHERE id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(sql);
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, autor);
            preparedStatement.setString(3, categoria);
            preparedStatement.setInt(4, cantidad);
            preparedStatement.setInt(5, id);

            int filasActualizadas = preparedStatement.executeUpdate();
            System.out.println(filasActualizadas + " registro(s) actualizado(s)");

            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Hubo un error");
            System.out.println(e);
        }
        
        
    }
    
    //borrar un registro
    public void delete(int id){
        conectar();
        try {
            String sql = "DELETE from libros where id = ?;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            
            int res = ps.executeUpdate();
            
            if (res > 0 ) {
                System.out.println("Eliminado");
            } else{
                System.out.println("Error al Eliminar");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
    
    
}
