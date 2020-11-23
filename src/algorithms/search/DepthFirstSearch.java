package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm{
    @Override
    public Solution solve(ISearchable searchble) {
        if (searchble==null)
            return null;
        HashSet<AState> visited=new HashSet<>();
        Stack<AState> nodesToVisit=new Stack<>();
        nodesToVisit.add(searchble.getStartState());
        while(nodesToVisit!=null){
           AState currentNode= nodesToVisit.pop();
           if(currentNode!=null){
               if(currentNode.equals(searchble.getGoalState())){
                   solution.findPath(currentNode);
                   return solution;
               }
               visited.add(currentNode);
               numOfNodesEvaluated++;
               ArrayList<AState> nodeNeighbors=searchble.getAllPossibleStates(currentNode);
               for(int i=0;i<nodeNeighbors.size();i++){
                   AState neighbor= nodeNeighbors.get(i);
                   if(neighbor!=null &&!visited.contains(neighbor)){
                       nodesToVisit.push(neighbor);
                       neighbor.setOriginNode(currentNode);
                   }
               }
           }
        }
        return null;
    }

    @Override
    public String getName() {
        return "Depth First Search";
    }
}
