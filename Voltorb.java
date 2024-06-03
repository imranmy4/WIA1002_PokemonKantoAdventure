package pokemonkantoadventure;

import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Voltorb extends Pokemon {

    public Voltorb() {
        super("Voltorb","Electric",5,103,0);
    }
    
    public Voltorb(String location) {
        super("Voltorb","Electric",103,location);
    }
    
    public Voltorb(int level) {
        super("Voltorb","Electric",level,103);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Water","Flying"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Ground"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Gyro Ball",96.0,36));
        moveset.push(new Skill("Electro Ball",71.0,25));
        moveset.push(new Skill("Charge Beam",43.0,12));
        moveset.push(new Skill("Spark",24.0,4,"PARALYZED"));
        moveset.push(new Skill("Eerie Impulse",16.0,1));
        moveset.push(new Skill("Thunder Shock",14.0,1,"PARALYZED"));
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("voltorb.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Voltorb picture is not found.");
        }
    }  
}
