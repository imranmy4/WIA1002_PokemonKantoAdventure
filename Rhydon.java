/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemonkantoadventure;

/**
 *
 * @author ahmad
 */
import java.util.Stack;
import java.util.Scanner;
import java.io.*;

public class Rhydon extends Pokemon{

    public Rhydon() {
        super("Rhydon","Ground/Rock",5,112,0);
    }
    
    public Rhydon(String location){
        super("Rhydon","Ground/Rock",112,location);
    }
    
    public Rhydon(int level){
        super("Rhydon","Ground/Rock",level,112);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Fire","Electric","Poison","Flying","Bug","Ice"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Water","Grass","Ice","Fighting","Ground","Steel"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Horn Drill",102.0,45));
        moveset.push(new Skill("Stone Edge",73.0,31));
        moveset.push(new Skill("Earthquake",50.0,20));
        moveset.push(new Skill("Drill Run",29.0,10));
        moveset.push(new Skill("Hammer Arm",19.0,5));
        moveset.push(new Skill("Bulldoze",18.0,5));
        
        return moveset;
    }
    
    public void display(){
        try{
            Scanner sc = new Scanner(new FileInputStream("rhydon.txt"));
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();
        }catch(IOException e){
            System.out.println("Rhydon picture is not found");
        }
    }
    
}
