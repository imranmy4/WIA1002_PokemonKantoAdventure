package pokemonkantoadventure;

import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Machop extends Pokemon {

    public Machop() {
        super("Machop","Fighting",5,102,0);
    }
    
    public Machop(String location) {
        super("Machop","Fighting",102,location);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Normal","Rock","Steel","Ice","Dark"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Flying","Psychic","Fairy"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Dynamic Punch",98.0,44));
        moveset.push(new Skill("Seismic Toss",67.0,29));
        moveset.push(new Skill("Knock Off",40.0,16));
        moveset.push(new Skill("Low Sweep",24.0,9));
        moveset.push(new Skill("Revenge",15.0,5));
        moveset.push(new Skill("Low Kick",13.0,5));
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("machop.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Machop picture is not found.");
        }
    }
}
