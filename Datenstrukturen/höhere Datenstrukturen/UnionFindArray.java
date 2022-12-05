import java.util.ArrayList;

public class UnionFindArray {
    public Graph graph;
    public ArrayList<Set> allSets;

    public UnionFindArray(Graph graph) {
        allSets = new ArrayList<>();
        this.graph = graph;
        makeSet();
    }

    public void makeSet() {

        for (int i = 0; i < graph.nodeQuant; i++) {
            allSets.add(new Set(graph.allNodes.get(i)));
        }
    }

    public int find(Node node) {
        for (int i = 0; i < allSets.size(); i++) {
            if (allSets.get(i).parent == node.set) {
                return i;
            }
        }

        return -111;
    }

    // (3,2), (4,1) -> (3,1),(4,1)
    public boolean union(Edge edge) {

        Node oldStartEdge = new Node(edge.startNode.name, edge.startNode.set);
        Node oldEndEdge = new Node(edge.endNode.name, edge.endNode.set);
        if (edge.startNode.set != edge.endNode.set) {
            ArrayList<Node> rootSet = allSets.get(find(edge.startNode)).nodeList;
            // moveSet ist die Menge die in eine andere verschoben wird
            ArrayList<Node> moveSet = allSets.get(find(edge.endNode)).nodeList;

            // Union by size
            if (rootSet.size() < moveSet.size()) {
                for (int i = 0; i < moveSet.size(); i++) {
                    moveSet.get(i).set = edge.startNode.set;

                }
                // konkatiere beide Mengen
                rootSet.addAll(moveSet);
                // löscht alte Menge
                allSets.remove(find(oldEndEdge));
            } else {
                for (int i = 0; i < rootSet.size(); i++) {
                    rootSet.get(i).set = edge.endNode.set;

                }
                moveSet.addAll(rootSet);
                allSets.remove(find(oldStartEdge));
            }

            return true;
        }

        return false;
    }

}
