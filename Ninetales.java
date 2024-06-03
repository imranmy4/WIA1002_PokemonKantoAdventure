package pokemonkantoadventure;

import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Ninetales extends Pokemon {

    public Ninetales() {
        super("Ninetales","Fire",5,105,0);
    }
    
    public Ninetales(String location) {
        super("Ninetales","Fire",105,location);
    }
    
    public Ninetales(int level) {
        super("Ninetales","Fire",level,105);
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
        moveset.push(new Skill("Inferno",105.0,47,"BURNED"));
        moveset.push(new Skill("Incinerate",80.0,35));
        moveset.push(new Skill("Will-O-Wisp",47.0,19,"BURNED"));
        moveset.push(new Skill("Fire Spin",29.0,10));
        moveset.push(new Skill("Ember",18.0,5,"BURNED"));
        moveset.push(new Skill("Flamethrower",17.0,5,"BURNED"));
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("Ninetales.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Ninetales picture is not found.");
        }
    }
}
