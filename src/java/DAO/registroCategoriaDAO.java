/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.CatBeans;
import conexionBD.ConexBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kgome
 */
public class registroCategoriaDAO {

    ConexBD con = new ConexBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    int result;

    public int insertar(CatBeans c) {
        String sql = "insert into categoria(nombres)" + "values (?)";

        try {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);

            ps.setString(1, c.getNombre_cat());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(registroCategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public List getAll() {
        String sql = "select * from categoria";
        List<CatBeans> lista = new ArrayList<>();

        try {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                CatBeans cBeans = new CatBeans();
                cBeans.setId_categoria(rs.getInt("id"));
                cBeans.setNombre_cat(rs.getString("nombres"));
                cBeans.setEstado(rs.getInt("estado"));

                lista.add(cBeans);
            }
        } catch (SQLException ex) {
            Logger.getLogger(registroCategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean eliminar(int id) {
        String sql = "delete from categoria where id=" + id;
        try {
            cnx = con.ConexionBD();
            Statement st = cnx.createStatement();
            int est = st.executeUpdate(sql);
            if (est > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(registroCategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public CatBeans carga(int id) {
        CatBeans cBeans = new CatBeans();

        String sql = "select * from categoria where id=" + id;
        try {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cBeans.setNombre_cat(rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(registroCategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cBeans;
    }

    public int modificar(CatBeans c) {
        String sql = "update categoria set nombres=? where id=?";

        try {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);

            ps.setString(1, c.getNombre_cat());

            ps.setInt(2, c.getId_categoria());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(registroCategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
}
