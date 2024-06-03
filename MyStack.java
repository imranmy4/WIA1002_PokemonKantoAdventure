package pokemonkantoadventure;

import java.util.ArrayList;

public class MyStack<E> {
    ArrayList<E> list = new ArrayList<>();
    
    public void push(E data) {
        list.add(data);
    }
    
    public E pop() {
        E temp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return temp;
    }
    
    public E peek() {
        return list.get(list.size() - 1);
    }
    
    public int size() {
        return list.size();
    }
    
    public String toString() {
        return list.toString();
    }
}
