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

public class Tangela extends Pokemon {

    public Tangela() {
        super("Tangela","Grass",5,100,0);
    }
    
    public Tangela(String location) {
        super("Tangela","Grass",100,location);
    }
    
    public Tangela(int level) {
        super("Tangela","Grass",level,100);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Water","Ground","Rock"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Fire","Ice","Flying","Bug","Poison"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Tickle",86.0,33));
        moveset.push(new Skill("Power Whip",59.0,21));
        moveset.push(new Skill("Ancient Power",41.0,12));
        moveset.push(new Skill("Mega Drain",25.0,5));
        moveset.push(new Skill("Absorb",16.0,1));
        moveset.push(new Skill("Bind",14.0,1));
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("tangela.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Tangela picture is not found.");
        }
    }
}