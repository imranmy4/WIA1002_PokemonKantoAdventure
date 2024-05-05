/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemon.kanto.adventure;

/**
 *
 * @author IDEAPAD GAMING
 */
public class PokemonKantoAdventure {

    public static void main(String[] args) {
        Bulbasaur myBulbasaur = new Bulbasaur();
    }
    
    public void fight(Pokemon myPokemon, Pokemon enemy){
        int myHP = myPokemon.getHP();
        int enemyHP = enemy.getHP();
        while(myHP != 0 || enemyHP != 0){
            myPokemon.attack(myPokemon, enemy);
            myPokemon.defense(myPokemon, enemy);
        }
    }
}
