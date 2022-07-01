/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;

/**
 *
 * @author Victor Medina
 */
public class AeropuertoPublico extends Aeropuerto {
    private double subvencion;

    public AeropuertoPublico(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }

    public AeropuertoPublico(double subvencion, String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
        this.subvencion = subvencion;
    }
 
    public AeropuertoPublico(double subvencion, String nombre, String ciudad, String pais, Compania[] c) {
        super(nombre, ciudad, pais, c);
        this.subvencion = subvencion;
    }

    public double getSubvencion() {
        return subvencion;
    }
 
}
