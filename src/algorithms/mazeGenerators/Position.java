package algorithms.mazeGenerators;

public class Position {
    int row;
    int column;

    public Position(int x, int y) {
        this.row = x;
        this.column = y;
    }

    public int getRowIndex() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumnIndex() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "{" + row + ", y=" + column + '}';
    }
}
