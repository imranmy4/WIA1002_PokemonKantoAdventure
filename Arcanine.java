
package pokemon.kanto.adventure;

import java.util.Stack;

public class Arcanine extends Pokemon{

    public Arcanine() {
        super("Arcanine","Fire",5,108,0);
    }
    
    public Arcanine(String location){
        super("Arcanine","Fire",108,location);
    }
    
    public Arcanine(int level){
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
        moveset.push(new Skill("Flamethrower",103.0,46));
        moveset.push(new Skill("Extreme Speed",77.0,34));
        moveset.push(new Skill("Play Rough",47.0,19));
        moveset.push(new Skill("Crunch",28.0,10));
        moveset.push(new Skill("Fire Fang",17.0,5));
        moveset.push(new Skill("Flame Wheel",16.0,5));
        
        return moveset;
    }
    
}
