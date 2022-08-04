/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @email sayerpro.op7@gmail.com
 * @version 1.0
 * @author TheSrSmith
 * @date 04 Aug 2022
 */
public class Productos {
    
     /**
     * Modelo de datos que hace refencia en su estructura a una tabla en DB(Database) nombrada 'Productos'
     */
    int idProducto;
    String producto;

    public Productos() {
    }

    public Productos(int idProducto, String producto) {
        this.idProducto = idProducto;
        this.producto = producto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}
