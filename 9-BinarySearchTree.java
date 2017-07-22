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
    node.count = 1+ size(node.left) + size(node.right);
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
      private int count;
      public Node(Key key, Value val)
      {
        this.key = key;
        this.val = val;
      }
   }
   
   public Key floor(Key key)
   {
      Node node = floor(root,key);
      if(node==null) return null;
      return node.key;
   }
   public Key floor(Node node,Key key)
   {
        if(node = null) return null;
        int comp = key.compareTo(node.key);

        if(comp == 0) return node.key;

        if(comp < 0) return floor(node.left,key);
        
        Node t = floor(node.right,key);
        if(t != null) return t;
        else          return node;
   }
   
   public int size()
   { return size(root); }
   
   private int size(Node x)
   {
      if(x=null) return 0;
      return x.count;
   }
   
  public int rank(Key key)
  {
    
  }
  private int rank(Node node , Key key)
  {
    if(x==null) return 0;
    int comp = key.compareTo(node.key);
    if(comp <0) return rank(node.left,key);
    if(comp >0) return 1 + size(node.left) + rank(node.right,key);
    else return size(x.left);
  }
  
  public Iterable<Key> keys()
  {
      Queue<Key> q = new Queue<Key>();
      inorder(root,q);
      return q;
  }
  private void inorder(Node node, Queue<Key> q)
  {
      if(node == null) return;
      inorder(node.left,q);
      q.enqueue(node.key);
      inorder(node.right,q);
  }
  
  public delete(Key key)
  {
     delete(root,key);
  }
  
  private Node deleteMin(Node x)
  {
      if(x.left == null) return x.right;
      x.left = deleteMin(x.left);
      x.count = 1+ size(x.left) + size(x.right);
      return x;
  }
  
  private Noded delete(Node x, Key key)
  {
      if(x == null) return null;
      int comp = key.compareTo(x.key);
      if(x<0) x.left= delete(x.left,key);
      else if(x>0) x.right=delete(x.right,key);
      else
      {
        if(x.left == null) return x.right;
        if(x.right == null) return x.left;

        Node t=x;
        x = min(t.right);
        x.right = deleteMin(t.right);
        x.left = t.left;
      }
      x.count = size(x.left) + size(x.right) +1;
      return x;
      
      
      }
      
  
  }
}

