package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {

    Maze maze;
    int[][] posibleNeighbors = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0,-1}, {-1, -1}};

    public SearchableMaze(Maze maze) {
        this.maze = maze;
    }

    @Override
    public AState getStartState() {
        return fromPositionToState(maze.getStartPosition());
    }

    @Override
    public AState getGoalState() {
        return fromPositionToState(maze.getGoalPosition());
    }

    @Override
    public ArrayList<AState> getAllPossibleStates(AState state) {
        ArrayList<AState> allPosibleStates = new ArrayList<>();
        Position position = fromStateToPosition(state);
        for (int ind = 0; ind < posibleNeighbors.length; ind++) {
            int i = position.getRowIndex() + posibleNeighbors[ind][0];
            int j = position.getColumnIndex() + posibleNeighbors[ind][1];
            if (i >= 0 && i < maze.getRows() && j >= 0 && j < maze.getColumns()) {
                if(maze.getMaze()[i][j]==0){
                    allPosibleStates.add(fromPositionToState(new Position(i,j)));
                }
            }
        }

        return allPosibleStates;
    }

    private AState fromPositionToState(Position position) {
        String stateName = position.getRowIndex() + "," + position.getColumnIndex();
        AState result = new MazeState(stateName);
        return result;
    }

    private Position fromStateToPosition(AState state) {
        Position position = null;
        String[] coardinates = state.getState().split(",");
        if (coardinates != null) {
            int x = Integer.parseInt(coardinates[0]);
            int y = Integer.parseInt(coardinates[1]);
            position = new Position(x, y);
        }
        return position;
    }
}
