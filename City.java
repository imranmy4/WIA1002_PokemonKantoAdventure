/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kantocity;

/**
 *
 * @author ahmad
 */
public class City {
    String name ;
    int index ;
    
    public City(String name , int index){
        this.name = name ;
        this.index = index ;
    }
    
    public String toString(){
        return name;
    }
}
