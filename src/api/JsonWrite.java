package api;

import java.util.ArrayList;

public class JsonWrite {
    private ArrayList<JsonEdge> edges;
    private ArrayList<JsonNode> nodes;

    public JsonWrite(ArrayList<JsonEdge> edgeList, ArrayList<JsonNode> nodeList) {
        this.edges=edgeList;
        this.nodes=nodeList;
    }
}
