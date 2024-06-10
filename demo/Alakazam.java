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

public class Alakazam extends Pokemon {

    public Alakazam() {
        super("Alakazam","Psychic",5,100,0);
    }
    
    public Alakazam(String location) {
        super("Alakazam","Psychic",100,location);
    }
    
    public Alakazam(int level) {
        super("Alakazam","Psychic",level,100);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Fighting","Poison"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Bug","Ghost","Dark"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset= new Stack<>();
        moveset.push(new Skill("Future Sight",93.0,37));
        moveset.push(new Skill("Psychic",59.0,21));
        moveset.push(new Skill("Psyshock",37.0,11));
        moveset.push(new Skill("Psycho Cut",26.0,5));
        moveset.push(new Skill("Psybeam",17.0,1));
        moveset.push(new Skill("Confusion",15.0,1,"CONFUSION"));
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("alakazam.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Alakazam picture is not found.");
        }
    }
}