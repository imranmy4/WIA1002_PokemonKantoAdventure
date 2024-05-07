
package pokemon.kanto.adventure;

import java.util.ArrayList;

public class Bulbasaur extends Pokemon{
    
    
    Bulbasaur() {
        super("Bulbasaur","Grass/Poison",5,200,0);    
    }

    @Override
    public String[] initializeStrength() {
        return new String[]{"Water","Ground","Rock"};
    }

    @Override
    public String[] initializeWeakness() {
       return new String[]{"Fire","Flying","Psychic"};
    }

    @Override
    public ArrayList<Skill> initializeMoveAndDmg() {
        ArrayList<Skill> movesNameAndDmg = new ArrayList<Skill>();
        movesNameAndDmg.add(new Skill("Tackle",20.0));
        movesNameAndDmg.add(new Skill("Growl",10.0));
        return movesNameAndDmg;
    }
    
    
}
