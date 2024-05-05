/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon.kanto.adventure;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author IDEAPAD GAMING
 */
public abstract class Pokemon {
    private String name;
    private String type;
    private int level;
    private int HP;
    private int XP;
    private String[] strength;
    private String[] weakness;
    private ArrayList<String> movesNames;
    private ArrayList<Double> movesDmgs;
    private String[] currentMovesName;
    private double[] currentMovesDmg;
    
    Pokemon(String name, String type, int level, int HP, int XP){
        this.name = name;
        this.type = type;
        this.level = level;
        this.HP = HP;
        this.XP = XP;
        this.strength = initializeStrength();
        this.weakness = initializeWeakness();
        this.movesNames = initializeMovesName();
        this.movesDmgs = initializeMovesDmg();
        this.currentMovesName = initializeCurrentMoves();
        this.currentMovesDmg = initializeCurrentMovesDmgs();
    }
    
    public abstract String[] initializeStrength();
    
    public abstract String[] initializeWeakness();
    
    public abstract ArrayList<String> initializeMovesName();
    
    public abstract ArrayList<Double> initializeMovesDmg();
    
    public String[] initializeCurrentMoves(){
        String move1, move2;
        move1 = movesNames.get(0);
        move2 = movesNames.get(1);
        return new String[]{move1,move2};
    }
    
    public double[] initializeCurrentMovesDmgs(){
        double dmg1, dmg2;
        dmg1 = movesDmgs.get(0);
        dmg2 = movesDmgs.get(1);
        return new double[]{dmg1,dmg2};
    }
    
    public int attack(int enemyHP, Pokemon myPokemon, Pokemon enemy){
        Scanner input = new Scanner(System.in);
        int move;
        int damage;
        double dmgMultiplier = 1;
        String[] currentMoves = myPokemon.getCurrentMovesName();
        double[] currentMovesDmg = myPokemon.getCurrentMovesDmg();
        String[] enemyWeakness = enemy.getWeakness();
        String[] myStrength = myPokemon.getStrength();
        for(String str1 : enemyWeakness){
            for(String str2 : myStrength){
                if(str2.equals(str1)){
                    dmgMultiplier = 1.2;
                }
            }
        }
        System.out.println(getName()+" Moves:");
        for(int i=0; i<2; i++){
            System.out.println(i+1+". "+currentMoves[i]);
        }
        System.out.println("Which moves will "+myPokemon.getName()+" use?");
        move = input.nextInt();
        
        switch(move){
            case 1 : System.out.println(myPokemon.getName()+" uses "+currentMoves[0]+"!");
            damage = (int) Math.ceil(currentMovesDmg[0]*dmgMultiplier);
            enemyHP -= damage;
            break;
            
            case 2 : System.out.println(myPokemon.getName()+" uses "+currentMoves[1]+"!");
            damage = (int) Math.ceil(currentMovesDmg[1]*dmgMultiplier);
            enemyHP -= damage;
            break;
        }
        
        return enemyHP;
    }
    
    public int defense(int myHP, Pokemon myPokemon, Pokemon enemy){
        double dmgMultiplier = 1;
        int damage;
        int enemyMoveChoice;
        String[] enemyMoveName = enemy.getCurrentMovesName();
        double[] enemyMoveDmg = enemy.getCurrentMovesDmg();
        String[] myWeakness = myPokemon.getWeakness();
        String[] enemyStrength = enemy.getStrength();
        for(String str1 : enemyStrength){
            for(String str2 : myWeakness){
                if(str2.equals(str1)){
                    dmgMultiplier = 1.2;
                }
            }
        }
        Random rand = new Random();
        enemyMoveChoice = rand.nextInt(2)+1;
        switch(enemyMoveChoice){
            case 1 : System.out.println(enemy.getName()+" uses "+enemyMoveName[0]+"!");
            damage = (int) Math.ceil(enemyMoveDmg[0]*dmgMultiplier);
            myHP -= damage;
            break;
            
            case 2 : System.out.println(enemy.getName()+" uses "+enemyMoveName[1]+"!");
            damage = (int) Math.ceil(enemyMoveDmg[1]*dmgMultiplier);
            break;
        }
        return myHP;
    }
    
    public void equipMoves(){
        System.out.println("Which moves would you like to equip on"+getName());
        for(int i=0; i<movesNames.size();i++){
            System.out.print("\t"+i+movesNames.get(i));
        }
        int check = movesNames.size();
        
        switch(check){
            case 1 : 
        }
    }
    
    public String getName(){
        return name;
    }
    
    public String getType(){
        return type;
    }
    
    public int getLevel(){
        return level;
    }
    
    public int getHP(){
        return HP;
    }
    
    public int getXP(){
        return XP;
    }
    
    public String[] getStrength(){
        return strength;
    }
    
    public String[] getWeakness(){
        return weakness;
    }
    
    public ArrayList<String> getMovesNames(){
        return movesNames;
    }
    
    public ArrayList<Double> getMovesDmgs(){
        return movesDmgs;
    }
    
    public String[] getCurrentMovesName(){
        return currentMovesName;
    }
    
    public double[] getCurrentMovesDmg(){
        return currentMovesDmg;
    }
    
    public void addMovesName(String str){
        movesNames.add(str);
    }
    
    public void addMovesDmg(double dmg){
        movesDmgs.add(dmg);
    }
    
}
