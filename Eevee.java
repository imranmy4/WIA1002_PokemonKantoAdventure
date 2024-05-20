
package pokemon.kanto.adventure;

import java.util.Stack;

public class Eevee extends Pokemon{

    public Eevee() {
        super("Eevee","Normal",5,100,0);
    }
    
    public Eevee(String location){
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
        moveset.push(new Skill("Double-Edge",99.0,47));
        moveset.push(new Skill("Take Down",58.0,27));
        moveset.push(new Skill("Bite",37.0,16));
        moveset.push(new Skill("Swift",21.0,9));
        moveset.push(new Skill("Tail Whip",12.0,5));
        moveset.push(new Skill("Tackle",14.0,5));
        
        return moveset;
    }
    
}
