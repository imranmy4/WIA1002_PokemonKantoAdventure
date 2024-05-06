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
    //private ArrayList<String> movesNames;     x gabung move name and dmg
    //private ArrayList<Double> movesDmgs;
    private ArrayList<Skill> movesAndDmg; //TESTTTTTTT
    //private String[] currentMovesName;        array nama current moves
    //private double[] currentMovesDmg;         array dmg current moves
    private Skill[] currentMovesAndDmg;
    
    Pokemon(String name, String type, int level, int HP, int XP){
        this.name = name;
        this.type = type;
        this.level = level;
        this.HP = HP;
        this.XP = XP;
        this.strength = initializeStrength();
        this.weakness = initializeWeakness();
        //this.movesNames = initializeMovesName();      method move and dmg pokemon baru
        //this.movesDmgs = initializeMovesDmg();
        this.movesAndDmg = initializeMoveAndDmg(); //TESTTTTTT
        //this.currentMovesName = initializeCurrentMoves();         initial current moves name
        //this.currentMovesDmg = initializeCurrentMovesDmgs();      initial current moves dmg
        this.currentMovesAndDmg = initializeCurrentMovesAndDmg();
    }
    
    public abstract String[] initializeStrength();
    
    public abstract String[] initializeWeakness();
    
    //public abstract ArrayList<String> initializeMovesName();
    
    //public abstract ArrayList<Double> initializeMovesDmg();
    
    public abstract ArrayList<Skill> initializeMoveAndDmg();
    
    public Skill[] initializeCurrentMovesAndDmg(){
        Skill initialMove1, initialMove2;
        initialMove1 = movesAndDmg.get(0);
        initialMove2 = movesAndDmg.get(1);
        return new Skill[]{initialMove1,initialMove2};
    }
    
    public void addMoves(Skill skill){
        movesAndDmg.add(skill);
    }
    
    /*
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
    */
    
    public int attack(int enemyHP, Pokemon myPokemon, Pokemon enemy){
        Scanner input = new Scanner(System.in);
        int move;
        int damage;
        double dmgMultiplier = 1;
        /*
        String[] currentMoves = myPokemon.getCurrentMovesName();
        double[] currentMovesDmg = myPokemon.getCurrentMovesDmg();
        */
        Skill[] currentMovesAndDmg = myPokemon.getCurrentMovesAndDmg();
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
            System.out.println(i+1+". "+currentMovesAndDmg[i].getMoveName());
        }
        System.out.println("Which moves will "+myPokemon.getName()+" use?");
        move = input.nextInt();
        
        switch(move){
            case 1 : System.out.println(myPokemon.getName()+" uses "+currentMovesAndDmg[0].getMoveName()+"!");
            damage = (int) Math.ceil(currentMovesAndDmg[0].getDamage()*dmgMultiplier);
            enemyHP -= damage;
            break;
            
            case 2 : System.out.println(myPokemon.getName()+" uses "+currentMovesAndDmg[1].getMoveName()+"!");
            damage = (int) Math.ceil(currentMovesAndDmg[1].getDamage()*dmgMultiplier);
            enemyHP -= damage;
            break;
        }
        
        return enemyHP;
    }
    
    public int defense(int myHP, Pokemon myPokemon, Pokemon enemy){
        double dmgMultiplier = 1;
        int damage;
        int enemyMoveChoice;
        /*
        String[] enemyMoveName = enemy.getCurrentMovesName();
        double[] enemyMoveDmg = enemy.getCurrentMovesDmg();
        */
        Skill[] enemyMovesAndDmg = enemy.getCurrentMovesAndDmg();
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
            case 1 : System.out.println(enemy.getName()+" uses "+enemyMovesAndDmg[0].getMoveName()+"!");
            damage = (int) Math.ceil(enemyMovesAndDmg[0].getDamage()*dmgMultiplier);
            myHP -= damage;
            break;
            
            case 2 : System.out.println(enemy.getName()+" uses "+enemyMovesAndDmg[1].getMoveName()+"!");
            damage = (int) Math.ceil(enemyMovesAndDmg[1].getDamage()*dmgMultiplier);
            myHP -= damage;
            break;
        }
        return myHP;
    }
    
    public void equipMoves(){
        Scanner input = new Scanner(System.in);
        int moveNum1, moveNum2;
        System.out.println("Which moves would you like to equip on"+getName());
        for(int i=0; i<movesAndDmg.size();i++){
            System.out.print("\t"+i+1+". "+movesAndDmg.get(i));
        }
        System.out.print("1st move: ");
        moveNum1 = input.nextInt();
        System.out.print("2nd move: ");
        moveNum2 = input.nextInt();
        
        currentMovesAndDmg[0] = movesAndDmg.get(moveNum1-1);
        currentMovesAndDmg[1] = movesAndDmg.get(moveNum2-1);
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
    
    public Skill[] getCurrentMovesAndDmg(){
        return currentMovesAndDmg;
    }
    
    public ArrayList<Skill> getMovesAndDMg(){
        return movesAndDmg;
    }
    
    /*
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
    */
    
}
