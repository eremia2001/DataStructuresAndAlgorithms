public class TreeNode {

    public int data;
    public TreeNode parent;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Knoten : " + data;
    }

}
