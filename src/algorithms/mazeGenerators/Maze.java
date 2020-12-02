package algorithms.mazeGenerators;

import java.util.ArrayList;

public class Maze {
    int rows;
    int columns;
    int[][] maze;
    Position startPosition;
    Position endPosition;

    public Maze(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.maze = new int[rows][columns];
    }

    public Maze(byte[] byteMaze) {
        this.rows = byteMaze[0];
        this.columns = byteMaze[1];
        this.maze = new int[this.rows][this.columns];
        this.startPosition = new Position(byteMaze[2], byteMaze[3]);
        this.endPosition = new Position(byteMaze[4], byteMaze[5]);
        mazeFromByte(byteMaze);
    }

    public void mazeFromByte(byte[] byteMaze) {
        int ind = 6;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (byteMaze[ind] == 0) {
                    ind++;
                }
                maze[i][j] = ind % 2;
                byteMaze[ind] -= 1;

            }
        }
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
    public Position getStartPosition() {
        return this.startPosition;
    }

    public Position getGoalPosition() {
        return this.endPosition;
    }

    public void print() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                if (i == getStartPosition().getRowIndex() && j == getStartPosition().getColumnIndex()) {
                    System.out.print('S');
                } else if (i == getGoalPosition().getRowIndex() && j == getGoalPosition().getColumnIndex()) {
                    System.out.print('E');
                } else if (maze[i][j] == 0) {
                    System.out.print('-');
                } else {
                    System.out.print('▓');
                }

            }
            System.out.println();
        }
    }

    public byte[] toByteArray() {
        byte[] mazeCompressed = compress();
        byte[] result = new byte[6 + mazeCompressed.length];
        result[0] = ((Integer) rows).byteValue();
        result[1] = ((Integer) columns).byteValue();
        result[2] = ((Integer) startPosition.getRowIndex()).byteValue();
        result[3] = ((Integer) startPosition.getColumnIndex()).byteValue();
        result[4] = ((Integer) endPosition.getRowIndex()).byteValue();
        result[5] = ((Integer) endPosition.getColumnIndex()).byteValue();
        for (int i = 6; i < result.length; i++) {
            result[i] = mazeCompressed[i - 6];
        }
        return result;
    }

    public byte[] compress() {
        ArrayList<Integer> collectedData = new ArrayList<>();
        int counter = 0;
        boolean isZero = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (maze[i][j] == 0 && isZero) {
                    counter++;
                } else if (maze[i][j] == 1 && !isZero) {
                    counter++;
                } else {
                    collectedData.add(counter);
                    isZero = !isZero;
                    counter = 1;
                }
            }
        }
        if (counter >= 1) {
            collectedData.add(counter);
        }
        byte[] compressedMaze = new byte[collectedData.size()];
        for (int i = 0; i < collectedData.size(); i++) {
            compressedMaze[i] = collectedData.get(i).byteValue();
        }
        return compressedMaze;
    }

    public void print(byte[] b) {
        System.out.println("on print:");
        for (int i = 0; i < b.length; i++) {
            System.out.print(" " + b[i] + ",");
        }
        System.out.println();
    }
}
