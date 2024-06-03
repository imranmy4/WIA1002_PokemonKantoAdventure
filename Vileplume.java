package pokemonkantoadventure;

import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Vileplume extends Pokemon {

    public Vileplume() {
        super("Vileplume","Grass/Poison",5,102,0);
    }
    
    public Vileplume(String location) {
        super("Vileplume","Grass/Poison",102,location);
    }
    
    public Vileplume(int level) {
        super("Vileplume","Grass/Poison",level,102);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Water","Ground","Rock","Fairy"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Fire","Ice","Flying","Psychic"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Petal Blizzard",100.0,43));
        moveset.push(new Skill("Petal Dance",67.0,28));
        moveset.push(new Skill("Moonblast",46.0,18));
        moveset.push(new Skill("Giga Drain",26.0,9));
        moveset.push(new Skill("Stun Spore",17.0,5,"PARALYZED"));
        moveset.push(new Skill("Mega Drain",16.0,5));
        
        return moveset;    
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("vileplume.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Vileplume picture is not found.");
        }
    } 
}
