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
public class AeropuertoPrivado extends Aeropuerto {
    private String empresas[] = new String[10];
    private int numEmpresas;

    public AeropuertoPrivado(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }

    public AeropuertoPrivado(String nombre, String ciudad, String pais, Compania[] c, String e[]) {
        super(nombre, ciudad, pais, c);
        this.empresas = e;
        numEmpresas = e.length;
    }
    
    public void insertarEmpresa(String e) {
        empresas[numEmpresas] = e;
        numEmpresas++;
    }
    
    public void insertarEmpresas(String e[]) {
        this.empresas = e;
        this.numEmpresas = e.length;
    }

    public String[] getEmpresas() {
        return empresas;
    }

    public int getNumEmpresas() {
        return numEmpresas;
    }
  
}
