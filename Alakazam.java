
package pokemon.kanto.adventure;

import java.util.Stack;

public class Alakazam extends Pokemon{

    public Alakazam() {
        super("Alakazam","Psychic",5,100,0);
    }
    
    public Alakazam(String location){
        super("Alakazam","Psychic",100,location);
    }
    
    public Alakazam(int level){
        super("Alakazam","Psychic",level,100);
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
        Stack<Skill> moveset= new Stack<>();
        moveset.push(new Skill("Future Sight",93.0,41));
        moveset.push(new Skill("Psychic",59.0,25));
        moveset.push(new Skill("Psyshock",37.0,15));
        moveset.push(new Skill("Psycho Cut",26.0,9));
        moveset.push(new Skill("Psybeam",17.0,5));
        moveset.push(new Skill("Confusion",15.0,5));
        
        return moveset;
    }
    
}
