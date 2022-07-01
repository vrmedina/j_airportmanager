/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;

import java.util.Scanner;

/**
 *
 * @author Victor Medina
 */
public class Main {
    static Scanner in = new Scanner(System.in);
    final static int num = 2; //Numero de aeropuertos
    static Aeropuerto aeropuertos[] = new Aeropuerto[num];
    
    public static void main(String[] args) {
        
        //Insertar los datos de los aeropuertos
        insertarDatosAeropuerto(aeropuertos);
        
        menu();
    }
    
    public static void insertarDatosAeropuerto(Aeropuerto aero[]) {
        aero[0] = new AeropuertoPublico(8000000, "El Dorado", "Bogota", "Colombia");
        aero[0].insertarCompania(new Compania("Avianca"));
        aero[0].insertarCompania(new Compania("LATAM"));
        aero[0].getCompania("LATAM").insertarVuelo(new Vuelo("BC1", "Bogota", "Cartagena", 200, 150));
        aero[0].getCompania("LATAM").insertarVuelo(new Vuelo("BC2", "Bogota", "Miami", 400, 140));
        aero[0].getCompania("Avianca").insertarVuelo(new Vuelo("AC1", "Bogota", "Londres", 1000, 120));
        aero[0].getCompania("LATAM").getVuelo("BC1").insertarPasajero(new Pasajero("Victor", "32KAF", "Colombiano"));
        aero[0].getCompania("LATAM").getVuelo("BC1").insertarPasajero(new Pasajero("Maria", "45ABD", "Colombiano"));
        aero[0].getCompania("LATAM").getVuelo("BC2").insertarPasajero(new Pasajero("Raul", "66NBV", "Colombiano"));
        
        aero[1] = new AeropuertoPrivado("Central Ciudad Real", "Ciudad Real", "España");
        aero[1].insertarCompania(new Compania("AirEuropa"));
        String empresas[] = {"AirSpain", "EspVuela"};
        ((AeropuertoPrivado)aero[1]).insertarEmpresas(empresas);
        aero[1].getCompania("AirEuropa").insertarVuelo(new Vuelo("AE025", "Madrid", "Buenos Aires", 500, 150));
        aero[1].getCompania("AirEuropa").insertarVuelo(new Vuelo("AE026", "Madrid", "Buenos Aires", 510, 140));
        aero[1].getCompania("AirEuropa").getVuelo("AE025").insertarPasajero(new Pasajero("Andres", "3443FA", "Español"));
        aero[1].getCompania("AirEuropa").getVuelo("AE026").insertarPasajero(new Pasajero("Benjamin", "567VV", "Peruano"));
    }
    
    public static void menu() {
        String nombreAeropuerto;
        String nombreCompania;
        String origen, destino;
        int op;
        Aeropuerto aeropuerto;
        Compania compania;
        
        do {
            System.out.println("*** SOFTWARE AEROPORTUARIO ***");
            System.out.println("*** MENU ***");
            System.out.println("1. Ver Aeropuertos gestionados(Publicos o Privados)");
            System.out.println("2. Ver Empresas(Privado) o Subvencion(Publico)");
            System.out.println("3. Lista de compañias de un aeropuerto");
            System.out.println("4. Lista de vuelos por compañia");
            System.out.println("5. Lista de posibles vuelos de origen a destino");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");
            op = in.nextInt();
            
            switch (op) {
            case 1: //Ver Aeropuertos gestionados(Publicos o Privados)
                System.out.println("");
                datosAeropuertos(aeropuertos);
                break;
            case 2://Ver empresas(Privado) o subvencion(Publico)
                System.out.println("");
                mostrarPatrocinio(aeropuertos);
                break;
            case 3://Lista de compañias de un aeropuerto
                System.out.print("\nDigite el nombre del aeropuerto: ");
                in.nextLine();
                nombreAeropuerto = in.nextLine();
                aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                if (aeropuerto == null) {
                    System.out.println("El aeropuerto no existe!");
                    System.out.println("");
                }else {
                    mostrarCompanias(aeropuerto);
                }
                break;
            case 4://Lista de vuelos por compañia
                System.out.print("\nDigite el nombre del aeropuerto: ");
                in.nextLine();
                nombreAeropuerto = in.nextLine();
                aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                if (aeropuerto == null) {
                    System.out.println("El aeropuerto no existe!");
                    System.out.println("");
                }else {
                    System.out.print("\nDigite el nombre de la compañia: ");
                    nombreCompania = in.nextLine();
                    compania = aeropuerto.getCompania(nombreCompania);
                    mostrarVuelos(compania);
                }
                break;
            case 5://Lista de posibles vuelos de origen a destino
                in.nextLine();
                System.out.print("\nDigite una ciudad de origen: ");
                origen = in.nextLine();
                System.out.print("\nDigite una ciudad de origen: ");
                destino = in.nextLine();
                mostrarVueloOrigenDestino(origen, destino, aeropuertos);
                break;
            case 6:
                System.out.println("Hasta luego!");
                break;
            default:
                System.out.println("Lo sentimos, la opcion digitada no existe");
            } 
            
        } while (op != 6);
       
    }
    
    public static void datosAeropuertos(Aeropuerto aeropuertos[]) {
        for (int i=0;i<aeropuertos.length;i++) {
            if (aeropuertos[i] instanceof AeropuertoPrivado) {
                System.out.println("Aeropuerto Privado");
                System.out.println("Nombre: " + aeropuertos[i].getNombre());
                System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
                System.out.println("Pais: " + aeropuertos[i].getPais());
            } else {
                System.out.println("Aeropuerto Publico");
                System.out.println("Nombre: " + aeropuertos[i].getNombre());
                System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
                System.out.println("Pais: " + aeropuertos[i].getPais()); 
            }
            System.out.println("");
        }
    }  
    
    public static void mostrarPatrocinio(Aeropuerto aeropuertos[]) {
        String empresas[];
        for (int i = 0; i < aeropuertos.length; i++) {
            if (aeropuertos[i] instanceof AeropuertoPrivado) {
                System.out.println("Aeropuerto Privado: "+aeropuertos[i].getNombre());
                empresas = ((AeropuertoPrivado)aeropuertos[i]).getEmpresas();
                System.out.println("Empresas: ");
                for (int j = 0; j < empresas.length; j++) {
                    System.out.println(empresas[j]);
                }
            }else {
                System.out.println("Aeropuerto Publico: "+aeropuertos[i].getNombre());
                System.out.println("Subvencion: "+ ((AeropuertoPublico)aeropuertos[i]).getSubvencion()); 
            }
            System.out.println("");
        }
    }
    
    public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto aeropuertos[]) {    
        boolean encontrado = false;
        int i = 0;
        Aeropuerto aero = null;
        while ((!encontrado) && (i<aeropuertos.length)) {
            if (nombre.equals(aeropuertos[i].getNombre())) {
                encontrado = true;
                aero = aeropuertos[i];
            }
            i++;
        }
        return aero;
    }
    
    public static void mostrarCompanias(Aeropuerto aeropuerto) {
        System.out.println("\nLas compañias del aeropuerto "+aeropuerto.getNombre()+" son: ");
        for (int i = 0; i < aeropuerto.getNumCompanias(); i++) {
            System.out.println(aeropuerto.getCompania(i).getNombre());
        }
        System.out.println("");
    }
    
    public static void mostrarVuelos(Compania compania) {
        Vuelo vuelo;
        for (int i = 0; i < compania.getNumVuelos(); i++) {
            vuelo = compania.getVuelo(i);
            System.out.println("Identificador: "+vuelo.getIdentificador());
            System.out.println("Ciudad origen: "+vuelo.getCiudadOrigen());
            System.out.println("Ciudad destino: "+vuelo.getCiudadDestino());
            System.out.println("Precio: $"+vuelo.getPrecio());
            System.out.println("");
        }
    }
    
    public static Vuelo[] buscarVuelosOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]) {
        Vuelo vuelo;
        Vuelo vuelos[];
        int cont = 0;
        for (int i = 0; i < aeropuertos.length; i++) {
            for (int j = 0; j < aeropuertos[i].getNumCompanias(); j++) {
                for (int k = 0; k < aeropuertos[i].getCompania(j).getNumVuelos(); k++) {
                    vuelo = aeropuertos[i].getCompania(j).getVuelo(k);
                    if ((origen.equals(vuelo.getCiudadOrigen())) && ((destino.equals(vuelo.getCiudadDestino())))) {
                        cont++;
                    }
                }
            }
        }
        vuelos = new Vuelo[cont];
        int q = 0;
        
        for (int i = 0; i < aeropuertos.length; i++) {
            for (int j = 0; j < aeropuertos[i].getNumCompanias(); j++) {
                for (int k = 0; k < aeropuertos[i].getCompania(j).getNumVuelos(); k++) {
                    vuelo = aeropuertos[i].getCompania(j).getVuelo(k);
                    if ((origen.equals(vuelo.getCiudadOrigen())) && ((destino.equals(vuelo.getCiudadDestino())))) {
                        vuelos[q] = vuelo;
                        q++;
                    }
                }
            }
        }
        return vuelos;
    }
    
    public static void mostrarVueloOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]) {
        Vuelo vuelos[];
        vuelos = buscarVuelosOrigenDestino(origen, destino, aeropuertos);
        if (vuelos.length == 0) {
            System.out.println("No existen vuelos para las ciudades escogidas!\n");
        }else {
            System.out.println("\nVuelos encontrados: ");
            for (int i = 0; i < vuelos.length; i++) {
                System.out.println("Identificador: "+vuelos[i].getIdentificador());
                System.out.println("Ciudad origen: "+vuelos[i].getCiudadOrigen());
                System.out.println("Ciudad destino: "+vuelos[i].getCiudadDestino());
                System.out.println("Precio: $"+vuelos[i].getPrecio());
                System.out.println("");
            }
        }
    }
    
    
    
}
