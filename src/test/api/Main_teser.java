package test.api;

import api.GeoLocation;
import api.Location;
import api.Node;
import api.NodeData;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalTime;

class tester {
    public static void main(String[] args) throws FileNotFoundException {
        int startTime = LocalTime.now().getNano();
        File input = new File("data/G1.json");
        JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
        JsonObject fileObject = fileElement.getAsJsonObject();

        //Iterate through Json file of NODES
        JsonArray nodesJ = fileObject.get("Nodes").getAsJsonArray();
        for (JsonElement nodeElement : nodesJ) {
            JsonObject nodeJsonObject = nodeElement.getAsJsonObject();
            String pos = nodeJsonObject.get("pos").getAsString();
            String id = nodeJsonObject.get("id").getAsString();
            System.out.println(pos);


            //add from Json to DWG
            int ID = Integer.parseInt(id);
            String[] POS = pos.split(",");
            double x = Double.parseDouble(POS[0]);
            double y = Double.parseDouble(POS[1]);
            double z = Double.parseDouble(POS[2]);
            //create node
            NodeData temp = new Node(ID);
            GeoLocation p = new Location(x, y, z);
            temp.setLocation(p);
            System.out.println("ID:" + temp.getKey());
            System.out.println("X:" + x);
            System.out.println("Y: " + y);
            System.out.println("Z: " + z);
            System.out.println("\n");

        }
        System.out.println("Test passed Successfully!");
        System.out.println("File used: G1.json" );
        System.out.println("RunTime (NanoSeconds): "+(LocalTime.now().getNano()-startTime));
    }
}

