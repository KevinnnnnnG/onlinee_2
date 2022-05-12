/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author SENA
 */
public class RegistroBeans {
    private int id_registro;
    private String nombres;
    private String contacto;
    private String correo;
    private String password;
    private String rol;
    
    public RegistroBeans() {
    }

    public RegistroBeans(int id_registro, String nombres, String contacto, String correo, String password, String rol) {
        this.id_registro = id_registro;
        this.nombres = nombres;
        this.contacto = contacto;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
