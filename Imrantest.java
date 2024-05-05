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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bulbasaur myBulbasaur = new Bulbasaur();
        Geodude enemyGeodude = new Geodude();
        fight(myBulbasaur,enemyGeodude);
    }
    
    public static void fight(Pokemon myPokemon, Pokemon enemy){
        int myHP = myPokemon.getHP();
        int enemyHP = enemy.getHP();
        while(true){
            enemyHP = myPokemon.attack(enemyHP,myPokemon, enemy);
            System.out.println(enemy.getName()+" HP : "+enemyHP+"/"+enemy.getHP());
            if(enemyHP <= 0)
                break;
            myHP = myPokemon.defense(myHP,myPokemon, enemy);
            System.out.println(myPokemon.getName()+" HP : "+myHP+"/"+myPokemon.getHP());
            if(myHP <= 0)
                break;
        }
    }
}
