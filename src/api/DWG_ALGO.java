package api;

import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
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
        //start the time calculation for the function
        long startTime=System.currentTimeMillis();

        //creating an empty DirectedWeightGraph instance
        DirectedWeightedGraph newGraph=new DWG();

        //a loop that iterates on each node in the graph and copies it to the new graph
        for (int i=0; i<currentGraph.nodeSize();i++)
        {
            //copy all the data from the current node and creates a deep copy of it
            NodeData thisNode=  currentGraph.getNode(i);
            double weight=thisNode.getWeight();
            GeoLocation loc=thisNode.getLocation();
            String info=thisNode.getInfo();
            int tag=thisNode.getTag();
            NodeData tempNode=new Node(i);
            tempNode.setInfo(info);
            tempNode.setLocation(loc);
            tempNode.setTag(tag);
            tempNode.setWeight(weight);
            newGraph.addNode(tempNode);

        }
        Iterator<EdgeData> it= currentGraph.edgeIter();
        while (it.hasNext())
        {
            EdgeData edge=it.next();
            int src=edge.getSrc(),dest=edge.getDest();
            double w=edge.getWeight();
            newGraph.connect(src,dest,w);
        }

        //end the time calculation for the function and returns the time it took the function to finish
        long endTime = System.currentTimeMillis();
        System.out.println("Finished in " + (endTime - startTime) + " milliseconds");

        return newGraph ;
    }

    @Override
    public boolean isConnected() {
        //start the time calculation for the function
        long startTime=System.currentTimeMillis();

        //calculate if the number of edges is equal to the max number of possible edges
        int edgeSize= currentGraph.edgeSize(),nodeSize=currentGraph.nodeSize();
        int sum=nodeSize*(nodeSize-1);
        if (sum==edgeSize) {

            //end the time calculation for the function and returns the time it took the function to finish
            long endTime = System.currentTimeMillis();

            System.out.println("Finished in " + (endTime - startTime) + " milliseconds");
            return true;
        }
        else {

            //end the time calculation for the function and returns the time it took the function to finish
            long endTime = System.currentTimeMillis();
            System.out.println("Finished in " + (endTime - startTime) + " milliseconds");
            return false;
        }
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        //start the time calculation for the function
        long startTime=System.currentTimeMillis();

        //runs the Dijksra algorithm and returns the shortest distance between "src" and "dest
        DijkstrasShortestPathAdjacencyListWithDHeap algoGraph=callingDijkstraAlgo();
        return algoGraph.dijkstra(src,dest);
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        //start the time calculation for the function
        long startTime=System.currentTimeMillis();

        //runs the the Dijkstra algorithm and returns a list of integers of the shortest path
        DijkstrasShortestPathAdjacencyListWithDHeap algoGraph = callingDijkstraAlgo();
        List<Integer> tempIndexes = algoGraph.reconstructPath(src, dest);
        List<NodeData> answer=new ArrayList<>();

        //checks if the list is empty, if not arrange the nodes in the indexes order
        if (tempIndexes.isEmpty()) {

            //end the time calculation for the function and returns the time it took the function to finish
            long endTime = System.currentTimeMillis();
            System.out.println("Finished in " + (endTime - startTime) + " milliseconds");
            return null;
        } else {
            for (int i = 0; i < tempIndexes.toArray().length; i++) {
                NodeData tempNode = currentGraph.getNode(tempIndexes.get(i));
                answer.add(tempNode);
            }

        }

        //end the time calculation for the function and returns the time it took the function to finish
        long endTime = System.currentTimeMillis();
        System.out.println("Finished in " + (endTime - startTime) + " milliseconds");
        return answer;
    }

    @Override
    public NodeData center() {
        //start the time calculation for the function
        long startTime=System.currentTimeMillis();

        //Hold the node that is the center of the graph
        NodeData center = null;

        //checks to see if the graph is connected, if not returns null
        if (!isConnected()) {
            return null;
        } else {

            //this value holds the maximum of the shortest paths of the center
            Double minDis = MAX_VALUE;

            //a loop that is running and checking each node to see who is the center of the graph
            for (int i = 0; i < currentGraph.nodeSize(); i++) {

                //this value holds the longest path of the current node being inspected
                double maxDis = -1;

                //this loop calculated the max distance of the shortest paths
                NodeData tempCenter = currentGraph.getNode(i);
                for (int j = 0; j < currentGraph.nodeSize(); j++) {
                    double tempMaxDis = shortestPathDist(i, j);
                    if (tempMaxDis == 0) {
                        continue;
                    }
                    maxDis = Math.max(maxDis, tempMaxDis);
                }

                //determine who should be the center node
                if (minDis > maxDis) {
                    center = tempCenter;
                }
            }
        }

        //end the time calculation for the function and returns the time it took the function to finish
        long endTime = System.currentTimeMillis();
        System.out.println("Finished in " + (endTime - startTime) + " milliseconds");

        return center;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        //start the time calculation for the function
        long startTime=System.currentTimeMillis();

        //create a hashmap that will hold the indexes and return the nodes
        HashMap<Integer, NodeData>  nodes=new HashMap<>();
        int size=cities.size();

        //the list that will be sent to the user
        List<NodeData> ans = new ArrayList();

        //a matrix with all the distances to sent into the algo
        double values[][]= new double[size][size];

        //set all the matrix value to double's max value
        for(int i=0; i<values.length;i++)
        {
            for (int j=0;j<values.length;j++)
            {
                values[i][j]=MAX_VALUE;
            }
        }

        // this loop takes all the needed data from cities and puts it into the matrix
        for(int i=0; i<size;i++)
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

        //send the matrix to the TSP algo class and returns a list of the indexes in order
        TspDynamicProgrammingIterative algo=new TspDynamicProgrammingIterative(values);
        List<Integer>indexes=algo.getTour();

        //arranges the node list in the correct order and returns the list to the caller
        for(int i=0;i<indexes.size();i++)
        {
            int tempIndex=indexes.get(i);
            ans.add(nodes.get(tempIndex));
        }

        //end the time calculation for the function and returns the time it took the function to finish
        long endTime = System.currentTimeMillis();
        System.out.println("Finished in " + (endTime - startTime) + " milliseconds");

        return ans;
    }

    @Override
    public boolean save(String file) throws IOException, IOException {
        //start the time calculation for the function
        long startTime=System.currentTimeMillis();

        Gson gson = new Gson();
        ArrayList<JsonNode> nodeList = new ArrayList<>();
        ArrayList<JsonEdge> edgeList= new ArrayList<>();

        //loading all the nodes with the relevant information to one arraylist
        for (int i=0; i<DWG.nodes.size();i++){
            Node node = (Node) DWG.nodes.get(i);
            Location p = (Location) node.getLocation();
            JsonNode jnode = new JsonNode(i,p);
            nodeList.add(jnode);
        }

        //load all the edges with the relevant information to one arraylist
        for (int i=0; i<DWG.adjList.size();i++)
        {
            NodeData node=DWG.nodes.get(i);
            ArrayList<EdgeData> tempEdgeList=DWG.adjList.get(node);
            for(int j=0; j<tempEdgeList.size();j++)
            {
                int source=tempEdgeList.get(j).getSrc(),dest=tempEdgeList.get(j).getDest();
                double weight=tempEdgeList.get(j).getWeight();
                JsonEdge jEdge=new JsonEdge(source,weight,dest);
                edgeList.add(jEdge);
            }
        }

        //creating a class that will hold both arrays in the correct order
        JsonWrite jsonWriter=new JsonWrite(edgeList,nodeList);

        //creating the json file with the right indentation in the correct places
        gson = new GsonBuilder().setPrettyPrinting().create();
        String strJson = gson.toJson(jsonWriter);



        //writing the json into a file
        try (FileWriter newfile = new FileWriter("G5.json")) {
                newfile.write(strJson);
            }
        catch (IOException e) {
            System.out.println("Error");

            //end the time calculation for the function and returns the time it took the function to finish
            long endTime = System.currentTimeMillis();
            System.out.println("Finished in " + (endTime - startTime) + " milliseconds");

            return false;
        }

        //end the time calculation for the function and returns the time it took the function to finish
        long endTime = System.currentTimeMillis();
        System.out.println("Finished in " + (endTime - startTime) + " milliseconds");

        return true;
    }

    @Override
    public boolean load(String file) throws IOException {
        //start the time calculation for the function
        long startTime=System.currentTimeMillis();

        //creating a DirectedWeightGraph instance
        DirectedWeightedGraph DWG=DWG_ALGO.loadGraph(file);

        //checking if the graph was created, if it was created, initializing it to the algo
        if (DWG==null)
        {

            //end the time calculation for the function and returns the time it took the function to finish
            long endTime = System.currentTimeMillis();
            System.out.println("Finished in " + (endTime - startTime) + " milliseconds");

            return false;
        }
        else {

            //end the time calculation for the function and returns the time it took the function to finish
            long endTime = System.currentTimeMillis();
            System.out.println("Finished in " + (endTime - startTime) + " milliseconds");

            init(DWG);
            return true;
        }
    }
    //this function creates an instance for the DijkstraAlgo and send it back finished to the caller
    private DijkstrasShortestPathAdjacencyListWithDHeap callingDijkstraAlgo() {
        DijkstrasShortestPathAdjacencyListWithDHeap algoGraph=new DijkstrasShortestPathAdjacencyListWithDHeap(currentGraph.nodeSize());
        Iterator it= currentGraph.edgeIter();
        while(it.hasNext()) {
            ArrayList<Edge> a = (ArrayList) it.next();
            for (int i = 0; i < a.size(); i++) {
                Edge edge = a.get(i);
                algoGraph.addEdge(edge.getSrc(), edge.getDest(), edge.getWeight());
            }
        }
        return algoGraph;
    }
    //this function creates a DirectedWeightGraph instance from a json file
    private static DirectedWeightedGraph loadGraph(String json_file) throws IOException {
        DirectedWeightedGraph ans = null;
        //create list of nodes
        ArrayList<NodeData> nodes = new ArrayList<>();
        //create list of edges
        ArrayList<EdgeData> edges = new ArrayList<>();

        //Get and parse Json file
        File input = new File("data/"+json_file); //e.g G1.json
        JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
        JsonObject fileObject = fileElement.getAsJsonObject();

        //Iterate through Json file of NODES
        JsonArray nodesJ = fileObject.get("Nodes").getAsJsonArray();
        for (JsonElement nodeElement : nodesJ) {
            JsonObject nodeJsonObject = nodeElement.getAsJsonObject();
            String pos = nodeJsonObject.get("pos").getAsString();
            String id = nodeJsonObject.get("id").getAsString();

            //add Nodes from Json to DWG
            int ID = Integer.parseInt(id);
            String[] POS = pos.split(","); //x,y,z
            double x = Double.parseDouble(POS[0]);
            double y = Double.parseDouble(POS[1]);
            double z = Double.parseDouble(POS[2]);
            //create node
            NodeData temp = new Node(ID);
            GeoLocation p = new Location(x, y, z);
            temp.setLocation(p);
//            System.out.println("ID: " + temp.getKey());
//            System.out.println("X: " + x);
//            System.out.println("Y: " + y);
//            System.out.println("Z: " + z);
//            System.out.println("\n");
            nodes.add(temp);
        }
        //Iterate through Json Edges
        JsonArray edgesJ = fileObject.get("Edges").getAsJsonArray();
        for (JsonElement edgeElement : edgesJ) {
            JsonObject edgeJsonObject = edgeElement.getAsJsonObject();
            String src = edgeJsonObject.get("src").getAsString();
            String w = edgeJsonObject.get("w").getAsString();
            String dest = edgeJsonObject.get("dest").getAsString();

            int SRC = Integer.parseInt(src);
            double W = Double.parseDouble(w);
            int DEST = Integer.parseInt(dest);

            Edge temp = new Edge(W);
            temp.setSrc(SRC);
            temp.setDest(DEST);
            //add edges from Json to list
            edges.add((EdgeData) temp);


        }
        ans = new DWG(nodes,edges);
        return ans; }
}
