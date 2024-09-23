/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarUsuario {
    public static void actualizarUsuario(int id, String nuevoNombre, String nuevoApellido, int nuevaEdad, String nuevoEmail) {
        Conexion con = new Conexion();
        Connection cn = con.getConexion();
        
      
        String sql = "UPDATE usuario SET nombre = ?, apellido = ?, edad = ?, email = ? WHERE id = ?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nuevoNombre);
            pst.setString(2, nuevoApellido);
            pst.setInt(3, nuevaEdad);
            pst.setString(4, nuevoEmail); 
            pst.setInt(5, id);
            
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("No se encontró el usuario con el ID especificado.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        
        actualizarUsuario(2, "Andres", "Gomez", 28, "andres.GR@gmail.com");
    }
}

