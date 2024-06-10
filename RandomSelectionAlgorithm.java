


package pokemonkantoadventure;

import java.util.*;

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

        // remove the current node
        nonAdjNodes.remove(current);

        // iterate through each neighbor
        Iterator<Town> iterator = nonAdjNodes.iterator();

        while (iterator.hasNext()) {

            Town neighbor = iterator.next();

            if (neighbors.containsKey(neighbor)) {
                iterator.remove();
            }
        }

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
