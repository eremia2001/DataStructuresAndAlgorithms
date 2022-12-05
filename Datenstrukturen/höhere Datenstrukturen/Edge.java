
public class Edge implements Comparable<Edge> {
    public Node startNode;
    public Node endNode;
    public int cost;

    public Edge(Node startNode, Node endNode, int cost) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.cost = cost;
    }

    @Override
    public String toString() {

        return "(" + startNode + " ," + endNode + " ," + cost + " )";
    }

    @Override
    public int compareTo(Edge o) {
        if (this.cost == o.cost) {
            return 0;
        }

        else if (this.cost > o.cost) {
            return 1;
        } else {
            return -1;
        }
    }

}