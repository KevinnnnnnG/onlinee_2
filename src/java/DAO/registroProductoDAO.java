/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.ProductoBeans;
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
public class registroProductoDAO {

    ConexBD con = new ConexBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    int result;

    public int insertar(ProductoBeans p) {
        String sql = "insert into productos (nombres,costo,cantidad,descripcion, id_categoria)" + "values(?,?,?,?,?)";

        try {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);

            ps.setString(1, p.getNombre_prod());
            ps.setInt(2, p.getCosto());
            ps.setInt(3, p.getCantidad());
            ps.setString(4, p.getDescripcion());
            ps.setInt(5, p.getId_categoria());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(registroProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public List getAll() {
        String sql = "select * from productos";
        List<ProductoBeans> lista = new ArrayList<>();

        try {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProductoBeans proB = new ProductoBeans();
                proB.setId_producto(rs.getInt("id"));
                proB.setNombre_prod(rs.getString("nombres"));
                proB.setCosto(rs.getInt("costo"));
                proB.setCantidad(rs.getInt("cantidad"));
                proB.setDescripcion(rs.getString("descripcion"));
                proB.setEstado(rs.getInt("estado"));
                proB.setId_categoria(rs.getInt("id_categoria"));

                lista.add(proB);
            }
        } catch (SQLException ex) {
            Logger.getLogger(registroProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean eliminar(int id) {
        String sql = "delete from productos where id=" + id;
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

    public ProductoBeans carga(int id) {
        ProductoBeans pBeans = new ProductoBeans();
        String sql = "select * from productos where id=" + id;
        try {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                pBeans.setNombre_prod(rs.getString(2));
                pBeans.setCosto(rs.getInt(3));      
                pBeans.setCantidad(rs.getInt(4));
                pBeans.setDescripcion(rs.getString(5));
                pBeans.setId_categoria(rs.getInt(7));
            }

        } catch (SQLException ex) {
            Logger.getLogger(registroProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pBeans;
    }

    public int modificar(ProductoBeans proBeans) {
        String sql = "update productos set nombres=?, costo=?, cantidad=?, descripcion=?, id_categoria=? where id=?";

        try {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);

            ps.setString(1, proBeans.getNombre_prod());
            ps.setInt(2, proBeans.getCosto());
            ps.setInt(3, proBeans.getCantidad());
            ps.setString(4, proBeans.getDescripcion());
            ps.setInt(5, proBeans.getId_categoria());

            ps.setInt(6, proBeans.getId_producto());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(registroProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

}
