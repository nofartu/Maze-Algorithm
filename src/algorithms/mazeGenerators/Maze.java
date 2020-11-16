package algorithms.mazeGenerators;

public class Maze {
    int rows;
    int columns;
    int[][] maze;
    Position startPosition;
    Position endPosition;

    public Maze(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.maze=new int [rows][columns];
    }

    public int[][] getMaze() {
        return maze;
    }

    public void setMaze(int[][] maze) {
        this.maze = maze;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getColumns() {
        return columns;
    }

    // TODO: 11/16/2020  add the real positions
    public Position getStartPosition(){
        return this.startPosition;
    }
    public Position getGoalPosition(){
        return this.endPosition;
    }
    public void print(){
            for(int i=0;i<getRows();i++){
                for(int j=0;j<getColumns(); j++){
//                    if(maze[i][j]==0){
//                        System.out.print('-');
//                    }
//                    else if (i==getStartPosition().getX() &&j==getStartPosition().getY()){
//                        System.out.print('S');
//                    }
//                    else if (i==getGoalPosition().getX() &&j==getGoalPosition().getY()){
//                        System.out.print('E');
//                    }
//                    else{
//                        System.out.print('▓');
//                    }

                     if(i==getStartPosition().getRowIndex() &&j==getStartPosition().getColumnIndex()){
                        System.out.print('S');
                    }
                    else if(i==getGoalPosition().getRowIndex() &&j==getGoalPosition().getColumnIndex()){
                        System.out.print('E');
                    }else if(maze[i][j]==0 ){
                         System.out.print('-');
                     }
                    else{
                        System.out.print('▓');
                    }

                }
                System.out.println();
            }
        }

}
