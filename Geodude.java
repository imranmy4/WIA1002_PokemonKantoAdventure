
package pokemon.kanto.adventure;

import java.util.Stack;

public class Geodude extends Pokemon{

    Geodude() {                                                         //new player geodude
        super("Geodude","Rock/Ground",5,110,0);
    }
    
    Geodude(String location) {                                          //new wild geodude
        super("Geodude","Rock/Ground",110,location);
    }
    /*
    Geodude(int savedLevel, int savedXP){                               //saved player geodude(to be implemented)
        super("Geodude","Rock/Ground", savedLevel,200, savedXP);
    } 
    */
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
        //moveset.push(new Skill(""))
        moveset.push(new Skill("Rock Blast",42,15));
        moveset.push(new Skill("Rock Throw",2.0,7));
        moveset.push(new Skill("Rollout",16.0,5));
        moveset.push(new Skill("Tackle",14.0,5));
        
        
        return moveset;
    }
    
}
