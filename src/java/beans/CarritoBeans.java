/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author kgome
 */
public class CarritoBeans {
    private int item;
    private int id;
    private String nombres;
    private String descripcion;
    private int cantidad;
    private float precio;
    private float Subtotal;

    public CarritoBeans() {
    }

    public CarritoBeans(int item, int id, String nombres, String descripcion, int cantidad, float precio, float Subtotal) {
        this.item = item;
        this.id = id;
        this.nombres = nombres;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.Subtotal = Subtotal;
    }
    
     public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(float Subtotal) {
        this.Subtotal = Subtotal;
    }
    
}
