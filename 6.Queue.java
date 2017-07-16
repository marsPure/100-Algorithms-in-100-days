
//linkedList implementation
public class QueueOfString
{
  private Node last,first;
  
  pubilc void enqueue(String item)
  {
    Node oldLast=last;
    last = new Node(item,null);
    if(first==null) first = last;
    else oldLast.next=last;
  }
  
  public String dequeue()
  {
    if(first == null) return null;
    Node t = first;
    if(t.next == null) last=null;
    first = t.next;
    return t.item;
  }
  
  public boolean isEmpty()
  {
   return last==null; 
  }
    
  private class Node
  {
    String item;
    Node next;
    private Node( String item, Node next)
    {
      this.item=item;
      this.next=next;
    }
  }
}
