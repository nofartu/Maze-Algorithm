package algorithms.mazeGenerators;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import org.omg.Messaging.SyncScopeHelper;

import java.util.LinkedList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int columns) {
       maze = new Maze(rows,columns);
       initiateWalls();
       primAlgorithm();
       maze.print();
       return maze;
    }
    public void initiateWalls(){
        for (int i=0;i<maze.getRows();i++){
            for(int j=0;j<maze.getColumns();j++){
                maze.getMaze()[i][j]=1;
            }
        }
    }
    public void primAlgorithm(){
        final LinkedList<int[]> passageOptions = new LinkedList<>();
        final Random random = new Random();
        int x = random.nextInt(maze.getRows());
        int y = random.nextInt(maze.getColumns());
        maze.startPosition=new Position(x,y);
        passageOptions.add(new int[]{x,y,x,y});

        while ( !passageOptions.isEmpty() ){
            final int[] currentCheckingCells = passageOptions.remove( random.nextInt( passageOptions.size() ) );
            x = currentCheckingCells[2];
            y = currentCheckingCells[3];
            if ( maze.getMaze()[x][y] == 1 )
            {
                maze.getMaze()[currentCheckingCells[0]][currentCheckingCells[1]] = maze.getMaze()[x][y] = 0;
                if ( x >= 2 && maze.getMaze()[x-2][y] == 1 )
                    passageOptions.add( new int[]{x-1,y,x-2,y} );
                if ( y >= 2 && maze.getMaze()[x][y-2] == 1 )
                    passageOptions.add( new int[]{x,y-1,x,y-2} );
                if ( x < maze.getRows()-2 && maze.getMaze()[x+2][y] == 1 )
                    passageOptions.add( new int[]{x+1,y,x+2,y} );
                if ( y < maze.getColumns()-2 && maze.getMaze()[x][y+2] == 1 )
                    passageOptions.add( new int[]{x,y+1,x,y+2} );
            }
        }
        maze.endPosition=new Position(x,y);
    }

}
