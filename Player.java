
package pokemon.kanto.adventure;

import java.util.ArrayList;
import java.util.Scanner;                                                           //Nanti tukar la kalau perlu class ni(dekat main branch github je)

public class Player {                                                           //temporary player class
    private ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();              //i think player pokemon can be saved in arraylist (??)
    private Pokemon currentPokemon;                                             //pokemon currently equipped(for battle)
    
    Player(){
        currentPokemon = starterPokemon();
        pokemon.add(currentPokemon);
    }
    
    public void choosePokemon(){                                                //choose pokemon for battle
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("Which Pokemon would you like to use?");
        for(int i=0; i<pokemon.size();  i++){
            System.out.println((i+1)+". "+pokemon.get(i).getName()+" [level "+pokemon.get(i).getLevel()+"]");
            System.out.println("Available moves: ");
            for(int j=0; j<pokemon.get(i).getMovesAndDmg().size(); j++){
                System.out.print("\t"+(j+1)+". "+pokemon.get(i).getMovesAndDmg().get(j).getMoveName()+" ["+ (int) pokemon.get(i).getMovesAndDmg().get(j).getDamage()+" damage]");
            }
            System.out.println("\n\n");
        }
        System.out.println("Your choice: ");
        do{
        choice = input.nextInt();
        if(choice>pokemon.size())
                System.out.println("Try again!");
        } while(choice>pokemon.size());                
        currentPokemon = pokemon.get(choice-1);
        currentPokemon.equipMoves();                                            //equip moves for pokemon
    }
    
    public Pokemon starterPokemon(){
        Scanner input = new Scanner(System.in);
        int starter;
        Pokemon starterPokemon = null;
        System.out.println("Choose your starter pokemon!");
        System.out.println("1. Bulbasaur [level 5]\n");
        System.out.println("2. Geodude [level 5]");
        do{
            starter = input.nextInt();
            switch(starter){
                case 1 : starterPokemon = new Bulbasaur();
                    System.out.println("You chose "+starterPokemon.getName()+"! Good choice!");
                    System.out.println("Good luck on your journey!");
                break;
                
                case 2 : starterPokemon = new Geodude();
                    System.out.println("You chose "+starterPokemon.getName()+"! Good choice!");
                    System.out.println("Good luck on your journey!");
                break;
                
                default : System.out.println("Try again!");
                break;
            } 
        }while(starterPokemon == null);
        return starterPokemon;
            
    }
    
    public ArrayList<Pokemon> getPokemon(){
        return pokemon;
    }
    
    public Pokemon getCurrentPokemon(){
        return currentPokemon;
    }
    
    public void newPokemon(Pokemon newPokemon){
        pokemon.add(newPokemon);
    }
}
