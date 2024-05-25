
package pokemon.kanto.adventure;

import java.util.Stack;

public class Espeon extends Pokemon{

    public Espeon() {
        super("Espeon","Psychic",5,103,0);
    }
    
    public Espeon(String location){
        super("Espeon","Psychic",103,location);
    }
    
    public Espeon(int level){
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
        moveset.push(new Skill("Last Resort",99.0,46));
        moveset.push(new Skill("Future Sight",78.0,36));
        moveset.push(new Skill("Morning Sun",50.0,22));
        moveset.push(new Skill("Baby-doll Eyes",25.0,10));
        moveset.push(new Skill("Charm",15.0,5));
        moveset.push(new Skill("Bite",14.0,5));
        
        return moveset;
    }
    
}
