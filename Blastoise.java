
package pokemon.kanto.adventure;

import java.util.Stack;

public class Blastoise extends Pokemon{

    public Blastoise() {
        super("Blastoise","Water",5,115,0);
    }
    
    public Blastoise(int level){
        super("Blastoise","Water",level,115);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Fire","Ground","Rock"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Electric","Grass"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Wave Crash",103.0,41));
        moveset.push(new Skill("Hydro Pump",72.0,29));
        moveset.push(new Skill("Rain Dance",45.0,18));
        moveset.push(new Skill("Flash Cannon",28.0,9));
        moveset.push(new Skill("Water Gun",18.0,5));
        moveset.push(new Skill("Tail Whip",15.0,5));
        
        return moveset;
    }
    
}
