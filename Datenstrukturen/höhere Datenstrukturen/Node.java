
public class Node {
    public int name;
    public int set;
    public Node parent; // für die Baumstruktur
    public int depth;

    public Node(int name) {
        this.name = name;
        this.depth = 1;
    }

    public Node(int name, int set) {
        this.name = name;
        this.set = set;
        this.depth = 1;

    }

    @Override
    public String toString() {

        return "( " + this.name + ", " + this.depth + " )";
    }
}
