package pokemonkantoadventure;

import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Rapidash extends Pokemon {

    public Rapidash() {
        super("Rapidash","Fire",5,101,0);
    }
    
    public Rapidash(String location) {
        super("Rapidash","Fire",101,location);
    }
    
    public Rapidash(int level) {
        super("Rapidash","Fire",level,101);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Grass","Bug","Ice","Steel"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Water","Rock","Ground"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Flare Blitz",107.0,45,"BURNED"));
        moveset.push(new Skill("Fire Spin",74.0,29));
        moveset.push(new Skill("Flame Charge",41.0,13));
        moveset.push(new Skill("Ember",28.0,6,"BURNED"));
        moveset.push(new Skill("Poison Jab",17.0,1));
        moveset.push(new Skill("Megahorn",16.0,1));
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("rapidash.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Rapidash picture is not found.");
        }
    }
}
