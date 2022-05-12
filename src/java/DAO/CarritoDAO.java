package DAO;

import beans.ProductoBeans;
import beans.ProductoBeanss;
import conexionBD.ConexBD;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

public class CarritoDAO {
    ConexBD con = new ConexBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    int result;
    
    public ProductoBeanss lId(int id){
        String sql = "Select * from productos where id="+id;
        ProductoBeanss p = new ProductoBeanss();
        try{
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setCosto(rs.getFloat(3));
                p.setCantidad(rs.getInt(4));
                p.setDescripcion(rs.getString(5));
                p.setImagen(rs.getBinaryStream(6));
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    public List lcar(){
        List<ProductoBeanss>productos=new ArrayList();
        String sql = "Select * from productos";
        try{
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ProductoBeanss p = new ProductoBeanss();
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setCosto(rs.getFloat(3));
                p.setCantidad(rs.getInt(4));
                p.setDescripcion(rs.getString(5));
                p.setImagen(rs.getBinaryStream(6));
                productos.add(p);
            }
        } catch (Exception e) {
        }
        return productos;
    }
    
    public void limg(int id, HttpServletResponse response){
        String sql = "Select * from productos where id"+id;
        InputStream inputStream=null;
        OutputStream outputStream=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        try{
            outputStream=response.getOutputStream();
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                inputStream=rs.getBinaryStream("imagen");
            }
            bufferedInputStream=new BufferedInputStream(inputStream);
            bufferedOutputStream=new BufferedOutputStream(outputStream);
            int i=0;
            while((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }
        } catch (Exception e) {
        }
    }
}
