
package pokemon.kanto.adventure;

import java.util.Stack;

public class Bulbasaur extends Pokemon{
    
    Bulbasaur() {                                                           //new player bulbasaur
        super("Bulbasaur","Grass/Poison",5,100,0);
    }
    
    Bulbasaur(String location) {                                            //new wild bulbasaur
        super("Bulbasaur","Grass/Poison",100, location);    
    }
    
    /*
    Bulbasaur(int savedLevel, int savedXP){                                 //saved player bulbasaur(to be implemented)
        super("Bulbasaur", "Grass/Poison", savedLevel, 200, savedXP);
    }
    */

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
        moveset.push(new Skill("Solar Beam",90,40));
        moveset.push(new Skill("Power Whip",60,26));
        moveset.push(new Skill("Razor Leaf",38.0,14));
        moveset.push(new Skill("Vine Whip",23.0,8));
        moveset.push(new Skill("Tackle",15.0,5));
        moveset.push(new Skill("Growl",12.0,5));
        
        return moveset;
    }
    
}
