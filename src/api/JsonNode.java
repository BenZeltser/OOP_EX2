package api;

public class JsonNode {
    int id;
    String pos = "";

    public JsonNode(int id,GeoLocation loc)
    {
        this.id=id;
        pos+=String.valueOf(loc.x());
        pos+=",";
        pos+=String.valueOf(loc.y());
        pos+=",";
        pos+=String.valueOf(loc.z());

    }
}
