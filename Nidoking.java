
package pokemon.kanto.adventure;

import java.util.Stack;

public class Nidoking extends Pokemon{

    public Nidoking() {
        super("Nidoking","Poison/Ground",5,96,0);
    }
    
    public Nidoking(String location){
        super("Nidoking","Poison/Ground",96,location);
    }
    
    public Nidoking(int level){
        super("Nidoking","Poison/Ground",level,96);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Fire","Electric","Poison","Rock","Grass","Fairy"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Water","Ice","Psychic","Ground"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Megahorn",100.0,44));
        moveset.push(new Skill("Peck",74.0,32));
        moveset.push(new Skill("Poison Jab",51.0,21));
        moveset.push(new Skill("Double Kick",30.0,10));
        moveset.push(new Skill("Sludge Wave",19.0,5));
        moveset.push(new Skill("Fury Attack",18.0,5));
        
        return moveset;
    }
    
}
