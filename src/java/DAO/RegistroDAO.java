/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.RegistroBeans;
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
 * @author SENA
 */
public class RegistroDAO {
    ConexBD con = new ConexBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    int result;
    
    public int insertar (RegistroBeans r)
    {
        String sql = "insert into registro (nombres,contacto,correo,password,role)" + "values(?,?,?,?,?)";
        
        try
        {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);
            
            ps.setString(1, r.getNombres());
            ps.setString(2, r.getContacto());
            ps.setString(3, r.getCorreo());
            ps.setString(4, r.getPassword());
            ps.setString(5, r.getRol());
            
            ps.executeUpdate();
        }
        
        catch (Exception e)
        {
            
        }
        
        return result;
    }
    
     public RegistroBeans validar(String usr, String pass)
    {
        RegistroBeans miregis = new RegistroBeans();
        String sql = "Select * from registro where correo=? and password=?";
        
        try {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);
            ps.setString(1, usr);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                miregis.setId_registro(rs.getInt("id"));
                miregis.setNombres(rs.getString("nombres"));
                miregis.setContacto(rs.getString("contacto"));
                miregis.setCorreo(rs.getString("correo"));
                miregis.setPassword(rs.getString("password"));
                miregis.setRol(rs.getString("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return miregis;
    }
     
     public List getAll()
     {
         String sql = "select * from registro";
         List<RegistroBeans>lista = new ArrayList<>();
         
         try
         {
             cnx = con.ConexionBD();
             ps = cnx.prepareStatement(sql);
             rs = ps.executeQuery();
             
             while(rs.next())
             {
                 RegistroBeans regB = new RegistroBeans();
                 regB.setId_registro(rs.getInt("id"));
                 regB.setNombres(rs.getString("nombres"));
                 regB.setContacto(rs.getString("contacto"));
                 regB.setCorreo(rs.getString("correo"));
                 regB.setPassword(rs.getString("password"));
                 regB.setRol(rs.getString("role"));
                 
                 lista.add(regB);
             }
         } catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return lista;
     }
     
     public boolean eliminar(int id)
     {
         String sql = "delete from registro where id="+id;
         try
         {
             cnx = con.ConexionBD();
             Statement st = cnx.createStatement();
             int estado = st.executeUpdate(sql);
             if (estado > 0) {
                 return true;
             }
             
         } catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return false;
         
     }
     
     public RegistroBeans carga(int id)
     {
         RegistroBeans rBeans = new RegistroBeans();
         String sql = "select * from registro where id=" + id;
         try
         {
             cnx = con.ConexionBD();
             ps = cnx.prepareStatement(sql);
             rs = ps.executeQuery();
             
             while(rs.next())
             {
                 rBeans.setId_registro(rs.getInt(1));
                 rBeans.setNombres(rs.getString(2));
                 rBeans.setContacto(rs.getString(3));
                 rBeans.setCorreo(rs.getString(4));
                 rBeans.setPassword(rs.getString(5));
                 rBeans.setRol(rs.getString(6));
             }
                 
         } catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rBeans;
     }
     
      public int modificar (RegistroBeans rBeans)
    {
        String sql = "update registro set nombres=?, contacto=?, correo=?, password=? where id=?";
        
        try
        {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);
            
            ps.setString(1, rBeans.getNombres());
            ps.setString(2, rBeans.getContacto());
            ps.setString(3, rBeans.getCorreo());
            ps.setString(4, rBeans.getPassword());
            
            ps.setInt(5, rBeans.getId_registro());
            
            ps.executeUpdate();
        }
        
        catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
      
      public RegistroBeans getOne(int id)
      {
          RegistroBeans rBeans = new RegistroBeans();
          
          String sql = "select * from registro where id="+id;
          try
          {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                 RegistroBeans regB = new RegistroBeans();
                 regB.setId_registro(rs.getInt("id"));
                 regB.setNombres(rs.getString("nombres"));
                 regB.setContacto(rs.getString("contacto"));
                 regB.setCorreo(rs.getString("correo"));
                 regB.setPassword(rs.getString("password"));
                 regB.setRol(rs.getString("role"));
            }
            
          }
          
          catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          return rBeans;
      }
}
