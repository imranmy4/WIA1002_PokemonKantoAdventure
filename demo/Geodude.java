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
import java.nio.charset.Charset;
import org.springframework.data.mongodb.core.mapping.Field;


public class Geodude extends Pokemon {
     @Field("geodude_name")
    String name ;
    public void setName(String name){
        this.name = name;
    }

    public Geodude() {                                                          //new player geodude
        super("Geodude","Rock/Ground",5,110,0);
    }
    
    public Geodude(String location) {                                           //new wild geodude
        super("Geodude","Rock/Ground",110,location);
    }
    
    public Geodude(int level) {                                                 //gym leader pokemon
        super("Geodude","Rock/Ground",level,110);
    }
    
    @Override
    public String[] setStrength() {
        return new String[]{"Fire","Flying","Bug","Ice"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Water","Grass","Ground","Fighting","Ice"};
    }

    @Override
    public Stack<Skill> allMoves() {                                        //all geodude moves(tackle is top of stack)
        Stack<Skill> moveset = new Stack<Skill>();
        moveset.push(new Skill("Stone Edge",100.0,41));
        moveset.push(new Skill("Earthquake",62,24));
        moveset.push(new Skill("Rock Blast",40,11));
        moveset.push(new Skill("Rock Throw",22.0,3));
        moveset.push(new Skill("Rollout",16.0,1));
        moveset.push(new Skill("Tackle",14.0,1));
        
        
        return moveset;
    }
    
    public void display() {
        //System.out.println("hello");
        try{
            Scanner sc = new Scanner(new FileInputStream("geodude.txt"));
            //System.out.println("Default Charset=" + Charset.defaultCharset());
            while(sc.hasNextLine()) {
                
                String t =sc.nextLine();
                System.out.println(t);
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Geodude picture is not found.");
        }
    }
}