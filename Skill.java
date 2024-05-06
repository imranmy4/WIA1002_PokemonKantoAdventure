/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon.kanto.adventure;

/**
 *
 * @author IDEAPAD GAMING
 */
public class Skill {
    private String moveName;
    private double damage;
    Skill(String moveName, double damage){
        this.moveName = moveName;
        this.damage = damage;
    }
    public String getMoveName() {
        return moveName;
    }

    public double getDamage() {
        return damage;
    }
    
   
}
