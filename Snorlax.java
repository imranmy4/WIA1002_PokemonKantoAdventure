package pokemonkantoadventure;

import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Snorlax extends Pokemon {

    public Snorlax() {
        super("Snorlax","Normal",5,140,0);
    }
    
    public Snorlax(String location) {
        super("Snorlax","Normal",140,location);
    }
    
    public Snorlax(int level) {
        super("Snorlax","Normal",level,140);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"No extra damage"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Fighting"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Belch",72.0,35));
        moveset.push(new Skill("Heavy Slam",52.0,26));
        moveset.push(new Skill("Snore",30.0,16));
        moveset.push(new Skill("Bite",14.0,8));
        moveset.push(new Skill("Flail",10.0,5));
        moveset.push(new Skill("Covet",8.0,5));
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("snorlax.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Snorlax picture is not found.");
        }
    }   
}
