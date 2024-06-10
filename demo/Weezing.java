/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

/**
 *
 * @author ahmad
 */
import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Weezing extends Pokemon {

    public Weezing() {
        super("Weezing","Poison",5,98,0);
    }
    
    public Weezing(String location) {
        super("Weezing","Poison",98,location);
    }
    
    public Weezing(int level) {
        super("Weezing","Poison",level,98);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Grass","Fairy"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Ground","Psychic"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Destiny Bond",106.0,41));
        moveset.push(new Skill("Memento",76.0,29));
        moveset.push(new Skill("Explosion",43.0,13));
        moveset.push(new Skill("Double Hit",29.0,6));
        moveset.push(new Skill("Clear Smog",17.0,1,"POISONED"));
        moveset.push(new Skill("Heat Wave",19.0,1));
        
        return moveset;    
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("weezing.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Weezing picture is not found.");
        }
    } 
}