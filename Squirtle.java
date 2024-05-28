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

public class Squirtle extends Pokemon{

    public Squirtle() {
        super("Squirtle","Water",5,92,0);
    }
    
    public Squirtle(String location){
        super("Squirtle","Water",92,location);
    }
    
    public Squirtle(int level){
        super("Squirtle","Water",level,92);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Fire","Ground","Rock"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Electric","Grass"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Wave Crash",96.0,44));
        moveset.push(new Skill("Hydro Pump",76.0,34));
        moveset.push(new Skill("Aqua Tail",49.0,21));
        moveset.push(new Skill("Water Pulse",27.0,10));
        moveset.push(new Skill("Rapid Spin",16.0,5));
        moveset.push(new Skill("Watergun",15.0,5));
        
        return moveset;
    }
    
    public void display(){
        try{
            Scanner sc = new Scanner(new FileInputStream("squirtle.txt"));
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();
        }catch(IOException e){
            System.out.println("Squirtle picture is not found");
        }
    }
}
