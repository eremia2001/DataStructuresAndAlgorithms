public class Edge implements Comparable<Edge> {
    public int startNode;
    public int endNode;
    public int cost;

    public Edge(int startNode, int endNode, int cost) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.cost = cost;
    }

    @Override
    public String toString() {

        return "(Start : " + startNode + " End : " + endNode + " Cost : " + cost + " )";
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