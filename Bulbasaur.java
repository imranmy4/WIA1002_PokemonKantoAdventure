/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon.kanto.adventure;

/**
 *
 * @author IDEAPAD GAMING
 */
public class Bulbasaur extends Pokemon{
    
    
    Bulbasaur() {
        super("Bulbasaur","Grass/Poison",1,45,0);    
    }

    @Override
    public void attack(Pokemon myPokemon, Pokemon enemy) {
        String[] enemyWeakness = enemy.getWeakness();
        String[] myStrength = myPokemon.getStrength();
        for(String str1 : enemyWeakness){
            for(String str2 : myStrength){
                if(str2.equals(str1))
                    
            }
        }
            
    }

    @Override
    public void defense(Pokemon myPokemon, Pokemon enemy) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[] initializeStrength() {
        return new String[]{"Water","Ground","Rock"};
    }

    @Override
    public String[] initializeWeakness() {
       return new String[]{"Fire","Flying","Psychic"};
    }
    
    
}
