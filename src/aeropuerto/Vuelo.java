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
public class Vuelo {
    private String identificador;
    private String ciudadOrigen;
    private String ciudadDestino;
    private double precio;
    private int maxPasajeros;
    private int actualPasajeros;
    private Pasajero pasajeros[];

    public Vuelo(String identificador, String ciudadOrigen, String ciudadDestino, double precio, int maxPasajeros) {
        this.identificador = identificador;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
        this.maxPasajeros = maxPasajeros;
        this.actualPasajeros = 0;//manual
        this.pasajeros = new Pasajero[maxPasajeros];//manual
    }
    
    public void insertarPasajero(Pasajero pasajero) {
        pasajeros[actualPasajeros] = pasajero;
        actualPasajeros++;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public double getPrecio() {
        return precio;
    }

    public int getMaxPasajeros() {
        return maxPasajeros;
    }

    public int getActualPasajeros() {
        return actualPasajeros;
    }
    
    public Pasajero getPasajero(int i) {
        return pasajeros[i];
    }
    
    public Pasajero getPasajero(String pasaporte) {
        boolean encontrado = false;
        int i = 0;
        Pasajero pas = null;
        while ((!encontrado) && (i<pasajeros.length)) {
            if (pasaporte == pasajeros[i].getPasaporte()) {//pasaporte.equals(pasajeros[i].getPasaporte()
                encontrado = true;
                pas = pasajeros[i];
            }
            i++;
        }
        return pas;
    }
    
}
