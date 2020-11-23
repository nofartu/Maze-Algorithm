package algorithms.search;

import java.util.ArrayList;

public class Solution {
    ArrayList<AState> solutionPath;

    public Solution(){
        solutionPath=new ArrayList<>();
    }
    public void addToSolution(AState state ){
        solutionPath.add(0,state);
    }
    public ArrayList<AState> getSolutionPath(){
        return solutionPath;
    }
    public void findPath(AState finalState){
        AState currentState=finalState;
        if(currentState.getOriginNode()==null)
            addToSolution(currentState);
        while(currentState.getOriginNode()!=null){
            addToSolution(currentState);
            currentState=currentState.getOriginNode();

        }
    }
}
