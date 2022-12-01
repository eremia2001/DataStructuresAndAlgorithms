import java.util.ArrayList;

public class Graph {
    int nodeQuant;
    public ArrayList<Edge> allEdges;

    public Graph() {
        this.nodeQuant = 0;
        this.allEdges = new ArrayList<>();
    }

    public Graph(int nodeQuant, Edge edge) {
        this.nodeQuant = nodeQuant;
        this.allEdges.add(edge);
    }
}