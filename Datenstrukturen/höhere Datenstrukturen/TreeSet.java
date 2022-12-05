public class TreeSet {
    public TreeNode root;
    public int size;

    public TreeSet(TreeNode root) {
        this.root = root;
        this.size = 1;
    }

    @Override
    public String toString() {
        return "" + root;
    }
}
