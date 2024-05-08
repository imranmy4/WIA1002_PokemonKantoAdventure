
package pokemon.kanto.adventure;

import java.util.Stack;

public class Bulbasaur extends Pokemon{
    
    Bulbasaur() {                                                           //new player bulbasaur
        super("Bulbasaur","Grass/Poison",5,200,0);
    }
    
    Bulbasaur(String location) {                                            //new wild bulbasaur
        super("Bulbasaur","Grass/Poison",200, location);    
    }
    
    Bulbasaur(int savedLevel, int savedXP){                                 //saved player bulbasaur(to be implemented)
        super("Bulbasaur", "Grass/Poison", savedLevel, 200, savedXP);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Water","Ground","Rock"};
    }

    @Override
    public String[] setWeakness() {
       return new String[]{"Fire","Flying","Psychic"};
    }

    @Override
    public Stack<Skill> allMoves() {                                    //all bulbasaur moves(top of stack is growl)
        Stack<Skill> moveset = new Stack<Skill>();
        moveset.push(new Skill("Vine Whip",25.0,6));
        moveset.push(new Skill("Tackle",20.0,5));
        moveset.push(new Skill("Growl",10.0,5));
        
        return moveset;
    }
    
}
