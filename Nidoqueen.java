package pokemonkantoadventure;

import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Nidoqueen extends Pokemon {

    public Nidoqueen() {
        super("Nidoqueen","Poison/Ground",5,100,0);
    }
    
    public Nidoqueen(String location) {
        super("Nidoqueen","Poison/Ground",100,location);
    }
    
    public Nidoqueen(int level) {
        super("Nidoqueen","Poison/Ground",level,100);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Fire","Electric","Poison","Rock","Grass","Fairy"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Water","Ice","Psychic","Ground"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Superpower",99.0,44));
        moveset.push(new Skill("Poison Sting",73.0,32,"POISONED"));
        moveset.push(new Skill("Earth Power",50.0,21));
        moveset.push(new Skill("Fury Swipes",29.0,10));
        moveset.push(new Skill("Sludge Wave",18.0,5,"POISONED"));
        moveset.push(new Skill("Superpower",17.0,5));
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("nidoqueen.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Nidoqueen picture is not found.");
        }
    }
}
