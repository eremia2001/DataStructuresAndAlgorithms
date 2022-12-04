import java.util.ArrayList;

public class Set {
    public int parent;
    ArrayList<Node> nodeList;

    public Set(Node node) {
        nodeList = new ArrayList<>();
        nodeList.add(node);
    }

    @Override
    public String toString() {
        return "Set : " + this.parent;
    }
}
