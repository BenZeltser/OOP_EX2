package api;

public class JsonNode {
    int key;
    GeoLocation loc;

    public JsonNode(int key,GeoLocation loc)
    {
        this.key=key;
        this.loc=loc;
    }
}
