package com.ucentral.Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO implements Usuario {

    ArrayList<modeloUsuario> usuarios = new ArrayList<>();

    @Override
    public void validaridarnvl(modeloUsuario nvl) throws ClassNotFoundException, SQLException {

        int nivel = nvl.getNvl();
        Conexion.getConexion();
        Statement stm = null;
        Connection con = null;
        String sql = "select USUARI_NVL from cat001_usuario";

    }

    @Override
    public boolean validar_usuario(String nombre, String contraseña) {
        ArrayList<modeloUsuario> Comprobar = new ArrayList<modeloUsuario>();
        boolean estado = false;
        try {
            Comprobar = enlistar_usuarios();
            int i = 0;
            while (i < Comprobar.size()) {
                if (Comprobar.get(i).getNombre().equals(nombre) && Comprobar.get(i).getContraseña().equals(contraseña)) {
                    estado = true;
                    break;
                } else {
                    i++;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estado;
    }

    //
    @Override
    public int validar_usuarionvl(String NUsuario) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT USUARI_NVL " +
                "FROM cat001_usuario " +
                "WHERE USUARI_NOMBRE= '" + NUsuario + "'";

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            int nvl = 0;
            while (rs.next()) {
                nvl = rs.getInt(1);
            }
            stm.close();
            rs.close();
            co.close();
            return nvl;
        } catch (SQLException e) {
            System.out.println("Error: no funcion" + e);
            e.printStackTrace();
        }
        return 0;
    }

    ///
    @Override
    public void registrar_usuario(String nombre, String Nidentifiacion, int TpIdentificacion, String contraseña) {
        Connection co;
        Statement stm;
        ResultSet rs;

        String sql = "INSERT INTO cat001_usuario" +
                "(USUARI_NOMBRE,USUARI_NIDENTIFIACION,USUARI_TPIDENTIFICACION,USUARI_CONTRASEÑA)" +
                "values ('" + nombre + "','" + Nidentifiacion + "','" + TpIdentificacion + "','" + contraseña + "')";

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
    public void finalizar_contrato(String Nidentifiacion) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "(DELETE FROM cat001_usuario WHERE USUARI_NIDENTIFIACION = " + Nidentifiacion + ")";

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
    public void cambiarDatos_usuario(String nombre, String Nidentifiacion, int TpIdentificacion, String contraseña) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "UPDATE CLIENTE SET " +
                "USUARI_NOMBRE='" + nombre + "', " +
                "USUARI_NIDENTIFIACION='" + Nidentifiacion + "', " +
                "USUARI_TPIDENTIFICACION='" + TpIdentificacion + "', " +
                "USUARI_CONTRASEÑA='" + contraseña + "'" + " " +
                "WHERE ID=" + Nidentifiacion;

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
    public ArrayList<modeloUsuario> enlistar_usuarios() throws ClassNotFoundException, SQLException {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM cat001_usuario";

        ArrayList<modeloUsuario> listausuario = new ArrayList<modeloUsuario>();

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                modeloUsuario user = new modeloUsuario();
                user.setNombre(rs.getString(2));
                user.setContraseña(rs.getString(6));
                user.setCedula(rs.getString(3));
                user.setNvl(rs.getInt(5));
                listausuario.add(user);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }

        return listausuario;
    }
}
