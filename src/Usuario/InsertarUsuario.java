/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarUsuario {
    public static void insertarUsuario(String nombre, String apellido, String email, int edad) {
        Conexion con = new Conexion();
        Connection cn = con.getConexion();
        
        String sql = "INSERT INTO usuario (nombre, apellido, email, edad) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, email);
            pst.setInt(4, edad);
            
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario insertado correctamente.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        insertarUsuario("Nathalia", "Hernandez", "nathalia.1903@gmail.com", 28);
    }
}

