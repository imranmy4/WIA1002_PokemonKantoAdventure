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

public class Nidoqueen extends Pokemon {

    public Nidoqueen() {
        super("Nidoqueen","Poison/Ground",5,100,0);
    }
    
    public Nidoqueen(String location) {
        super("Nidoqueen","Poison/Ground",100,location);
    }
    
    public Nidoqueen(int level) {
        super("Nidoqueen","Poison/Ground",level,100);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Fire","Electric","Poison","Rock","Grass","Fairy"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Water","Ice","Psychic","Ground"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Superpower",99.0,40));
        moveset.push(new Skill("Poison Sting",73.0,28,"POISONED"));
        moveset.push(new Skill("Earth Power",50.0,17));
        moveset.push(new Skill("Fury Swipes",29.0,6));
        moveset.push(new Skill("Sludge Wave",18.0,1,"POISONED"));
        moveset.push(new Skill("Superpower",17.0,1));
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("nidoqueen.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Nidoqueen picture is not found.");
        }
    }
}