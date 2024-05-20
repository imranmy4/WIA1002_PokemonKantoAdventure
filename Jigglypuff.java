
package pokemon.kanto.adventure;

import java.util.Stack;

public class Jigglypuff extends Pokemon{

    public Jigglypuff() {
        super("Jigglypuff","Normal/Fairy",5,112,0);
    }
    
    public Jigglypuff(String location){
        super("Jigglypuff","Normal/Fairy",112,location);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Dragon","Fighting","Dark"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Poison","Steel"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Hyper Voice",89.0,40));
        moveset.push(new Skill("Body Slam",70.0,31));
        moveset.push(new Skill("Round",37.0,14));
        moveset.push(new Skill("Echoed Voice",22.0,8));
        moveset.push(new Skill("Pound",15.0,5));
        moveset.push(new Skill("Disarming Voice",13.0,5));
        
        return moveset;
    }
    
}
