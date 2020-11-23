package algorithms.search;

public abstract class AState {
    protected String state;
    protected double cost;
    protected AState originNode;

    public AState(String state){

        this.state=state;
    }

    public String getState() {
        return state;
    }
    public void setOriginNode(AState origin){

        this.originNode=origin;
    }

    public AState getOriginNode() {
        return originNode;
    }
}
