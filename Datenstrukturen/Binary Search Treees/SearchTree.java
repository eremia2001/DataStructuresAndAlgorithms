
public class SearchTree< KeyType extends Comparable<KeyType>,DataType>
{

	//public DataType isMember( KeyType k );
	//public boolean remove ( KeyType k );
	//. . .
	private TreeNode<KeyType, DataType> root;


    
    public static void main(String[] args) {
        SearchTree<Integer, String> tree = new SearchTree<>();
        
        System.out.println(tree.insert("Hallo11", 15));
        System.out.println(tree.insert("Hallo22", 5));
        System.out.println(tree.insert("Hallo22", 3));
        System.out.println(tree.insert("Hallo33", 12)); 
        System.out.println(tree.insert("Hallo44", 10));
        System.out.println(tree.insert("Hallo44", 13));
        System.out.println(tree.insert("Hallo44", 6));
        System.out.println(tree.insert("Hallo44", 7));
        
        System.out.println("BEFORE: ");
        tree.traverse(tree.root);
        
        tree.delete(10);
        
        System.out.println("AFTER : ");
        tree.traverse(tree.root);
        
        
    }
    
    // %%%%%%%%%%%%%%%%%%%%% EINFÜGE %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 
  // Einfügen in Suchbäumen
    public boolean insert ( DataType d, KeyType k )
    {
      // Erstellen einen neuen Knotens
      TreeNode<KeyType, DataType> toInsertNode = new TreeNode<KeyType,DataType>(k, d);;
      // Falls Baum leer ist :
      if(root == null)
      {
          root = toInsertNode; 
          return true;
      }
      // Wir merken uns den "Parent"-Node und den current um travesieren zu können
      TreeNode<KeyType, DataType> parent = null;
      TreeNode<KeyType, DataType> currentNode = root;
      // Wir Travesieren bis wir den richtigen Platz haben
      while(currentNode != null)
      {
          parent = currentNode;
          if(k.compareTo(currentNode.key) == 0) return false;
          if(k.compareTo(currentNode.key) < 0)
          {
              currentNode = currentNode.leftNode;
          }
          else
          {
              currentNode = currentNode.rightNode;
          }
      }
      toInsertNode.parent = parent;
      // Nun gucken wir auf welche Seite es kommen muss
      if(k.compareTo(parent.key) > 0)
      {
          parent.rightNode = toInsertNode;
      }
      else
      {
          parent.leftNode = toInsertNode;
      }
      return true;
  }

  // %%%%%%%%%%%%%%%%%%%%% SUCHEN %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 

  // Suchen in Suchbäumen
    public TreeNode<KeyType, DataType> search( KeyType k )
    {
      TreeNode<KeyType, DataType> currentNode =root;
      while(currentNode != null)
      {
          if(k.compareTo(currentNode.key) == 0) return currentNode;
          if(k.compareTo(currentNode.key) < 0)
          {
              currentNode = currentNode.leftNode;
          }
          else
          {
              currentNode = currentNode.rightNode;
          }
      }
      return null ;
  }

// %%%%%%%%%%%%%%%%%%%%% TRAVESIEREN %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 
  // Traversiert durch den ganzen Baum und gibt es in der Konsole aus
    public void traverseInOrder(TreeNode<KeyType, DataType> node)
    {
       if(node != null)
      {
          traverseInOrder(node.leftNode);
          System.out.println(node.key);
          traverseInOrder(node.rightNode);
      }    
    }

    public void traverse(TreeNode<KeyType, DataType> node)
    {
      traverseInOrder(node);
    }
      // %%%%%%%%%%%%%%%%%%%%% ISMEMBER %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 

      public boolean isMember(KeyType k)
      {
        if(search(k) == null ) return false;
        else
        {
            return true;
        }
      }

      public boolean delete(KeyType k)
      {

        TreeNode<KeyType, DataType> toDeleteNode = search(k);

        // 1.Fall : Knoten hat keine Kinder -> ist ein Blatt
        if(toDeleteNode.leftNode == null && toDeleteNode.rightNode == null)
        {

            if(isRightNode(toDeleteNode))
            {
                toDeleteNode.parent.rightNode = null;
                return true;
            }
            else
            {
                toDeleteNode.parent.leftNode = null;
                return true;
            }
        }
        // 2. Fall : Knoten hat 1 Kind
        if(toDeleteNode.leftNode != null ^ toDeleteNode.rightNode != null)
        {
            if(toDeleteNode.leftNode != null)
            {
                toDeleteNode.parent.leftNode=toDeleteNode.leftNode;
                return true;
            }
            if(toDeleteNode.rightNode != null)
            {
                toDeleteNode.parent.rightNode=toDeleteNode.rightNode;
                return true;
            }
        }
            // 3.Fall : Knoten hat 3 Kinder 
            // vertausche successor/predecessor mit dem zu löschenden Element
            // successor = das kleinste Element im rechten Teilbaum
            // predecessor = das größte Element im linken Teilbaum
            else
            {
                TreeNode<KeyType, DataType> predecessor =  getMaxNode(toDeleteNode.leftNode);        
                System.out.println("MAX KEY :"+ predecessor.key);       
                toDeleteNode.key = predecessor.key;
                toDeleteNode.data = predecessor.data;
                
                // predecesssor löschen -> wie im Fall 1. oder hat höchsten ein linkes Kind
                if(predecessor.leftNode == null )
                {
                    predecessor.parent.leftNode = null;
                    return true;
                }
                // Falls es ein linkes Kind hat
                if(predecessor.leftNode != null)
                {
                    predecessor.parent.leftNode=predecessor.leftNode;
                return true;
                }



                return true;
            }
        
        return false;
      }

// %%%%%%%%%%%%%%%%%%%%%%%%%%%%% isRightNode %%%%%%%%%%%%%%%%%%%%%%%%
// überprüft ob er Knote, der Rchte Knoten ist vom Parent aus 
      public boolean isRightNode(TreeNode<KeyType, DataType> node)
      {

        if(node.key.compareTo(node.parent.key) < 0)
        {
            return false;
        }
        else
        {
            return true;
        }
      }

      // Gibt das größte Element in dem jeweiligen Teilbaum zurück
      public TreeNode<KeyType, DataType> getMaxNode(TreeNode<KeyType, DataType> rootNode)
      {
        if(rootNode == null) return null;
        else
        {
            TreeNode<KeyType, DataType> currentNode = rootNode;
            while(currentNode.rightNode != null)
            {
                currentNode = currentNode.rightNode;
            }
            return currentNode;
        }
      }

}