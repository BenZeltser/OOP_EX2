package api;
import java.util.ArrayList;

public class JsonWriter {
   private ArrayList<JsonNode> nodeList;
   private ArrayList<JsonEdge> edgeList;
   public JsonWriter(ArrayList<JsonNode> nodeList, ArrayList<JsonEdge> edgeList)
   {
       this.nodeList= nodeList;
       this.edgeList= edgeList;
   }
}
