package api;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DWG implements DirectedWeightedGraph {
    int recalled, recalled1 = 0; //Used as testers to check if a function was called
    int MC = 0; // Mode Counter

    public static HashMap<NodeData, ArrayList<EdgeData>> adjList = new HashMap<>();
    public static HashMap<Integer, NodeData> nodes = new HashMap<>();

    private Object RuntimeException;

    public DWG()
    {
        HashMap<NodeData, ArrayList<EdgeData>> adjList = new HashMap<>();
        HashMap<Integer, NodeData> nodes = new HashMap<>();
    }
    public DWG(ArrayList<NodeData> nodes, ArrayList<EdgeData> edges) {
        for (int i = 0; i < nodes.size(); i++) {
            NodeData node = nodes.get(i);
            this.nodes.put(i, node);
        }
        for (int k = 0; k < nodes.size(); k++) {
            ArrayList<EdgeData> neighborEdges = new ArrayList<>();
            for (int i = 0; i < edges.size(); i++) {
                if (edges.get(i).getSrc() == nodes.get(k).getKey() || edges.get(i).getDest() == nodes.get(k).getKey())
                    neighborEdges.add(edges.get(i));
            }
            //Team up the edges with the node
        this.adjList.put(nodes.get(k),neighborEdges);
        }
    }




    /**
     * returns the node_data by the node_id,
     *
     * @param key - the node_id
     * @return the node_data by the node_id, null if none.
     */
    @Override
    public NodeData getNode(int key) { return nodes.get(key);}

    /**
     * returns the data of the edge (src,dest), null if none.
     * Note: this method should run in O(1) time.
     *
     * @param src
     * @param dest
     * @return
     */
    @Override
    public EdgeData getEdge(int src, int dest) {

        ArrayList<EdgeData> edgesSRC = adjList.get(src);
        ArrayList<EdgeData> edgesDST = adjList.get(dest);

        for (int i=0;i<edgesSRC.size();i++){
            if (edgesSRC.contains(edgesDST.get(i))){
                return edgesDST.get(i);
            }
        }
        return null;
    }

    /**
     * adds a new node to the graph with the given node_data.
     * Note: this method should run in O(1) time.
     *
     * @param n
     */
    @Override
    public void addNode(NodeData n) {
        //Counting starts from 0
        recalled++;
        MC++;
        nodes.put(nodes.size(),n);
    }

    /**
     * Connects an edge with weight w between node src to node dest.
     * * Note: this method should run in O(1) time.
     *
     * @param src  - the source of the edge.
     * @param dest - the destination of the edge.
     * @param w    - positive weight representing the cost (aka time, price, etc) between src-->dest.
     */
    @Override
    public void connect(int src, int dest, double w) {
        NodeData SRC = nodes.get(src);
        NodeData DST = nodes.get(dest);
        double weight = w;

        Edge edge = new Edge(weight);
        adjList.get(SRC).add(edge);
        adjList.get(DST).add(edge);

        adjList.put(SRC,adjList.get(SRC));
        adjList.put(DST,adjList.get(DST));
        MC++;
    }


    /**
     * This method returns an Iterator for the
     * collection representing all the nodes in the graph.
     * Note: if the graph was changed since the iterator was constructed - a RuntimeException should be thrown.
     *
     * @return Iterator<node_data>
     */
    @Override
    public Iterator<NodeData> nodeIter() {
        int temp = recalled;
        Iterator iterate = nodes.keySet().iterator();
        if (temp!=recalled) {
            try {
                throw (Throwable) RuntimeException;
            } catch (Throwable e) {
                e.printStackTrace();
                System.out.println("Error - Node amount was changed during Iteration.");
            }
        }
        return iterate;
    }

    /**
     * This method returns an Iterator for all the edges in this graph.
     * Note: if any of the edges going out of this node were changed since the iterator was constructed - a RuntimeException should be thrown.
     *
     * @return Iterator<EdgeData>
     */
    @Override
    public Iterator<EdgeData> edgeIter() {
        int temp = recalled1;
        Iterator iterate = adjList.values().iterator();


        if (temp!=recalled1) {
            try {
                throw (Throwable) RuntimeException;
            } catch (Throwable e) {
                e.printStackTrace();
                System.out.println("Error - Node amount was changed during Iteration.");
            }
        }

        return iterate;
    }

    /**
     * This method returns an Iterator for edges getting out of the given node (all the edges starting (source) at the given node).
     * Note: if the graph was changed since the iterator was constructed - a RuntimeException should be thrown.
     *
     * @param node_id
     * @return Iterator<EdgeData>
     */
    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        ArrayList<EdgeData> i = adjList.get(node_id);
        Iterator ans = i.iterator();
        return ans;
    }

    /**
     * Deletes the node (with the given ID) from the graph -
     * and removes all edges which starts or ends at this node.
     * This method should run in O(k), V.degree=k, as all the edges should be removed.
     *
     * @param key
     * @return the data of the removed node (null if none).
     */
    @Override
    public NodeData removeNode(int key) {
        NodeData temp = nodes.get(key);
        adjList.remove(nodes.get(key));
        nodes.remove(key);
        MC++;
        return temp;
    }

    /**
     * Deletes the edge from the graph,
     * Note: this method should run in O(1) time.
     *
     * @param src
     * @param dest
     * @return the data of the removed edge (null if none).
     */
    @Override
    public EdgeData removeEdge(int src, int dest) {
        NodeData SRC = nodes.get(src);
        NodeData DST = nodes.get(dest);
        ArrayList<EdgeData> n1 = adjList.get(SRC);
        ArrayList<EdgeData> n2 = adjList.get(DST);
        EdgeData temp = null;
        Iterator i1 = n1.iterator();
        Iterator i2 = n2.iterator();

        while (i1.hasNext()){
            for (int i=0;i<n2.size();i++){
                if (i1.next()==n2.get(i)){
                   temp = n2.remove(i);
                }
            }
        i1.next();}

        MC++;
        return temp;
    }

    /**
     * Returns the number of vertices (nodes) in the graph.
     * Note: this method should run in O(1) time.
     *
     * @return
     */
    @Override
    public int nodeSize() {
        return nodes.values().size();
    }

    /**
     * Returns the number of edges (assume directional graph).
     * Note: this method should run in O(1) time.
     *
     * @return
     */
    @Override
    public int edgeSize() {
        int counter=0;

        for (int i=0;i<adjList.size();i++){
            for (int j=0;j<adjList.get(i).size();j++){
                counter++;
            }
        }
    return counter;}

    /**
     * Returns the Mode Count - for testing changes in the graph.
     *
     * @return
     */
    @Override
    public int getMC() {
        return MC;
    }
}
