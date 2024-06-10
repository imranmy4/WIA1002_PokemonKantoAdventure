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
import org.springframework.data.mongodb.core.mapping.Field;

public class Jigglypuff extends Pokemon {
     @Field("jigglypuff_name")
    String name ;
    public void setName(String name){
        this.name = name;
    }

    public Jigglypuff() {
        super("Jigglypuff","Normal/Fairy",5,112,0);
    }
    
    public Jigglypuff(String location) {
        super("Jigglypuff","Normal/Fairy",112,location);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Dragon","Fighting","Dark"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Poison","Steel"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Hyper Voice",89.0,36));
        moveset.push(new Skill("Body Slam",70.0,37));
        moveset.push(new Skill("Round",37.0,10));
        moveset.push(new Skill("Echoed Voice",22.0,4));
        moveset.push(new Skill("Pound",15.0,1));
        moveset.push(new Skill("Disarming Voice",13.0,1));
        
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("jigglypuff.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Jigglypuff picture is not found.");
        }
    }
}