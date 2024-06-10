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

public class Pikachu extends Pokemon {
    
     @Field("pikachu_name")
    String name ;
    public void setName(String name){
        this.name = name;
    }

    public Pikachu() {
        super("Pikachu","Electric",5,105,0);
    }
    
    public Pikachu(String location) {
        super("Pikachu","Electric",105, location);
    }
    
    public Pikachu(int level) {
        super("Pikachu","Electric",level,105);
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
        moveset.push(new Skill("Thunder",105.0,42,"PARALYZED"));
        moveset.push(new Skill("Thunderbolt",65.0,23,"PARALYZED"));
        moveset.push(new Skill("Spark",42.0,12,"PARALYZED"));
        moveset.push(new Skill("Electro Ball",23.0,4));
        moveset.push(new Skill("Nuzzle",15.0,1,"PARALYZED"));
        moveset.push(new Skill("Quick Attack",14.0,1));
           
        return moveset;
    }
    
    public void display() {
        try{
            Scanner sc = new Scanner(new FileInputStream("pikachu.txt"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("Pikachu picture is not found.");
        }
    }
}