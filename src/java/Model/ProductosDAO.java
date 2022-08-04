/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Configuration.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @email sayerpro.op7@gmail.com
 * @version 1.0
 * @author TheSrSmith
 * @date 04 Aug 2022
 */
public class ProductosDAO {
    
    Conection cn = new Conection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    /**
     * Metodo que consume una tabla en base de datos para traer información de una tabla en especifica
     * @return List
     */
    public List listarProductos() {
        String sql = "select * from Productos";
        List<Productos> productos = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Productos product = new Productos();
                product.setIdProducto(rs.getInt(1));
                product.setProducto(rs.getString(2));
                
                productos.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Model.FacturaDAO.listarFacturas() - Error al listar las facturas: " + e);
        }
        
        return productos;
    }
}
