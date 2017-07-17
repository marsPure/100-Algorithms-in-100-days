//binary Heap is a good solution to priority queue (remove largest or smaller item, instead of FIFO or LILO)
// parent key no smaller than children't keys

// array represendation: 
//    indices start at 1
//    take nodes in Level order
//    no explicit links needed
//              1
//            /    \
//           2       3
//         /  \     /  \
//        4    5   6    7

 



public class BinaryHeap<Key extends Comparable<Key>>
{
  int n=0;
  Key[] pq;
  public BinaryHeap(int n)
  {
    pq= (Key[]) new Comparable[n+1];
  }
  public void insert(Key x)
  {
    pq[++n]=x;
    swim(n);
  }
  private void swim(int k)
  {
    while(less(k/2,k))
    {
      exch(k,k/2);
      k=k/2;
    }
  }
  private void sink(int k)
  {
     while(k>=n)
     {
      int j = 2*k;
      if(j<n && less(j,j+1)) j++;
      if(less(k,j)) exch(k,j);
      k=j;
     }
  }
  public Key delMax()
  {
    Key max = pq[1];
    exch(n--,1);
    sink(1);
    pq[n+1]=null;
    return max;
  }
  boolean isEmpty()
  {
    return n==0;
  }
  private boolean less(int i, int j)
  { 
    retrn pq[i].compareTo(pq[j])<0; 
  }
  peivate void exch(int i, int j)
  {
    Key t= pq[i]; pq[i]=pq[j]; pq[j]=t; 
  }
 }
  
