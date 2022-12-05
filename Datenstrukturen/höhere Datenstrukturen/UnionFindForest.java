import java.util.ArrayList;

class UnionFindForest {
    public Graph graph;

    public UnionFindForest(Graph graph) {
        this.graph = graph;
        makeSet();
    }

    public void makeSet() {
        for (int i = 0; i < graph.allNodes.size(); i++) {
            graph.allNodes.get(i).parent = graph.allNodes.get(i); // Setze den Vaterzeiger

        }
    }

    public Node find(Node treeNode) {

        Node returnElement = treeNode.parent;
        // Falls es auf sich zeigt, ist es der Repräsentant
        if (treeNode != treeNode.parent) {
            returnElement = find(treeNode.parent);
        }
        // System.out.println(returnElement);
        return returnElement;
    }

    public boolean union(Edge edge) {

        if (find(edge.startNode) != find(edge.endNode)) {
            link(find(edge.startNode), find(edge.endNode));
            return true;
        }
        return false;
    }

    public void link(Node startNode, Node endNode) {
        System.out.println("START NODE : " + startNode + "END NODE : " + endNode);
        System.out.println("Startnode depth :" + startNode.depth + "EndNodeDepth : " + endNode.depth);
        if (endNode.depth >= startNode.depth) {
            endNode.depth += startNode.depth;
            startNode.parent = endNode;
        } else {
            endNode.depth += startNode.depth;
            startNode.parent = endNode;
        }

    }
}