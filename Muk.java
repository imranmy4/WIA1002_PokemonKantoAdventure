
package pokemon.kanto.adventure;

import java.util.Stack;

public class Muk extends Pokemon{

    public Muk() {
        super("Muk","Poison",5,105,0);
    }
    
    public Muk(String location){
        super("Muk","Poison",105,location);
    }
    
    public Muk(int level){
        super("Muk","Poison",level,105);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Grass","Fairy"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Ground","Psychic"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Memento",92.0,41));
        moveset.push(new Skill("Gunk Shot",57.0,25));
        moveset.push(new Skill("Mud Shot",39.0,16));
        moveset.push(new Skill("Sludge",26.0,9));
        moveset.push(new Skill("Mud Slap",16.0,5));
        moveset.push(new Skill("Poison Gas",15.0,5));
        
        return moveset;       
    }
    
}
