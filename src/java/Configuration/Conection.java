/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @email sayerpro.op7@gmail.com
 * @version 1.0
 * @author TheSrSmith
 * @date 04 Aug 2022
 */
public class Conection  {
    Connection conexion;
    String url = "jdbc:sqlserver://localhost:1433;databaseName=Facturacion;";
    String user = "sa";
    String password = "123";
    
    public Connection Conexion() {
        try {
            /*Esta linea funciona correctamente el IDE la resalta por que no encuentra la ruta especifica*/
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            System.out.println("Configuration.Conection.Conexion() - Error en la conexion a la base de datos: " + e);
        }
        return conexion;
    }
}
