public class Node {
    public int name;
    public int set;

    public Node(int name) {
        this.name = name;
    }

    public Node(int name, int set) {
        this.name = name;
        this.set = set;
    }

    @Override
    public String toString() {

        return "( " + this.name + " ," + this.set + " )";
    }
}
