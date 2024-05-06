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
        System.out.println("POKEMON BATTLEEEEE!!!!!");
        fight(myBulbasaur,enemyGeodude);
    }
    
    public static void fight(Pokemon myPokemon, Pokemon enemy){
        int myHP = myPokemon.getHP();
        int enemyHP = enemy.getHP();
        while(true){
            System.out.println();
            enemyHP = myPokemon.attack(enemyHP,myPokemon, enemy);
            if(enemyHP <= 0){
                System.out.println();
                System.out.println(enemy.getName()+" HP : 0"+"/"+enemy.getHP());
                System.out.println(myPokemon.getName()+" Won!");
                break;
            } else
                System.out.println(enemy.getName()+" HP : "+enemyHP+"/"+enemy.getHP());
            
            System.out.println();
            myHP = myPokemon.defense(myHP,myPokemon, enemy);
            if(myHP <= 0){
                System.out.println();
                System.out.println(myPokemon.getName()+" HP : 0"+"/"+myPokemon.getHP());
                System.out.println(enemy.getName()+" Won!");
                break;
            } else
                System.out.println(myPokemon.getName()+" HP : "+myHP+"/"+myPokemon.getHP());
            
        }
    }
}
