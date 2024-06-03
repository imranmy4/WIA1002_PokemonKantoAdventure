package pokemonkantoadventure;

import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Geodude extends Pokemon {

    public Geodude() {                                                          //new player geodude
        super("Geodude","Rock/Ground",5,110,0);
    }
    
    public Geodude(String location) {                                           //new wild geodude
        super("Geodude","Rock/Ground",110,location);
    }
    
    public Geodude(int level) {                                                 //gym leader pokemon
        super("Geodude","Rock/Ground",level,110);
    }
    
    @Override
    public String[] setStrength() {
        return new String[]{"Fire","Flying","Bug","Ice"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Water","Grass","Ground","Fighting","Ice"};
    }

    @Override
    public Stack<Skill> allMoves() {                                            //all geodude moves(tackle is top of stack)
        Stack<Skill> moveset = new Stack<Skill>();
        moveset.push(new Skill("Stone Edge",94.0,45));
        moveset.push(new Skill("Earthquake",62,28));
        moveset.push(new Skill("Rock Blast",40,15));
        moveset.push(new Skill("Rock Throw",22.0,7));
        moveset.push(new Skill("Rollout",16.0,1));
        moveset.push(new Skill("Tackle",14.0,1));
        
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("geodude.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Geodude picture is not found.");
        }
    }
}
