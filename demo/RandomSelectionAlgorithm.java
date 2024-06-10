/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

/**
 *
 * @author ahmad
 */
import java.util.*;

/*
        MapTools = contains basic function of graphs (fro the map)
                 = town (node), edge (weight and adjacent node)
                 = MapTools is to connect each nodes and its neighbors with one another

        RivalsRaceMap = initialize each town, its neighbors and weight
                      = returns the initialized map

        RandomSelectionAlgorithm = select random target town to race to

        DijkstraAlgorithm = Find the shortest path to go to the "target"

 */
// where the Target Town is specified
public class RandomSelectionAlgorithm {

    public List<Town> nonAdjNodes = new LinkedList<>();
    public RivalsRaceMap map;

    public RandomSelectionAlgorithm(RivalsRaceMap map) {
        this.map = map;
    }

    public void removingAdjacentNodes(Map<Town, Integer> neighbors, Town current) {

        // add all neighbors nodes into a new list
        nonAdjNodes.addAll(Town.getTowns().keySet());
//        System.out.print(nonAdjNodes + " ");
//        System.out.println("");

        // remove the current node
        nonAdjNodes.remove(current);
//        System.out.println("\nRemove " + current.toString());
//        System.out.print(nonAdjNodes + " ");
//        System.out.println("");

        // iterate through each neighbor
        Iterator<Town> iterator = nonAdjNodes.iterator();

        while (iterator.hasNext()) {

            Town neighbor = iterator.next();

            if (neighbors.containsKey(neighbor)) {
                iterator.remove();
//                System.out.println("Remove " + neighbor);
            }
        }

//        System.out.print(nonAdjNodes + " ");
//        System.out.println("");
    }

    public List<Town> getNonAdjNodes() {
        return nonAdjNodes;
    }

    public Town specifiedTargetTown() {

        if (nonAdjNodes.isEmpty()) {
            throw new IllegalStateException("No non-adjacent nodes available to select a target town.");
        } else {
            Random r = new Random();
            int index = r.nextInt(nonAdjNodes.size());
            return nonAdjNodes.get(index);
        }
    }
}
