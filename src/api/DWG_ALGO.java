package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static java.lang.Double.MAX_VALUE;

public class DWG_ALGO implements DirectedWeightedGraphAlgorithms
{
    DirectedWeightedGraph currentGraph=null;
    @Override
    public void init(DirectedWeightedGraph g) {
        currentGraph = g;
        System.out.println("Initialized the graph");
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return currentGraph;
    }

    @Override
    public DirectedWeightedGraph copy() {
        DirectedWeightedGraph newGraph=new DWG();
        int key=0;
        for (int i=0; i<currentGraph.nodeSize();i++)
        {
            NodeData thisNode=  currentGraph.getNode(i);
            double weight=thisNode.getWeight();
            GeoLocation loc=thisNode.getLocation();
            String info=thisNode.getInfo();
            int tag=thisNode.getTag();
            NodeData tempNode=new Node(i);
            tempNode.setInfo(info);
            tempNode.setLocation(loc);
            tempNode.setTag(tag);
            currentGraph.addNode(tempNode);

        }
        Iterator<EdgeData> it= currentGraph.edgeIter();
        while (it.hasNext())
        {
            EdgeData edge=it.next();
            int src=edge.getSrc(),dest=edge.getDest();
            double w=edge.getWeight();
            currentGraph.connect(src,dest,w);
        }
        return newGraph ;
    }

    @Override
    public boolean isConnected() {
        int edgeSize= currentGraph.edgeSize(),nodeSize=currentGraph.nodeSize();
        int sum=nodeSize*(nodeSize-1);
        if (sum==edgeSize) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        DijkstrasShortestPathAdjacencyListWithDHeap algoGraph=callingDijkstraAlgo();
        return algoGraph.dijkstra(src,dest);
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        DijkstrasShortestPathAdjacencyListWithDHeap algoGraph = callingDijkstraAlgo();
        List<Integer> tempIndexes = algoGraph.reconstructPath(src, dest);
        List<NodeData> answer;
        if (tempIndexes.isEmpty()) {
            return null;
        } else {
            answer = new ArrayList<NodeData>();
            for (int i = 0; i < tempIndexes.toArray().length; i++) {
                NodeData tempNode = currentGraph.getNode(tempIndexes.get(i));
                answer.add(tempNode);
            }

        }
        return answer;
    }

    @Override
    public NodeData center() {
        NodeData center = null; //Hold the node that is the center of the graph
        if (!isConnected()) {
            return null;
        } else {
            Double minDis = MAX_VALUE; //Holds the maximum of the shorterst paths of the center
            for (int i = 0; i < currentGraph.nodeSize(); i++) {
                double maxDis = -1; //Holds the longest path of the current node being inspected
                NodeData tempCenter = currentGraph.getNode(i);
//                for (int j = 0; j < currentGraph.nodeSize(); j++) {
//                    double tempMaxDis = shortestPathDist(i, j);
//                    if (tempMaxDis == 0) {
//                        continue;
//                    }
//                    maxDis = Math.max(maxDis, tempMaxDis);
//                }
                if (minDis >= maxDis) {
                    center = tempCenter;
                }
            }
        }
        return center;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        HashMap<Integer, NodeData>  nodes=new HashMap<>(); //create a hashmap that will hold the indexes and return the nodes
        int size=cities.size();
        List<NodeData> ans = new ArrayList();//the list that will be sent to the user
        double values[][]= new double[size][size];//a matrix with all the distances to sent into the algo
        for(int i=0; i<values.length;i++)//set all the matrix value to double's max value
        {
            for (int j=0;j<values.length;j++)
            {
                values[i][j]=MAX_VALUE;
            }
        }
        for(int i=0; i<size;i++)// this loop takes all the needed data from cities and puts it into the matrix
        {
            nodes.put(i,cities.get(i));
            int tempSource=cities.get(i).getKey();
            Iterator<EdgeData> it= currentGraph.edgeIter(tempSource);
            List<EdgeData> tempEdge=new ArrayList<EdgeData>();
            while (it.hasNext())
            {
                tempEdge.add(it.next());
            }
            for (int j=0; j<size; j++) {
                if (j==i) {
                    continue;
                }
                int tempDest=cities.get(j).getKey();
                for (int k=0; k<tempEdge.size();k++)
                {
                    int des=tempEdge.get(k).getDest();
                    if(des==tempDest)
                    {
                        double weight=tempEdge.get(k).getWeight();
                        tempEdge.remove(k);
                        values[i][j]=weight;
                        break;
                    }
                }
            }
        }
        TspDynamicProgrammingIterative algo=new TspDynamicProgrammingIterative(values);
        List<Integer>indexes=algo.getTour();
        for(int i=0;i<indexes.size();i++)//arranges the node list in the correct order
        {
            int tempIndex=indexes.get(i);
            ans.add(nodes.get(tempIndex));
        }
        return ans;
    }

    @Override
    public boolean save(String file) throws IOException, IOException {
        Gson gson = new Gson();
        ArrayList<JsonNode> nodeList = new ArrayList<>();
        for (int i=0; i<DWG.nodes.size();i++){
            Node node = (Node) DWG.nodes.get(i);
            Location p = (Location) node.getLocation();
            JsonNode jnode = new JsonNode(i,p);
            nodeList.add(jnode);
        }

        //Edges
        //...

        gson = new GsonBuilder().setPrettyPrinting().create();
        String strJson = gson.toJson(nodeList);


        try (FileWriter newfile = new FileWriter("G5.json")) {
                newfile.write(strJson);
            }
        catch (IOException e) {
            System.out.println("Error");
        }


        return false;
    }

    @Override
    public boolean load(String file) {
        return false;
    }

    private DijkstrasShortestPathAdjacencyListWithDHeap callingDijkstraAlgo() {
        DijkstrasShortestPathAdjacencyListWithDHeap algoGrapth=new DijkstrasShortestPathAdjacencyListWithDHeap(currentGraph.nodeSize());
        Iterator it= currentGraph.edgeIter();
        while(it.hasNext()) {
            ArrayList<Edge> a = (ArrayList) it.next();
            for (int i = 0; i < a.size(); i++) {
                Edge edge = a.get(i);
                algoGrapth.addEdge(edge.getSrc(), edge.getDest(), edge.getWeight());
            }
        }
        return algoGrapth;
    }
}
