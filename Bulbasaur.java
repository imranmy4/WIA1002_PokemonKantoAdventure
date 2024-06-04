
package pokemon.kanto.adventure;

import java.util.Stack;

public class Bulbasaur extends Pokemon{
    
    public Bulbasaur() {                                                           //new player bulbasaur
        super("Bulbasaur","Grass/Poison",5,100,0);
    }
    
    public Bulbasaur(String location) {                                            //new wild bulbasaur
        super("Bulbasaur","Grass/Poison",100, location);    
    }
    
    public Bulbasaur(int level) {                                                           //gym leader pokemon
        super("Bulbasaur","Grass/Poison",level,100);
    }
    
    @Override
    public String[] setStrength() {
        return new String[]{"Water","Ground","Rock","Fairy"};
    }

    @Override
    public String[] setWeakness() {
       return new String[]{"Fire","Flying","Psychic","Ice"};
    }

    @Override
    public Stack<Skill> allMoves() {                                    //all bulbasaur moves(top of stack is growl)
        Stack<Skill> moveset = new Stack<Skill>();
        moveset.push(new Skill("Solar Beam",90,36));
        moveset.push(new Skill("Power Whip",60,22));
        moveset.push(new Skill("Razor Leaf",38.0,10));
        moveset.push(new Skill("Vine Whip",23.0,4));
        moveset.push(new Skill("Tackle",15.0,1));
        moveset.push(new Skill("Growl",13.0,1));
        
        return moveset;
    }
    
}
