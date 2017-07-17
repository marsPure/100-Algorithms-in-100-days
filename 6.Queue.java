
//linkedList implementation
public class Queue<Item> implements Iterable<Item>
{
  private Node last,first;
  
  public Iterator<Item> iterator()
  {
    return new ListIterator();
  }
  
  private class ListIterator implements Iterator<Item>
  {
    private Node current=first;
    public boolean hasNext() { return current != null;}
    public void remove() { /* throw unsupportedOperationException */}
    public Item next()
    {
      Item item = current.item;
      current= current.next;
      return item;
    }
  
  
  
  }
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
   return first==null; 
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

//array implementation
public class QueueOfString
{
  private int last=0,first=0,n=0;
  //   private boolean fc=false,lc=false;
  private String[] s=new String[1];
  
  pubilc void enqueue(String item)
  {
    if(n==s.length) this.resize(s.length*2);
    s[last++]=item;
    if(last>=s.length)
    {
      this.last= 0;
    //       fl=!fl;
    }
    n++;
  }
  
  public String dequeue()
  {
    if(n < s.length/4)   resize(s.length/2);
    String t= s[first];
    s[first++]=null;
    if(first>=s.length)
    {
      this.first= 0;
    //       fc=!fc;
    }
    n--
    return t;
  }
  
  public boolean isEmpty()
  {
//    return fc==fl && first==last; 
    return n==0;
  }
  
  private void resize(int capacity){
    String[] t=new String[capacity];
    int i = first , m=n;
    while(m-->0)
    {
      t[i]=s[i];
      i++;
      if(i>=s.length)
        i=0;
    }
    first = 0;
    last = i;
    
  }
}
