/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author dialj
 */
public class Jugador {

    private String nombre;
    private Pokemon pokemon;
    private int numeroAtaque;
    private String estado;

    public Jugador(String nombre, Pokemon pokemon, int numeroAtaque, String estado) {
        this.nombre = nombre;
        this.pokemon = pokemon;
        this.numeroAtaque = numeroAtaque;
        this.estado = estado;
    }

    public Jugador() {
        this.nombre = "";
        this.numeroAtaque = 0;
        this.estado = "";
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

}
