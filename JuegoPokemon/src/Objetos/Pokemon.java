/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dialj
 */
public class Pokemon {

    private String nombre;
    private int vida;
    private String estado;
    private int ataque;
    private String imagen;
    private int estadoPartida;
    private int ataqueRecibido;
    private int elegido;

    public Pokemon(String nombre, int vida, String estado, int ataque, String imagen, int estadoPartida, int ataqueRecibido, int elegido) {
        this.nombre = nombre;
        this.vida = vida;
        this.estado = estado;
        this.ataque = ataque;
        this.imagen = imagen;
        this.estadoPartida = estadoPartida;
        this.ataqueRecibido = ataqueRecibido;
        this.elegido = elegido;
    }

    public Pokemon() {
        setNombre("");
        setVida(-1);
        setEstado("");
        setAtaque(-1);
        setImagen("");
        setEstadoPartida(0);
        setAtaqueRecibido(0);
        setElegido(0);
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
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
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
     * @return the ataque
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * @param ataque the ataque to set
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the partidaGanada
     */
    public int getEstadoPartida() {
        return estadoPartida;
    }

    /**
     * @param partidaGanada the partidaGanada to set
     */
    public void setEstadoPartida(int estadoPartida) {
        this.estadoPartida = estadoPartida;
    }

    /**
     * @return the partidaPerdida
     */
    public int getAtaqueRecibido() {
        return ataqueRecibido;
    }

    /**
     * @param partidaPerdida the partidaPerdida to set
     */
    public void setAtaqueRecibido(int ataqueRecibido) {
        this.ataqueRecibido = ataqueRecibido;
    }

    /**
     * @return the elegido
     */
    public int getElegido() {
        return elegido;
    }

    /**
     * @param elegido the elegido to set
     */
    public void setElegido(int elegido) {
        this.elegido = elegido;
    }

}
