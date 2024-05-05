/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon.kanto.adventure;

/**
 *
 * @author IDEAPAD GAMING
 */
public abstract class Pokemon {
    private String name;
    private String type;
    private int level;
    private String[][] moves;
    private int HP;
    private int XP;
    private String[] strength;
    private String[] weakness;
    
    Pokemon(String name, String type, int level, int HP, int XP){
        this.name = name;
        this.type = type;
        this.level = level;
        this.HP = HP;
        this.XP = XP;
        this.strength = initializeStrength();
        this.weakness = initializeWeakness();
    }
    
    public abstract String[] initializeStrength();
    
    public abstract String[] initializeWeakness();
    
    public abstract void attack(Pokemon myPokemon, Pokemon enemy);
    
    public abstract void defense(Pokemon myPokemon, Pokemon enemy);
    
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
    
}
