
package pokemon.kanto.adventure;

import java.util.Stack;

public class Rhydon extends Pokemon{

    public Rhydon() {
        super("Rhydon","Ground/Rock",5,112,0);
    }
    
    public Rhydon(String location){
        super("Rhydon","Ground/Rock",112,location);
    }
    
    public Rhydon(int level){
        super("Rhydon","Ground/Rock",level,112);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Fire","Electric","Poison","Flying","Bug","Ice"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Water","Grass","Ice","Fighting","Ground","Steel"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Horn Drill",102.0,45));
        moveset.push(new Skill("Stone Edge",73.0,31));
        moveset.push(new Skill("Earthquake",50.0,20));
        moveset.push(new Skill("Drill Run",29.0,10));
        moveset.push(new Skill("Hammer Arm",19.0,5));
        moveset.push(new Skill("Bulldoze",18.0,5));
        
        return moveset;
    }
    
}
