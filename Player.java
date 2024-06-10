package pokemonkantoadventure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;                                                       
import java.util.Stack;

public class Player implements Serializable {                                                      
    int pokeball;
    int antidote;
    private String name;
    private ArrayList<String> badge = new ArrayList<>();
    private ArrayList<Pokemon> pokemon = new ArrayList<>();              
    private ArrayList<Pokemon> usedPokemon = new ArrayList<>();
    private ArrayList<Pokemon> battlePokemon;
    private Pokemon currentPokemon;                                             // pokemon currently equipped(for battle)
    private int saveSlot;
    Stack<Pokemon> uncatchedPokemon = new Stack<>();
    
    Player(String name) {
        this.name = name;
        this.antidote = antidote;
        pokemon.add(starterPokemon());
        currentPokemon = null;
        battlePokemon = new ArrayList<Pokemon>(pokemon);
        
        //Pokemon that player haven't catched yet
        uncatchedPokemon.push(new Machop());
        uncatchedPokemon.push(new Pikachu());
        uncatchedPokemon.push(new Snorlax());
        uncatchedPokemon.push(new Eevee());
        uncatchedPokemon.push(new Jigglypuff());
        if(pokemon.get(0).getName().equals("Geodude"))
            uncatchedPokemon.push(new Bulbasaur());
        else
            uncatchedPokemon.push(new Geodude());
    }
    
    public Pokemon choosePokemon(){                                             //choose pokemon for battle
        int choice;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Which Pokemon would you like to use?");
        System.out.println("---------------------------------------------------------------\n");
        for(int i = 0 ; i < battlePokemon.size() ; i++) {
            System.out.print((i + 1) + ". " + battlePokemon.get(i).getName() + " [level " + battlePokemon.get(i).getLevel() + "]\t");
            System.out.println("[HP : " + battlePokemon.get(i).getHP() + "/" + battlePokemon.get(i).getHP() + "]" + "\t [XP : " + battlePokemon.get(i).getXP() + "/" + battlePokemon.get(i).getXPThreshold() + "]");
            System.out.println("Available moves: ");
            for(int j = 0 ; j < battlePokemon.get(i).getMovesAndDmg().size() ; j++){
                System.out.print("\t" + (j + 1) + ". " + battlePokemon.get(i).getMovesAndDmg().get(j).getMoveName() + " [" + (int) battlePokemon.get(i).getMovesAndDmg().get(j).getDamage() + " damage]");
            }
            System.out.println("\n");
        }
        System.out.println("---------------------------------------------------------------");
        do{
            System.out.print("Your choice: ");
            choice = acceptInt();
            if(choice > battlePokemon.size() || choice < 1)
                System.out.println("Try again!");
        } while(choice > battlePokemon.size() || choice < 1);
        if(currentPokemon != null)
            putBackPokemon();
        currentPokemon = battlePokemon.get(choice - 1);
        usedPokemon.add(battlePokemon.get(choice - 1));
        battlePokemon.remove(choice - 1);
        currentPokemon.display();
        currentPokemon.equipMoves();                                            //equip moves for pokemon
        return currentPokemon;
    }    
    
    public void resetPokemon() {                                                // reset pokemon after battle
        battlePokemon = new ArrayList<Pokemon>(pokemon);
        removeCurrentPokemon();
        usedPokemon.clear();
    }
    
    public void updatePokemon() {                                                // update used pokemon in case it level up after battle
        for(int i = 0 ; i < usedPokemon.size() ; i++){
            usedPokemon.get(i).resetCurrentHP();
            battlePokemon.add(usedPokemon.get(i));
        }
        pokemon = new ArrayList<Pokemon>(battlePokemon);
        usedPokemon.clear();
    }
    
    public Pokemon starterPokemon() {                                            // choose starter pokemon
        Scanner input = new Scanner(System.in);
        pokeball = 0;
        antidote = 0;
        int starter;
        Pokemon starterPokemon = null;
        
        Bulbasaur starter1 = new Bulbasaur();
        Geodude starter2 = new Geodude();
        
        System.out.println("---------------------------------------------------------------");
        System.out.println("Choose your starter pokemon!");
        System.out.println("1. " + starter1.getName() + "\t[" + starter1.getType() + "]\t [level " + starter1.getLevel() + "]\t [HP : " + starter1.getHP() + "/" + starter1.getHP() + "]");
        System.out.println("Moves: ");
        for(int j = 0 ; j < starter1.getMovesAndDmg().size() ; j++){
            System.out.print("\t" + (j + 1) + ". " + starter1.getMovesAndDmg().get(j).getMoveName() + " [" + (int) starter1.getMovesAndDmg().get(j).getDamage() + " damage]");
        }
        System.out.println("\n\n2. " + starter2.getName() + "\t[" + starter2.getType() + "]\t [level " + starter2.getLevel() + "]\t [HP : " + starter2.getHP() + "/" + starter2.getHP() + "]");
        System.out.println("Moves: ");
        for(int j = 0 ; j < starter2.getMovesAndDmg().size() ; j++){
            System.out.print("\t" + (j + 1) + ". " + starter2.getMovesAndDmg().get(j).getMoveName() + " [" + (int) starter2.getMovesAndDmg().get(j).getDamage() + " damage]");
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------\n");
        do{
            starter = acceptInt();
            switch(starter) {
                case 1 : 
                    starterPokemon = starter1;
                    starter1.display();
                    System.out.println("You chose " + starterPokemon.getName() + "! Good choice!");
                    System.out.println("Good luck on your journey!");
                    break;
                
                case 2 : 
                    starterPokemon = starter2;
                    starter2.display();
                    System.out.println("You chose " + starterPokemon.getName() + "! Good choice!");
                    System.out.println("Good luck on your journey!");
                    break;
                
                default : 
                    System.out.println("Try again!");
                    break;
            }
            System.out.println("---------------------------------------------------------------");
        } while(starterPokemon == null);
        
        return starterPokemon;
    }
    
    public void catchPokemon() {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        String choice;
        
        if(uncatchedPokemon.isEmpty())
            return;
        else {
            int chance = (rand.nextInt(7) + 1);
            switch(chance) {
                case 1:
                    System.out.println("---------------------------------------------------------------");
                    System.out.println("You encountered a wild " + uncatchedPokemon.peek().getName() + "!");
                    System.out.println("You have " + pokeball + " pokeballs ");
                    System.out.print("Would you like to catch it? [yes/no] : ");
                    do{
                    choice = input.nextLine();
                    if(choice.equalsIgnoreCase("yes")) {
                        pokeball--;
                        int pokeball_probability = rand.nextInt(2);
                        switch(pokeball_probability) {
                        case 1:
                            System.out.println("Oops, the pokemon got away, better luck next time .");
                            break;
                        case 0:
                            System.out.println("You have obtained " + uncatchedPokemon.peek().getName() + "!");
                            newPokemon(uncatchedPokemon.pop());
                            break;
                        }
                        System.out.println("You now have " + pokeball + " pokeballs ");
                    }
                    else if(choice.equalsIgnoreCase("no"))
                        System.out.println("You'll have another chance to catch it next time!");
                    else
                        System.out.print("Invalid input! [yes/no] : ");
                    } while(!(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("no")));
                    System.out.println("---------------------------------------------------------------");
                    break;
                default:
                    break;
            }
        }
    }
    
    public void removeCurrentPokemon() {
        currentPokemon = null;
    }
    
    public void putBackPokemon() {                                                // put back pokemon if player want to change mid-battle
        battlePokemon.add(currentPokemon);
        currentPokemon = null;
    }
    
    public ArrayList<Pokemon> getPokemon() {
        return pokemon;
    }
    
    public ArrayList<Pokemon> getBattlePokemon() {
        return battlePokemon;
    }
    
    public ArrayList<Pokemon> getUsedPokemon() {
        return usedPokemon;
    }
    
    public Pokemon getCurrentPokemon() {
        return currentPokemon;
    }
    
    public void newPokemon(Pokemon newPokemon) {
        pokemon.add(newPokemon);
        battlePokemon = new ArrayList<Pokemon>(pokemon);
    }
    
    public String getName() {
        return name;
    }
    
    public void setSaveSlot(int saveSlot) {
        this.saveSlot = saveSlot;
    }
    
    public int getSaveSlot() {
        return saveSlot;
    }
    
    public boolean battlePokemonEmpty() {
        return battlePokemon.isEmpty();
    }
    
    public ArrayList<String> getBadges() {
        return badge;
    }
    
    public void obtainBadge(String badge) {
        this.badge.add(badge);
    }

    public static int acceptInt() {
        int i;
        Scanner input = new Scanner(System.in);
        try{
            i = input.nextInt();
            input.nextLine();
            return i;
        } catch(InputMismatchException ex) {
            return -1;
        }
    }
    
    public int getAntidote() {
        return antidote;
    }
}
