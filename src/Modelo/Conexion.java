/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Conexion {
    Connection con;
    
    public Connection getConnection() {
        try {
            String myDB = "jdbc:mysql://localhost:3306/sistemaventas?serverTimezone=UTC";
            con = DriverManager.getConnection(myDB, "root", "");
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
