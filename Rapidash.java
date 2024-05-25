
package pokemon.kanto.adventure;

import java.util.Stack;

public class Rapidash extends Pokemon{

    public Rapidash() {
        super("Rapidash","Fire",5,101,0);
    }
    
    public Rapidash(String location){
        super("Rapidash","Fire",101,location);
    }
    
    public Rapidash(int level){
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
        moveset.push(new Skill("Flare Blitz",107.0,49));
        moveset.push(new Skill("Fire Spin",74.0,33));
        moveset.push(new Skill("Flame Charge",41.0,17));
        moveset.push(new Skill("Ember",28.0,10));
        moveset.push(new Skill("Poison Jab",17.0,5));
        moveset.push(new Skill("Megahorn",16.0,5));
        
        return moveset;
    }
    
}
