package com.ucentral.Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductoDAO implements Producto {
    @Override
    public void ingresar_mercancia(String nombre, int cantidad) {
        Connection co;
        Statement stm;
        ResultSet rs;

        String sql = "INSERT INTO inv002_producto" +
                "(PRODUC_NOMBRE,PRODUC_CANTIDAD)" +
                "values ('" + nombre + "','" + cantidad + "')";

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }

    }

    @Override
    public void acabar_existencias(int Identificacion) {
        Connection co;
        Statement stm;
        ResultSet rs;

        String sql = "(DELETE FROM inv002_producto WHERE PRODUC_ID =' " + Identificacion + "')";

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarDatos_producto(int Identificador, String nombre, int cantidad) {
        Connection co;
        Statement stm;
        ResultSet rs;

        String sql = "UPDATE inv002_producto SET " +
                "PRODUC_NOMBRE='" + nombre + "', " +
                "PRODUC_CANTIDAD='" + cantidad + "'" + " " +
                "WHERE PRODUC_ID=" + Identificador;

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener: " + e);
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<modeloProducto> enlistar_Productos() {
        Connection co;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM inv002_producto";

        ArrayList<modeloProducto> listaProducto = new ArrayList<>();

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                modeloProducto Producto = new modeloProducto();
                Producto.setIdentificador(rs.getInt(1));
                Producto.setNombre(rs.getString(2));
                Producto.setCantidad(rs.getInt(3));
                listaProducto.add(Producto);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }

        return listaProducto;
    }
}


