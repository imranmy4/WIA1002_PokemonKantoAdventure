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

public class Raichu extends Pokemon {

    public Raichu() {
        super("Raichu","Electric",5,110,0);
    }
    
    public Raichu(String location) {
        super("Raichu","Electric",110,location);
    }
    
    public Raichu(int level) {
        super("Raichu","Electric",level,110);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Water","Flying"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Ground"};
    }

    @Override
    public Stack<Skill> allMoves() {
         Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Thunderbolt",84.0,30,"PARALYZED"));
        moveset.push(new Skill("Thunder Punch",66.0,22,"PARALYZED"));
        moveset.push(new Skill("Thunder Shock",41.0,11,"PARALYZED"));
        moveset.push(new Skill("Thunder",25.0,4,"PARALYZED"));
        moveset.push(new Skill("Electro Ball",16.0,1));
        moveset.push(new Skill("Nuzzle",17.0,1,"PARALYZED"));
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("raichu.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Raichu picture is not found.");
        }
    }
}
    
    
    
