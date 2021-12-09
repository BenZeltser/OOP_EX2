package api;

public class JsonEdge {
    int src;
    double weight;
    int dest;

    public JsonEdge(int src, int dest, double weight){
        this.src=src;
        this.dest=dest;
        this.weight=weight;
    }
}
