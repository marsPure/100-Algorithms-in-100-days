//    red black search tree

// imagin each node having 2 values and 3 children, left for smaller than 2 keys, middle for in between and right for larger. 
// when inserting when we found a location for the value, we add it to the node ( 2 value 3 children become 3 value 4 children) 
// then break the 3 key node by passing middle value to the top node and creating 2 one key node. 

//                              ( 1  4  9) 

//                                   (4)
//                                 (1) (9)


//                                    (4 5)
//                                 (1 3) (9 10)
// add 6
//                                    (4 5)
//                                 (1 3) (6 9 10)
//
//                                    (4 5 9)
//                                 (1 3) (6) (10)

//                                        (5)
//                                    (4)    (9)
//                                 (1 3)   (6) (10)

// now in red black node instead of creating 3 key node we use two 1 key nodes.
//                   (  a       b   )                          
//                    //  ||       \\
//                  less  between  greater
//                than a  a and b   than b


//                          (b)
//          this is red->/     \
//                   (  a )       greater                   
//                    /  \      than b
//                  less  between  
//                than a  a and b   

public class BST<Key extends Comparable<Key>, Value>
{
  private static final boolean RED = true;
  private static final boolean BLACK = false;
  private Node root;
  // same as BST
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
      boolean color;
      public Node(Key key, Value val, boolean color)
      {
        this.key = key;
        this.val = val;
        this.color=color;
      }
   } 
  private boolean isRed(Node x)
  {
      if(x==null) return false;
      return x.color == Red;
  } 
  
  private Nod rotateLeft(Node h)
  {
      assert isRed(h.right);
      Node x = h.right;
      x.left= h;
      h.right=x.left;
      x.color=h.color;
      h.color=RED;
      return x;  
  }
  
   private Nod rotateRight(Node h)
  {
      assert isRed(h.left);
      Node x = h.left;
      x.right= h;
      h.left=x.right;
      x.color=h.color;
      h.color=RED;
      return x;  
  }
  private void flipColor(Node h)
  {
      assert !isRed(h);
      assert !isRed(h.left);
      assert isRed(h.right); 
      h.color = RED;
      h.left.color = BLACK;
      h.right.color = BLACK; 
  }
  private Node put(Node node,Key key, Value val)
  {
    if (node == null) reutrn new Node(key,val,RED);
    int cmp= key.compareTo(node.key);
    if(cmp>0) node.right=put(node.right,key,val);
    else if(cmp<0) node.left= put(node.left,key,val);
    else node.val=val;
    if(isRed(node.right) && !isRed(node.left))     node=rotateLeft(node);
    if(isRed(node.left) && !isRed(node.left.left)) node=rotateRight(node);
    if(isRed(node.left) && isRed(node.right))      flipColor(node);
    node.count = 1+ size(node.left) + size(node.right);
    return node;
  }
  
  
