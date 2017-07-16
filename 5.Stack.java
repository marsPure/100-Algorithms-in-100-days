// given an array of N items, find the Kth largest

//linked list implementation
public class StackOfString
{
  private Node first= null;
  void push(String item)
  {
    first= new Node(item,first);
  }
  
  String pop()
  {
   	Node f = this.first;
        if (f==null) return null;
        if (f.next==null) this.first=null;
        else this.first = f.next;
        return f.item;
  }
    
  boolean isEmpty()
  {
    return this.first==null;
  }
    
  private int size
  {
		
  }
  
  private class Node
  {
    String item;
    Node next;
    private Node(String item, Node next)
    {
      this.item=item;
      this.next=next;
    }
  }
}


// array implementation
public class StackOfString
{
	
  private String[] s;
	private int i=0;
	public StackOfString(int n)
	{
                s=new String[n];
	}
	public StackOfStringI()
	{
		s= new String[1];	
	}
  void push(String item)
  {
		if(i==s.length) resize(2 * s.length);
    s[i++]=item;
  }
  
  String pop()
  {
  		String item= s[--i];
			s[i]=null;
			return item;
	}
    
  boolean isEmpty()
  {
    return i==0;
  }
    
	private void resize(int n)  
	{
        String[] temp= new String[n];
        for(int i=0;i<s.length;i++)
                temp[i]=s[i];
        s=temp;
	}
 
}
