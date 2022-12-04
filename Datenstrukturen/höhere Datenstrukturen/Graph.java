import java.util.ArrayList;

public class Graph {
    public int nodeQuant; // Anzahl
    public ArrayList<Edge> allEdges; // alle Kanten
    public ArrayList<Node> allNodes; // alle Knoten

    public Graph(int nodeQuant) {
        this.nodeQuant = nodeQuant;
        this.allEdges = new ArrayList<>();
        this.allNodes = new ArrayList<>();
    }

    public void initNodes(Graph graph) {
        for (int i = 0; i < graph.nodeQuant; i++) {
            graph.allNodes.add(new Node(i, i)); // es gibt genauso viele Mengen wie Knoten am anfang
        }
    }

    public Node findNode(int name) {
        for (int i = 0; i < allNodes.size(); i++) {
            if (name == allNodes.get(i).name) {
                return allNodes.get(i);
            }
        }

        return (new Node(name));
    }

}