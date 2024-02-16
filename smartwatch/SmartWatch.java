/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.smartwatch;

/**
 *
 * @author fabri
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SmartWatch {

    public SmartWatch(String Nombre, String Marca, int Tamaño, String Precio) {
        
        this.Nombre = Nombre;
        this.Marca = Marca;
        this.Tamaño = Tamaño;
        this.Precio = Precio;
    }
    
    public SmartWatch(){
        
    }
    
    String Nombre;
    String Marca;
    int Tamaño;
    String Precio;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getTamaño() {
        return Tamaño;
    }

    public void setTamaño(int Tamaño) {
        this.Tamaño = Tamaño;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Cedula) {
        this.Precio = Cedula;
    }
    
    public void GuardarSmartWatch(){
        Connection conexionDb = Conexiondb.getConnection();
        
        //Ejecutar operaciones en la BD
        //Crear la sentencia SQL
        String sentenciaSql = "INSERT INTO smartwatch(Nombre, Marca, Tamaño, Precio) VALUES (null,?,?,?)";
        try {
            //Configurar los parámetros de la sentencia SQL
            PreparedStatement parametro = conexionDb.prepareStatement(sentenciaSql);
            parametro.setString(1, this.getNombre());
            parametro.setString(2, this.getMarca());
            parametro.setInt(3, this.getTamaño());
            parametro.setString(4, this.getPrecio());

            //Ejecutar la sentencia SQL
            parametro.execute();
            conexionDb.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
     public void ModificarSmartWatch(){
        Connection conexionDb = Conexiondb.getConnection();
        
        //Ejecutar operaciones en la BD
        //Crear la sentencia SQL
        String sentenciaSql = "UPDATE personas SET Nombre=?, Marca=?, Tamaño=?, WHERE Precio=?";
        try {
            //Configurar los parámetros de la sentencia SQL
            PreparedStatement parametro = conexionDb.prepareStatement(sentenciaSql);
            parametro.setString(1, this.getNombre());
            parametro.setString(2, this.getMarca());
            parametro.setInt(3, this.getTamaño());
            parametro.setString(4, this.getPrecio());

            //Ejecutar la sentencia SQL
            parametro.execute();
            conexionDb.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
     
    
    public ArrayList<SmartWatch> ObtenerSmartWatch(ArrayList<SmartWatch> SmartWatch){
        Connection conexionDb = Conexiondb.getConnection();
        ResultSet rsSmartwach;
        
        var Smartwach = new ArrayList<SmartWatch>();
        //Ejecutar operaciones en la BD
        //Crear la sentencia SQL
        String sentenciaSql = "SELECT * FROM Smartwach";
        try {
            //Configurar los parámetros de la sentencia SQL
            PreparedStatement parametro = conexionDb.prepareStatement(sentenciaSql);
            
            //Ejecutar la sentencia SQL
            rsSmartwach=parametro.executeQuery();           
            
            while(rsSmartwach.next()){              
                Smartwach.add(new SmartWatch(rsSmartwach.getString("Nombre"),rsSmartwach.getString("Marca"),rsSmartwach.getInt("Tamaño"),rsSmartwach.getString("Precio")));

            }
            
            conexionDb.close();
            return SmartWatch;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
        
    }

    void EliminarSmartwach() {
        Connection conexionDb = Conexiondb.getConnection();
        
        //Ejecutar operaciones en la BD
        //Crear la sentencia SQL
        String sentenciaSql = "DELETE FROM Smartwach WHERE Precio=?";
        try {
            //Configurar los parámetros de la sentencia SQL
            PreparedStatement parametro = conexionDb.prepareStatement(sentenciaSql);

            //Ejecutar la sentencia SQL
            parametro.execute();
            conexionDb.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}