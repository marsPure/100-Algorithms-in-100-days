// Binary search tree
// every node has a value
// a value in the node is larger than all keys in its left subtree.
//                        smaller than all keys in its right subtree.

public class BST<Key extends Comparable<Key>, Value>
{
  private Node root;
  
  private Node put(Node node,Key key, Value val)
  {
    if (node == null) reutrn new Node(key,val);
    int cmp= key.compareTo(node.key);
    if(cmp>0) node.right=put(node.right,key,val);
    else if(cmp<0) node.left= put(node.left,key,val);
    else node.val=val;
    return node;
  }
  
  public void put(Key key, Value val)
  {
    root = put(root, key, val);
  }
  
  public Value get(Key key)
  {
      Node node = root;
      while(node != null)
      {
        int cmp = key.compareTo(node.key);
        if(cmp>0) node=node.right;
        else if(cmp<0) node = node.left;
        else return node.val;
      }
      return null;
  }
 
    
    
      
  



   private class Node
   {
      private Key key;
      private Value val;
      private node left, right;
      public Node(Key key, Value val)
      {
        this.key = key;
        this.val = val;
      }
   }

}
