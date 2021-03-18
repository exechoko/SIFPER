package com.example.sifper.Model;

public class User {
    private String nombre;
    private String password;
    private String lp;
    private String correo;
    private String IsStaff;

    public User() {
    }

    public User(String nombre, String password, String lp) {
        this.nombre = nombre;
        this.password = password;
        this.lp = lp;
        IsStaff = "false";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLp() {
        return lp;
    }

    public void setLp(String lp) {
        this.lp = lp;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(String isStaff) {
        IsStaff = isStaff;
    }
}
