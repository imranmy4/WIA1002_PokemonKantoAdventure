package pokemonkantoadventure;

import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Espeon extends Pokemon {

    public Espeon() {
        super("Espeon","Psychic",5,103,0);
    }
    
    public Espeon(String location) {
        super("Espeon","Psychic",103,location);
    }
    
    public Espeon(int level) {
        super("Espeon","Psychic",level,103);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Fighting","Poison"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Bug","Ghost","Dark"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Last Resort",99.0,42));
        moveset.push(new Skill("Future Sight",78.0,32));
        moveset.push(new Skill("Morning Sun",50.0,18));
        moveset.push(new Skill("Baby-doll Eyes",25.0,6));
        moveset.push(new Skill("Charm",15.0,1));
        moveset.push(new Skill("Bite",14.0,1));
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("espeon.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Espeon picture is not found.");
        }
    }
}
