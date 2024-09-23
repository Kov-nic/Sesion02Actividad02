/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarUsuario {
    public static void eliminarUsuario(int id) {
        Conexion con = new Conexion();
        Connection cn = con.getConexion();
        
        String sql = "DELETE FROM usuario WHERE id = ?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario eliminado correctamente.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        eliminarUsuario(1);
    }
}

