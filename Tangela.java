
package pokemon.kanto.adventure;

import java.util.Stack;

public class Tangela extends Pokemon{

    public Tangela() {
        super("Tangela","Grass",5,100,0);
    }
    
    public Tangela(String location){
        super("Tangela","Grass",100,location);
    }
    
    public Tangela(int level){
        super("Tangela","Grass",level,100);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Water","Ground","Rock"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Fire","Ice","Flying","Bug","Poison"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Tickle",86.0,37));
        moveset.push(new Skill("Power Whip",59.0,25));
        moveset.push(new Skill("Ancient Power",41.0,16));
        moveset.push(new Skill("Mega Drain",25.0,9));
        moveset.push(new Skill("Absorb",16.0,5));
        moveset.push(new Skill("Bind",14.0,5));
        
        return moveset;
    }
    
}
