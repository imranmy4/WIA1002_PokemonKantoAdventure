package pokemonkantoadventure;;

import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Arcanine extends Pokemon {

    public Arcanine() {
        super("Arcanine","Fire",5,108,0);
    }
    
    public Arcanine(String location) {
        super("Arcanine","Fire",108,location);
    }
    
    public Arcanine(int level) {
        super("Arcanine","Fire",level,108);
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
        moveset.push(new Skill("Flamethrower",103.0,42,"BURNED"));
        moveset.push(new Skill("Extreme Speed",77.0,30));
        moveset.push(new Skill("Play Rough",47.0,15));
        moveset.push(new Skill("Crunch",28.0,6));
        moveset.push(new Skill("Fire Fang",17.0,1,"BURNED"));
        moveset.push(new Skill("Flame Wheel",16.0,1,"BURNED"));
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("Arcanine(besar).txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Arcanine picture is not found.");
        }
    }
}
