/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon.kanto.adventure;

import java.util.ArrayList;

/**
 *
 * @author IDEAPAD GAMING
 */
public class WildPokemon {                                          //demo wild pokemon class
    private ArrayList<Pokemon> wildPokemon;
    private String location;
    private Pokemon enemy;
    
    WildPokemon(){
        enemy = new Geodude("Pewter City");
    }
    
    public Pokemon getEnemy(){
        return enemy;
    }
}
