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
public class Compania {
    private String nombre;
    private Vuelo vuelos[] = new Vuelo[10];
    private int numVuelos = 0;

    public Compania(String nombre) {
        this.nombre = nombre;
    }
    
    public Compania(String nombre, Vuelo v[]) {
        this.nombre = nombre;
        vuelos = v;
        numVuelos = v.length;
    }
    
    public void insertarVuelo(Vuelo vuelo) {
        vuelos[numVuelos] = vuelo;
        numVuelos++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumVuelos() {
        return numVuelos;
    }
    
    public Vuelo getVuelo(int i) {
        return vuelos[i];
    }
    
    public Vuelo getVuelo(String id) {
        boolean encontrado = false;
        int i = 0;
        Vuelo v = null;
        while (!encontrado && (i<vuelos.length)) {
            if (id.equals(vuelos[i].getIdentificador())) {
                encontrado = true;
                v = vuelos[i];
            }
            i++;
        }
        return v;
    }
    
}
