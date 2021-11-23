package com.ucentral.Modelo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Usuario {
    void validaridarnvl(modeloUsuario nvl) throws ClassNotFoundException, SQLException;

    boolean validar_usuario(String nombre, String contraseña);

    int validar_usuarionvl(String NUsuario);

    void registrar_usuario(String nombre, String Nidentifiacion, int TpIdentificacion, String contraseña);

    void finalizar_contrato(String Nidentifiacion);

    void cambiarDatos_usuario(String nombre, String Nidentifiacion, int TpIdentificacion, String contraseña);

    ArrayList<modeloUsuario> enlistar_usuarios() throws ClassNotFoundException, SQLException;
}
