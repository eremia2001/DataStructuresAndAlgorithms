import java.util.ArrayList;

public class Set { // Menge
    public int parent;
    public ArrayList<Node> nodeList; // Knotenmenge

    public Set(Node node) {
        nodeList = new ArrayList<>();
        nodeList.add(node);
        parent = node.name;
    }

    @Override
    public String toString() {
        return "{ " + this.nodeList + " }";
    }
}
