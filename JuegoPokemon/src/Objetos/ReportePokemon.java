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
public class ReportePokemon {
    
    private Pokemon miPokemon;
    
    public ReportePokemon(Pokemon miPokemon) {
        this.miPokemon = miPokemon;
    }
    
    public ReportePokemon() {
        setMiPokemon(null);
    }

    /**
     * @return the miPokemon
     */
    public Pokemon getMiPokemon() {
        return miPokemon;
    }

    /**
     * @param miPokemon the miPokemon to set
     */
    public void setMiPokemon(Pokemon miPokemon) {
        this.miPokemon = miPokemon;
    }
    
}
