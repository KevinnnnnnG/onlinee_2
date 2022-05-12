/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.OrdenBeans;
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
public class registroOrdenesDAO {

    ConexBD con = new ConexBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    int result;

    public int insertar(OrdenBeans o) {
        String sql = "insert into ordenes (id_registro,id_producto,nombre_prod,cantidad)" + "values(?,?,?,?)";

        try {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);

            ps.setInt(1, o.getId_registro());
            ps.setInt(2, o.getId_producto());
            ps.setString(3, o.getNombre_prod());
            ps.setInt(4, o.getCantidad());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(registroOrdenesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public List getAll(int id) {
        String sql = "select * from ordenes where id_registro=" + id;
        List<OrdenBeans> lista = new ArrayList<>();

        try {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                OrdenBeans ordB = new OrdenBeans();
                ordB.setId_orden(rs.getInt("id_orden"));
                ordB.setId_registro(rs.getInt("id_registro"));
                ordB.setId_producto(rs.getInt("id_producto"));
                ordB.setNombre_prod(rs.getString("nombre_prod"));
                ordB.setCantidad(rs.getInt("cantidad"));

                lista.add(ordB);
            }
        } catch (SQLException ex) {
            Logger.getLogger(registroOrdenesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean eliminar(int id) {
        String sql = "delete from ordenes where id_orden=" + id;
        try {
            cnx = con.ConexionBD();
            Statement st = cnx.createStatement();
            int estado = st.executeUpdate(sql);
            if (estado > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(registroProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public OrdenBeans carga(int id) {
        OrdenBeans pBeans = new OrdenBeans();
        String sql = "select * from ordenes where id_orden=" + id;
        try {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                pBeans.setCantidad(rs.getInt(5));
                pBeans.setId_orden(rs.getInt(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(registroOrdenesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pBeans;
    }

    public int modificar(OrdenBeans proBeans) {
        String sql = "update ordenes set cantidad=? where id_orden =?";

        try {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);

            ps.setInt(1, proBeans.getCantidad());
            ps.setInt(2, proBeans.getId_orden());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(registroOrdenesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
}
