
package pokemon.kanto.adventure;

import java.util.ArrayList;

public class Geodude extends Pokemon{

    public Geodude() {
        super("Geodude", "Rock/Ground", 10, 200, 0);
    }

    @Override
    public String[] initializeStrength() {
        return new String[]{"Fire","Flying","Bug"};
    }

    @Override
    public String[] initializeWeakness() {
        return new String[]{"Water","Grass","Ground"};
    }

    @Override
    public ArrayList<Skill> initializeMoveAndDmg() {
        ArrayList<Skill> movesNameAndDmg = new ArrayList<Skill>();
        movesNameAndDmg.add(new Skill("Tackle",20.0));
        movesNameAndDmg.add(new Skill("Rock Throw",25.0));
        return movesNameAndDmg;
    }
    
}
