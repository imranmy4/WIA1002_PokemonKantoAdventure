package pokemonkantoadventure;

import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Squirtle extends Pokemon {

    public Squirtle() {
        super("Squirtle","Water",5,92,0);
    }
    
    public Squirtle(String location) {
        super("Squirtle","Water",92,location);
    }
    
    public Squirtle(int level) {
        super("Squirtle","Water",level,92);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Fire","Ground","Rock"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Electric","Grass"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Wave Crash",96.0,40));
        moveset.push(new Skill("Hydro Pump",76.0,30));
        moveset.push(new Skill("Aqua Tail",49.0,17));
        moveset.push(new Skill("Water Pulse",27.0,6));
        moveset.push(new Skill("Rapid Spin",16.0,1));
        moveset.push(new Skill("Watergun",15.0,1));
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("squirtle.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Squirtle picture is not found.");
        }
    }
}
