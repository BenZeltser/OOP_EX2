import api.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * This class is the main class for Ex2 - your implementation will be tested using this class.
 */
public class Ex2 {

    public static void main(String[] args) throws FileNotFoundException {

        DirectedWeightedGraph graph = getGrapg("G2.json");
        Grid grid = new Grid((DWG) graph);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Grid((DWG) graph));
        frame.setSize(900, 700);
        frame.setLocation(10, 10);
        frame.setVisible(true);
        Gui gui = new Gui();
        gui.build();


        }
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraph getGrapg(String json_file) throws FileNotFoundException {
        DirectedWeightedGraph ans = null;
        //create list of nodes
        ArrayList<NodeData> nodes = new ArrayList<>();
        //create list of edges
        ArrayList<EdgeData> edges = new ArrayList<>();

        //Get and parse Json file
        File input = new File("data/"+json_file);
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
            String[] POS = pos.split(",");
            double x = Double.parseDouble(POS[0]);
            double y = Double.parseDouble(POS[1]);
            double z = Double.parseDouble(POS[2]);
            //create node
            NodeData temp = new Node(ID);
            GeoLocation p = new Location(x, y, z);
            temp.setLocation(p);
            System.out.println("ID: " + temp.getKey());
            System.out.println("X: " + x);
            System.out.println("Y: " + y);
            System.out.println("Z: " + z);
            System.out.println("\n");
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
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraphAlgorithms getGrapgAlgo(String json_file) {
        DirectedWeightedGraphAlgorithms ans = null;
        // ****** Add your code here ******
        //
        // ********************************
        return ans;
    }
    /**
     * This static function will run your GUI using the json fime.
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     *
     */
    public static void runGUI(String json_file) {
        DirectedWeightedGraphAlgorithms alg = getGrapgAlgo(json_file);
        // ****** Add your code here ******
        //
        // ********************************
    }
}