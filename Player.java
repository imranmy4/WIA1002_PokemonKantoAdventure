
package pokemon.kanto.adventure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;                                                           //Nanti tukar la kalau perlu class ni(dekat main branch github je)
import java.util.Stack;

public class Player implements Serializable{                                                           //temporary player class
    private String name;
    private ArrayList<Pokemon> pokemon = new ArrayList<>();              //i think player pokemon can be saved in arraylist (??)
    private ArrayList<Pokemon> battlePokemon;
    private ArrayList<Pokemon> usedPokemon = new ArrayList<>();
    private Pokemon currentPokemon;                                             //pokemon currently equipped(for battle)
    private int saveSlot;
    private ArrayList<String> badge = new ArrayList<>();
    
    Player(String name){
        this.name = name;
        pokemon.add(starterPokemon());
        currentPokemon = null;
        battlePokemon = new ArrayList<Pokemon>(pokemon);
    }
    
    public Pokemon choosePokemon(){                                                //choose pokemon for battle
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("Which Pokemon would you like to use?");
        System.out.println("---------------------------------------------------------------\n");
        for(int i=0; i<battlePokemon.size();  i++){
            System.out.print((i+1)+". "+battlePokemon.get(i).getName()+" [level "+battlePokemon.get(i).getLevel()+"]\t");
            System.out.println("[HP : "+battlePokemon.get(i).getHP()+"/"+battlePokemon.get(i).getHP()+"]"+"\t [XP : "+battlePokemon.get(i).getXP()+"/"+battlePokemon.get(i).getXPThreshold()+"]");
            System.out.println("Available moves: ");
            for(int j=0; j<battlePokemon.get(i).getMovesAndDmg().size(); j++){
                System.out.print("\t"+(j+1)+". "+battlePokemon.get(i).getMovesAndDmg().get(j).getMoveName()+" ["+ (int) battlePokemon.get(i).getMovesAndDmg().get(j).getDamage()+" damage]");
            }
            System.out.println("\n");
        }
        System.out.println("---------------------------------------------------------------");
        do{
            System.out.print("Your choice: ");
            choice = input.nextInt();
            input.nextLine();
            if(choice>battlePokemon.size())
                System.out.println("Try again!");
        } while(choice>battlePokemon.size());
        if(currentPokemon != null)
            putBackPokemon();
        currentPokemon = battlePokemon.get(choice-1);
        usedPokemon.add(battlePokemon.get(choice-1));
        battlePokemon.remove(choice-1);
        currentPokemon.equipMoves();                                            //equip moves for pokemon
        return currentPokemon;
    }    
    
    public void resetPokemon(){
        battlePokemon = new ArrayList<Pokemon>(pokemon);
        removeCurrentPokemon();
        usedPokemon.clear();
    }
    
    public void updatePokemon(){
        for(int i=0; i<usedPokemon.size(); i++){
            usedPokemon.get(i).resetCurrentHP();
            battlePokemon.add(usedPokemon.get(i));
        }
        pokemon = new ArrayList<Pokemon>(battlePokemon);
        usedPokemon.clear();
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
            System.out.println("---------------------------------------------------------------");
        }while(starterPokemon == null);
        return starterPokemon;
            
    }
    
    public void removeCurrentPokemon(){
        currentPokemon = null;
    }
    
    public void putBackPokemon(){
        battlePokemon.add(currentPokemon);
        currentPokemon = null;
    }
    
    public ArrayList<Pokemon> getPokemon(){
        return pokemon;
    }
    
    public ArrayList<Pokemon> getBattlePokemon(){
        return battlePokemon;
    }
    
    public ArrayList<Pokemon> getUsedPokemon(){
        return usedPokemon;
    }
    
    public Pokemon getCurrentPokemon(){
        return currentPokemon;
    }
    
    public void newPokemon(Pokemon newPokemon){
        pokemon.add(newPokemon);
        battlePokemon = new ArrayList<Pokemon>(pokemon);
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
    
    public boolean battlePokemonEmpty(){
        return battlePokemon.isEmpty();
    }
    
    public ArrayList<String> getBadges(){
        return badge;
    }
    
    public void obtainBadge(String badge){
        this.badge.add(badge);
    }
}
