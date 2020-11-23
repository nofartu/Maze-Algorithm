package algorithms.search;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    int numOfNodesEvaluated;
    Solution solution;

    public ASearchingAlgorithm() {
        this.numOfNodesEvaluated = 0;
        this.solution = new Solution();
    }

    public int getNumberOfNodesEvaluated() {
        return numOfNodesEvaluated;
    }

}
