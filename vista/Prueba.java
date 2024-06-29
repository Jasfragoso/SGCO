/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author Jose
 */

import vista.GUsuarios;

public class Prueba {
    private String unombre;
    private String  uapellido;
    private String upass;
    private String uuser;

    public String getUnombre() {
        return unombre;
    }

    public void setUnombre(String unombre) {
        this.unombre = unombre;
    }

    public String getUapellido() {
        return uapellido;
    }

    public void setUapellido(String uapellido) {
        this.uapellido = uapellido;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getUuser() {
        return uuser;
    }

    public void setUuser(String uuser) {
        this.uuser = uuser;
    }

    public Prueba(String unombre, String uapellido, String upass, String uuser) {
        this.unombre = unombre;
        this.uapellido = uapellido;
        this.upass = upass;
        this.uuser = uuser;
    }

 
   
}
