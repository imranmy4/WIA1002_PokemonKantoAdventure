package pokemonkantoadventure;

import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Koffing extends Pokemon {

    public Koffing() {
        super("Koffing","Poison",5,90,0);
    }
    
    public Koffing(String location) {
        super("Koffing","Poison",90,location);
    }
    
    public Koffing(int level) {
        super("Koffing","Poison",level,90);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Grass","Fairy"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Ground","Psychic"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Destiny Bond",104.0,45));
        moveset.push(new Skill("Belch",75.0,33));
        moveset.push(new Skill("Sludge Bomb",42.0,17,"POISONED"));
        moveset.push(new Skill("Smog",28.0,10,"POISONED"));
        moveset.push(new Skill("Tackle",16.0,5));
        moveset.push(new Skill("Poison Gas",18.0,5,"POISONED"));
        
        return moveset;      
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("koffing.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Koffing picture is not found.");
        }
    }
}
