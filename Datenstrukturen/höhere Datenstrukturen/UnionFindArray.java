import java.util.ArrayList;
import java.util.*;

public class UnionFindArray {
    public ArrayList<Set> setList;
    public Graph graph;

    public UnionFindArray(Graph graph) {
        this.graph = graph;
        setList = new ArrayList<>();
        makeSet();
    }

    public void makeSet() {

        for (int i = 0; i < graph.nodeQuant; i++) {
            setList.add(new Set(graph.allNodes.get(i)));
        }

    }

    public int find(Node node) {
        for (int i = 0; i < setList.size(); i++) {
            if (setList.get(i).nodeList.contains(node)) {
                // System.out.println("Node :" + node.set);
                return i;
            }

        }

        return -100;

    }

    public boolean union(Edge edge) {
        // alte Menge wird nicht gelöscht bei Union
        // System.out.println("THIS EDGE :" + edge);
        // System.out.println("Edge: " + edge);
        // System.out.println("FIND 1: " + find(edge.startNode));
        // System.out.println("FIND 2: " + find(edge.endNode));

        Edge oldEdge = edge;
        int indexStart = find(edge.startNode);
        int indexEnd = find(edge.endNode);
        if (find(edge.startNode) != find(edge.endNode)) {
            for (int i = 0; i < setList.get(indexEnd).nodeList.size(); i++) {
                setList.get(indexStart).nodeList.add(setList.get(indexEnd).nodeList.get(i));
            }
            deleteOldSet(oldEdge);
            return true;
        }

        return false;
    }

    public void deleteOldSet(Edge edge) {
        setList.remove(find(edge.endNode));
    }

}
