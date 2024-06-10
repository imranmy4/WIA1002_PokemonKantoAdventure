/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

/**
 *
 * @author ahmad
 */
import java.io.Serializable;
import java.util.Random;

public class Skill implements Serializable {                                    //class for pokemon moves
    private String moveName;
    private double damage;
    private int level;
    private String sideEffect;
    private static final double SIDE_EFFECT_CHANCE = 0.4;
    
     Skill() {
    }
    
    Skill(String moveName, double damage, int level) {
        this.moveName = moveName;
        this.damage = damage;
        this.level = level;
    }
    
    Skill(String moveName, double damage, int level, String sideEffect) {
        this.moveName = moveName;
        this.damage = damage;
        this.level = level;
        this.sideEffect = sideEffect;
    }
    
    public String getMoveName() {
        return moveName;
    }

    public double getDamage() {
        return damage;
    }
    
    public int getLevel() {
        return level;
    }
    
    public String getSideEffect() {
        return sideEffect != null ? sideEffect : null;
    }

    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }
    
    public void addDamage() {
        this.damage += 2.0;
    }
    
    public boolean applySideEffect() {
        if (sideEffect == null) {
            return false; 
        }
        Random rand = new Random();
        return rand.nextDouble() < SIDE_EFFECT_CHANCE;
    }
}