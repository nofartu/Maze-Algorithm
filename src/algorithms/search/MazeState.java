package algorithms.search;

public class MazeState extends AState {
    public MazeState(String s) {
        super(s);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MazeState)) return false;
        MazeState mazeState = (MazeState) o;
        return this.state.equals(mazeState.state);
//        if (this.state.equals(mazeState.state)) {
//            return true;
//        }
//        return false;
    }

    @Override
    public int hashCode() {
        return this.state.hashCode();
    }
}
