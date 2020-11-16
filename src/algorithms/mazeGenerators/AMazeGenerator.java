package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {
    Maze maze;
    public abstract Maze generate(int rows, int columns) ;

    public long measureAlgorithmTimeMillis(int rows, int columns) {
      long clickTime= System.currentTimeMillis();
      generate(rows, columns);
      long startTime=System.currentTimeMillis();
      return startTime-clickTime;
    }
}
