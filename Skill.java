
package pokemon.kanto.adventure;

import java.io.Serializable;

public class Skill implements Serializable{                                            //class for pokemon moves
    private String moveName;
    private double damage;
    private int level;
    
    Skill(String moveName, double damage, int level){
        this.moveName = moveName;
        this.damage = damage;
        this.level = level;
    }
    public String getMoveName() {
        return moveName;
    }

    public double getDamage() {
        return damage;
    }
    
    public int getLevel(){
        return level;
    }
    
    public void addDamage(){
        this.damage += 2.0;
    }
   
}
