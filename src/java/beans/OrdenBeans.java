/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author luis
 */
public class OrdenBeans {
    public int id_orden;
    public int id_registro;
    public int id_producto;
    public String nombre_prod;
    public int cantidad;
    public int costo;

    public OrdenBeans() {
    }

    public OrdenBeans(int id_orden, int id_registro, int id_producto, String nombre_prod, int cantidad, int costo) {
        this.id_orden = id_orden;
        this.id_registro = id_registro;
        this.id_producto = id_producto;
        this.nombre_prod = nombre_prod;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
    
}
