/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon.kanto.adventure;

import java.util.ArrayList;


/**
 *
 * @author IDEAPAD GAMING
 */
public class Bulbasaur extends Pokemon{
    
    
    Bulbasaur() {
        super("Bulbasaur","Grass/Poison",1,200,0);    
    }

    @Override
    public String[] initializeStrength() {
        return new String[]{"Water","Ground","Rock"};
    }

    @Override
    public String[] initializeWeakness() {
       return new String[]{"Fire","Flying","Psychic"};
    }

    /*@Override
    public ArrayList<String> initializeMovesName() {
        ArrayList<String> moveName = new ArrayList<String>();
        moveName.add("Tackle");
        moveName.add("Growl");
        return moveName;
    }

    @Override
    public ArrayList<Double> initializeMovesDmg() {
        ArrayList<Double> moveDmg = new ArrayList<Double>();
        moveDmg.add(20.0);
        moveDmg.add(10.0);
        return moveDmg;
    }*/

    @Override
    public ArrayList<Skill> initializeMoveAndDmg() {
        ArrayList<Skill> movesNameAndDmg = new ArrayList<Skill>();
        movesNameAndDmg.add(new Skill("Tackle",20.0));
        movesNameAndDmg.add(new Skill("Growl",10.0));
        return movesNameAndDmg;
    }
    
    
}
