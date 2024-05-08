
package pokemon.kanto.adventure;

import java.util.ArrayList;


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
