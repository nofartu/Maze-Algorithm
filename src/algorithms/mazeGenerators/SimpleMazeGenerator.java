package algorithms.mazeGenerators;

public class SimpleMazeGenerator extends AMazeGenerator{
    @Override
    public Maze generate(int rows, int columns) {
       maze=new Maze(rows,columns);

       return maze;
    }
}
