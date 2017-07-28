
// set of key value pairs 

// values are not null
// get return null if ket not present
// put overwrites old value with new value
public class SeperateChainingHashST<Key, Value>
{
  private int M=97;
  private Node[] st= new Node[M];
  
  private static class Node
  {
      private Object key;
      private Object val;
      private Node next;
      public Node(Object key, Object value , Node next)
      {
        this.key = key;
        this.val = val;
        this.next = next;
      }
  }
  
  public Value get(Key key)
  {
    int i = hash(key);
    for (Node x = st[i]; x != null; x=x.next)
      if(key.equals(x.key)) return (Value) x.val;
    return null;
  }
  
  public void put(Key key, Value val){
    int i = hash(key);
    for(Node x = st[i]; x != null; x=x.next)
      if(key.equals(x.key)){ x.val=val; return;}
    st[i] = new Node(key, val,st[i]);
  }
  
}
private int hash(Key key)
{ return (key.hashCode() &0x7fffffff )% M; } 
