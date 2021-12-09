package api.api;

public class Edge implements EdgeData{
    private int src;
    private int dest;
    private double weight;
    private String info;
    private int tag;

    public Edge(double weight) {
        this.weight = weight;
    }

    //added methods

    public void setSrc(int input) {
        this.src = input;
    }
    public void setDest(int input) {
        this.dest = input;
    }

    @Override
    public int getSrc() {
        return this.src;
    }

    @Override
    public int getDest() {
        return this.dest;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag = t;
    }
}
