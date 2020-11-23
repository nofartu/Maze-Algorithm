package algorithms.search;

public interface ISearchingAlgorithm {

    Solution solve(ISearchable searchble);
    int getNumberOfNodesEvaluated();
    String getName();
}
