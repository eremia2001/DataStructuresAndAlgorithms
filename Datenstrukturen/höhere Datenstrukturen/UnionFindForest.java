import java.util.ArrayList;

class UnionFindForest {
    public Graph graph;
    public ArrayList<TreeSet> allTreeSets;

    public UnionFindForest(Graph graph) {
        this.graph = graph;
        this.allTreeSets = new ArrayList<>();
        makeSet();
    }

    public void makeSet() {
        for (int i = 0; i < graph.allNodes.size(); i++) {
            TreeNode newTreeNode = new TreeNode(i);
            TreeSet newTreeSet = new TreeSet(newTreeNode);
            newTreeSet.root = newTreeNode;
            newTreeNode.parent = newTreeSet.root;
            allTreeSets.add(newTreeSet);
        }
    }

    public TreeNode find(TreeNode treeNode) {

        TreeNode returnElement = treeNode.parent;
        // Falls es auf sich zeigt, ist es der Repräsentant
        if (treeNode != treeNode.parent) {
            returnElement = find(treeNode.parent);
        }
        System.out.println(returnElement);
        return returnElement;
    }

    public boolean union(Edge edge) {
        find(edge.startNode);
        return false;
    }
}