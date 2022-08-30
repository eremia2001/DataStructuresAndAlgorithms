public class TreeNode<KeyType extends Comparable<KeyType>, DataType>
{
    public KeyType key;
    public DataType data;
    public TreeNode<KeyType,DataType> parent;
    public TreeNode<KeyType, DataType> leftNode;
    public TreeNode<KeyType, DataType> rightNode;

// Konstruktor
public TreeNode(KeyType k, DataType d)
{
    key = k;
    data = d ;
    leftNode = rightNode;
    parent = null;
}
}