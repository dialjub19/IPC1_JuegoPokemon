/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.Scanner;

/**
 *
 * @author dialj
 */
public class Jugador {

    private String nombre;
    private Pokemon pokemon;
    private Pokemon pokemonDos;
    private int numeroAtaque;
    private String estado;

    public Jugador(String nombre, Pokemon pokemon, Pokemon pokemonDos, int numeroAtaque, String estado) {
        this.nombre = nombre;
        this.pokemon = pokemon;
        this.pokemonDos = pokemonDos;
        this.numeroAtaque = numeroAtaque;
        this.estado = estado;
    }

    public Jugador() {
        this.nombre = "";
        this.pokemon = null;
        this.pokemonDos = null;
        this.numeroAtaque = 0;
        this.estado = "";
    }

    public Pokemon elegirPokemonDeAtaque(Jugador jugador) {

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        System.out.println("-----------------------------------------");
        System.out.println("1." + jugador.getPokemon().getNombre());
        System.out.println("2." + jugador.getPokemonDos().getNombre());
        System.out.println("-----------------------------------------\n");
        opcion = entrada.nextInt();
        switch (opcion) {
            case 1:
                Pokemon uno = jugador.getPokemon();
                return uno;
            case 2:
                Pokemon dos = jugador.getPokemon();
                return dos;
            default:
                System.out.println("No puede elegir un pokemon diferente , vuelva a intentarlo");
                elegirPokemonDeAtaque(jugador);
        }
        return null;
    }

    public Pokemon elegirPokemonAtacar(Jugador jugador) {

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        System.out.println("-----------------------------------------");
        System.out.println("1." + jugador.getPokemon().getNombre());
        System.out.println("2." + jugador.getPokemonDos().getNombre());
        System.out.println("-----------------------------------------\n");
        opcion = entrada.nextInt();
        switch (opcion) {
            case 1:
                Pokemon uno = jugador.getPokemon();
                return uno;
            case 2:
                Pokemon dos = jugador.getPokemon();
                return dos;
            default:
                System.out.println("No puede elegir un pokemon diferente , vuelva a intentarlo");
                elegirPokemonAtacar(jugador);
        }
        return null;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the pokemon
     */
    public Pokemon getPokemon() {
        return pokemon;
    }

    /**
     * @param pokemon the pokemon to set
     */
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    /**
     * @return the numeroAtaque
     */
    public int getNumeroAtaque() {
        return numeroAtaque;
    }

    /**
     * @param numeroAtaque the numeroAtaque to set
     */
    public void setNumeroAtaque(int numeroAtaque) {
        this.numeroAtaque = numeroAtaque;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the pokemonDos
     */
    public Pokemon getPokemonDos() {
        return pokemonDos;
    }

    /**
     * @param pokemonDos the pokemonDos to set
     */
    public void setPokemonDos(Pokemon pokemonDos) {
        this.pokemonDos = pokemonDos;
    }

}
