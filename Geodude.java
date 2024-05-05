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
public class Geodude extends Pokemon{

    public Geodude() {
        super("Geodude", "Rock/Ground", 1, 40, 0);
    }

    @Override
    public String[] initializeStrength() {
        return new String[]{"Poison","Fire","Flying"};
    }

    @Override
    public String[] initializeWeakness() {
        return new String[]{"Water","Grass","Ground"};
    }

    @Override
    public ArrayList<String> initializeMovesName() {
        ArrayList<String> movesName = new ArrayList<String>();
        movesName.add("Tackle");
        movesName.add("Rock Throw");
        return movesName;
    }

    @Override
    public ArrayList<Double> initializeMovesDmg() {
        ArrayList<Double> movesDmg = new ArrayList<Double>();
        movesDmg.add(20.0);
        movesDmg.add(25.0);
        return movesDmg;
    }
    
}
