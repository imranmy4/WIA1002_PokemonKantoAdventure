package pokemonkantoadventure;

import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Eevee extends Pokemon {

    public Eevee() {
        super("Eevee","Normal",5,100,0);
    }
    
    public Eevee(String location) {
        super("Eevee","Normal",100,location);
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
        moveset.push(new Skill("Double-Edge",99.0,43));
        moveset.push(new Skill("Take Down",58.0,23));
        moveset.push(new Skill("Bite",37.0,12));
        moveset.push(new Skill("Swift",21.0,5));
        moveset.push(new Skill("Tail Whip",12.0,1));
        moveset.push(new Skill("Tackle",14.0,1));
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("eevee.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Eevee picture is not found.");
        }
    }
}
