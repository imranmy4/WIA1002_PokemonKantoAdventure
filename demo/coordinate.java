/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

/**
 *
 * @author ahmad
 */
import java.util.ArrayList;
public class coordinate{
    int x ;
    int y ;
    public coordinate(int x , int y){
        this.x = x ;
        this.y = y ;
    }
    
    public String toString(){
        return "(x = "+x+", y = "+y+")";
    }
    
    public boolean contains(ArrayList<coordinate> list){
        for(int i=0 ; i<list.size() ; i++){
            if(list.get(i).x==this.x && list.get(i).y==this.y){
                return true ;
            }
        }
        return false;
    }

    
}
