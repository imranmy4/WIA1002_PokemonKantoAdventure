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

public class Eevee extends Pokemon{

    public Eevee() {
        super("Eevee","Normal",5,100,0);
    }
    
    public Eevee(String location){
        super("Eevee","Normal",100,location);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"No extra damage"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Fighting"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Double-Edge",99.0,47));
        moveset.push(new Skill("Take Down",58.0,27));
        moveset.push(new Skill("Bite",37.0,16));
        moveset.push(new Skill("Swift",21.0,9));
        moveset.push(new Skill("Tail Whip",12.0,5));
        moveset.push(new Skill("Tackle",14.0,5));
        
        return moveset;
    }
    
    public void display(){
        try{
            Scanner sc = new Scanner(new FileInputStream("eevee.txt"));
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();
        }catch(IOException e){
            System.out.println("Eevee picture is not found");
        }
    }
    
}
