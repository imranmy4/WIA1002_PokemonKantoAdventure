
package pokemon.kanto.adventure;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
    private Pokemon currentPokemon;
    Player(){
        pokemon.add(new Bulbasaur());
        pokemon.add(new Geodude());
    }
    
    public void choosePokemon(){
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
        choice = input.nextInt();
        currentPokemon = pokemon.get(choice-1);
        currentPokemon.equipMoves();
    }
    
    public ArrayList<Pokemon> getPokemon(){
        return pokemon;
    }
    
    public Pokemon getCurrentPokemon(){
        return currentPokemon;
    }
}
