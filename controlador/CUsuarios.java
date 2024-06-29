package controlador;
/**
 * @author Jose Alberto Sobredo
 * @legajo VINF09125
 */

import modelo.ModUsuarios;
import vista.GUsuarios;
import modelo.Insert;

public class CUsuarios {

ModUsuarios Musuario;
GUsuarios Gusuario;
Insert Agusuario;

    public CUsuarios(ModUsuarios Musuario, GUsuarios Gusuario, Insert Agusuario) {
        this.Musuario = Musuario;
        this.Gusuario = Gusuario;
        this.Agusuario = Agusuario;
    }
   
    }
    
    