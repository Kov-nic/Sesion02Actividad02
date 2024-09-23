/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultarUsuario {
    public static void consultarUsuarios() {
        Conexion con = new Conexion();
        Connection cn = con.getConexion();
        
        String sql = "SELECT * FROM usuario";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": " + rs.getString("nombre") + " " + rs.getString("apellido") + " - " + rs.getString("email") + " - " + rs.getInt("edad"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error al consultar usuarios: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        consultarUsuarios();
    }
}
