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
public class MyStack<E>{
    ArrayList<E> list = new ArrayList<>();
    
    public void push(E data){
        list.add(data);
    }
    
    public E pop(){
        E temp = list.get(list.size()-1);
        list.remove(list.size()-1);
        return temp;
    }
    
    public E peek(){
        return list.get(list.size()-1);
    }
    
    public int size(){
        return list.size();
    }
    
    public String toString(){
        return list.toString();
    }
}