
package pokemon.kanto.adventure;


public class PokemonKantoAdventure {

    
    public static void main(String[] args) {
        Player player = new Player();       //Create new Player(demo)
        Geodude enemyGeodude = new Geodude();       //Demo enemy
        System.out.println("POKEMON BATTLEEEEE!!!!!");
        player.choosePokemon();         //Player choose Pokemon for battle
        while(true)
            fight(player.getCurrentPokemon(),enemyGeodude);
    }
    
    public static void fight(Pokemon myPokemon, Pokemon enemy){     //myPokemon from Player, enemy from demo
        int myHP = myPokemon.getHP();       //will be checks for each pokemon HP
        int enemyHP = enemy.getHP();
        while(true){
            System.out.println();
            enemyHP = myPokemon.attack(enemy,enemyHP);       //myPokemon.attack will return enemyHP after taking damage by myPokemon
            if(enemyHP <= 0){               //check if Player won
                System.out.println();
                System.out.println(enemy.getName()+" HP : 0"+"/"+enemy.getHP());        //tell enemy pokemon hp turns zero
                System.out.println(myPokemon.getName()+" Won!");                        //tell Player won
                myPokemon.levelUp(enemy.getLevel());                     //myPokemon.levelUp check if XP from enemy enough to level up and if so, player pokemon levels up
                System.out.println(myPokemon.getName()+" XP : "+myPokemon.getXP());     //tell player pokemon XP after defeating enemy or after levels up(if it did)
                break;
            } else
                System.out.println(enemy.getName()+" HP : "+enemyHP+"/"+enemy.getHP());     //tell enemy remaining HP
            
            System.out.println();
            myHP = myPokemon.defense(enemy, myHP);                    //myPokemon.defense will return player pokemon HP after taking damage by enemy
            if(myHP <= 0){                  //check if Player lose
                System.out.println();
                System.out.println(myPokemon.getName()+" HP : 0"+"/"+myPokemon.getHP());        //tell player pokemon HP turns zero
                System.out.println(enemy.getName()+" Won!");                                    // tell enemy won
                break;
            } else
                System.out.println(myPokemon.getName()+" HP : "+myHP+"/"+myPokemon.getHP());        //tell player pokemon remaining HP
            
        }
    }
}
