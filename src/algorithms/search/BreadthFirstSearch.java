package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class BreadthFirstSearch extends ASearchingAlgorithm {

    private PriorityQueue<AState> neighbors;

    public BreadthFirstSearch() {
        neighbors = new PriorityQueue<>((o1, o2) -> 0);
    }

    @Override
    public Solution solve(ISearchable searchble) {
        HashSet<AState> visitedNodes = new HashSet<>();
        if (searchble == null)
            return null;
        neighbors.add(searchble.getStartState());
        while (!neighbors.isEmpty()) {
            AState currentNode = neighbors.poll();
            if (currentNode != null) {
                if (currentNode.equals(searchble.getGoalState())) {
                    solution.findPath(currentNode);
                    return solution;
                }
                ArrayList<AState> nodeNeighbors = searchble.getAllPossibleStates(currentNode);
                visitedNodes.add(currentNode);
                numOfNodesEvaluated++;
                for (int i = 0; i < nodeNeighbors.size(); i++) {
                    AState neighbor = nodeNeighbors.get(i);
                    if (!visitedNodes.contains(neighbor)) {
                        neighbors.add(neighbor);
                        neighbor.setOriginNode(currentNode);
                    }
                }
            }
        }
        return null;
    }


    @Override
    public String getName() {
        return "Breadth First Search";
    }


}
