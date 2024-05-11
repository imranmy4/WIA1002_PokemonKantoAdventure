
package pokemon.kanto.adventure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;                                                           //Nanti tukar la kalau perlu class ni(dekat main branch github je)
import java.util.Stack;

public class Player implements Serializable{                                                           //temporary player class
    private String name;
    private ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();              //i think player pokemon can be saved in arraylist (??)
    private ArrayList<Pokemon> battlePokemon = new ArrayList<>();
    private Pokemon currentPokemon;                                             //pokemon currently equipped(for battle)
    private int choice;
    private int saveSlot;
    
    Player(String name){
        //pokemon.add(starterPokemon());
        this.name = name;
        pokemon.add(new Bulbasaur());
        pokemon.add(new Geodude());
        currentPokemon = pokemon.get(0);
        for(int i=0; i<pokemon.size(); i++)
            battlePokemon.add(pokemon.get(i));
    }
    
    public Pokemon choosePokemon(){                                                //choose pokemon for battle
        Scanner input = new Scanner(System.in);
        System.out.println("Which Pokemon would you like to use?");
        for(int i=0; i<battlePokemon.size();  i++){
            System.out.print((i+1)+". "+battlePokemon.get(i).getName()+" [level "+battlePokemon.get(i).getLevel()+"]\t");
            System.out.println("[HP : "+battlePokemon.get(i).getHP()+"/"+battlePokemon.get(i).getHP()+"]"+"\t [XP : "+battlePokemon.get(i).getXP()+"/"+battlePokemon.get(i).getXPThreshold()+"]");
            System.out.println("Available moves: ");
            for(int j=0; j<battlePokemon.get(i).getMovesAndDmg().size(); j++){
                System.out.print("\t"+(j+1)+". "+battlePokemon.get(i).getMovesAndDmg().get(j).getMoveName()+" ["+ (int) battlePokemon.get(i).getMovesAndDmg().get(j).getDamage()+" damage]");
            }
            System.out.println("\n");
        }
        System.out.println("Your choice: ");
        do{
        choice = input.nextInt();
        if(choice>battlePokemon.size())
            System.out.println("Try again!");
        } while(choice>battlePokemon.size());                
        currentPokemon = battlePokemon.get(choice-1);
        currentPokemon.equipMoves();                                            //equip moves for pokemon
        return currentPokemon;
    }
    
    public void resetBattlePokemon(){
        this.battlePokemon = pokemon;
    }
    
    public Pokemon starterPokemon(){
        Scanner input = new Scanner(System.in);
        int starter;
        Pokemon starterPokemon = null;
        Bulbasaur starter1 = new Bulbasaur();
        Geodude starter2 = new Geodude();
        System.out.println("Choose your starter pokemon!");
        System.out.println("1. "+starter1.getName()+"\t["+starter1.getType()+"]\t [level "+starter1.getLevel()+"]\t [HP : "+starter1.getHP()+"/"+starter1.getHP()+"]");
        System.out.println("Moves: ");
        for(int j=0; j<starter1.getMovesAndDmg().size(); j++){
            System.out.print("\t"+(j+1)+". "+starter1.getMovesAndDmg().get(j).getMoveName()+" ["+ (int) starter1.getMovesAndDmg().get(j).getDamage()+" damage]");
        }
        System.out.println("\n\n2. "+starter2.getName()+"\t["+starter2.getType()+"]\t [level "+starter2.getLevel()+"]\t [HP : "+starter2.getHP()+"/"+starter2.getHP()+"]");
        System.out.println("Moves: ");
        for(int j=0; j<starter2.getMovesAndDmg().size(); j++){
            System.out.print("\t"+(j+1)+". "+starter2.getMovesAndDmg().get(j).getMoveName()+" ["+ (int) starter2.getMovesAndDmg().get(j).getDamage()+" damage]");
        }
        System.out.println();
        do{
            starter = input.nextInt();
            switch(starter){
                case 1 : starterPokemon = starter1;
                    System.out.println("You chose "+starterPokemon.getName()+"! Good choice!");
                    System.out.println("Good luck on your journey!");
                break;
                
                case 2 : starterPokemon = starter2;
                    System.out.println("You chose "+starterPokemon.getName()+"! Good choice!");
                    System.out.println("Good luck on your journey!");
                break;
                
                default : System.out.println("Try again!");
                break;
            } 
        }while(starterPokemon == null);
        return starterPokemon;
            
    }
    
    public Pokemon removeCurrentPokemon(){
        currentPokemon = null;
        return currentPokemon;
    }
    
    public void removeBattlePokemon(){
        battlePokemon.remove(choice-1);
    }
    
    public ArrayList<Pokemon> getPokemon(){
        return pokemon;
    }
    
    public ArrayList<Pokemon> getBattlePokemon(){
        return battlePokemon;
    }
    
    public Pokemon getCurrentPokemon(){
        return currentPokemon;
    }
    
    public void newPokemon(Pokemon newPokemon){
        pokemon.add(newPokemon);
    }
    
    public String getName(){
        return name;
    }
    
    public void setSaveSlot(int saveSlot){
        this.saveSlot = saveSlot;
    }
    
    public int getSaveSlot(){
        return saveSlot;
    }
}
