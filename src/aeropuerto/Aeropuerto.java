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
public class Aeropuerto {
    private String nombre;
    private String ciudad;
    private String pais;
    private Compania companias[] = new Compania[10];
    private int numCompanias;

    public Aeropuerto(String nombre, String ciudad, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.numCompanias = 0;
    }
    
    public Aeropuerto(String nombre, String ciudad, String pais, Compania c[]) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        companias = c;
        this.numCompanias = c.length;
    }
    
    public void insertarCompania(Compania compania) {
        companias[numCompanias] = compania;
        numCompanias++;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public Compania[] getCompanias() {
        return companias;
    }

    public int getNumCompanias() {
        return numCompanias;
    }
    
    public Compania getCompania(int i) {
        return companias[i];
    }
    
    public Compania getCompania(String nombre) {
        boolean encontrado = false;
        int i = 0;
        Compania c = null;
        while (!encontrado && (i<companias.length)) {
            if (nombre.equals(companias[i].getNombre())) {
                encontrado = true;
                c = companias[i];
            }
            i++;
        }
        return c;
    }
    
}
