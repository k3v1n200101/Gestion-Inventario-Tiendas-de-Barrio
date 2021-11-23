package com.ucentral.Modelo;

import java.util.ArrayList;

public interface Producto {
    void ingresar_mercancia(String nombre, int cantidad);

    void acabar_existencias(int identificacion);

    void cambiarDatos_producto(int Identificador, String nombre, int cantidad);

    ArrayList<modeloProducto> enlistar_Productos();
}
