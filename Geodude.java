
package pokemon.kanto.adventure;

import java.util.Stack;

public class Geodude extends Pokemon{

    Geodude() {                                                         //new player geodude
        super("Geodude","Rock/Ground",5,200,0);
    }
    
    Geodude(String location) {                                          //new wild geodude
        super("Geodude","Rock/Ground",200,location);
    }
    
    Geodude(int savedLevel, int savedXP){                               //saved player geodude(to be implemented)
        super("Geodude","Rock/Ground", savedLevel,200, savedXP);
    } 

    @Override
    public String[] setStrength() {
        return new String[]{"Fire","Flying","Bug"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Water","Grass","Ground"};
    }

    @Override
    public Stack<Skill> allMoves() {                                        //all geodude moves(tackle is top of stack)
        Stack<Skill> moveset = new Stack<Skill>();
        moveset.add(new Skill("Rollout",15.0,6));
        moveset.add(new Skill("Rock Throw",25.0,5));
        moveset.add(new Skill("Tackle",20.0,5));
        
        
        return moveset;
    }
    
}
