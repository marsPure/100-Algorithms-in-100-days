//quick sort 
// have to shuffle first
// chose a partitioning position( here a[lo] ) 
// reduce right side pointer until find a value smaller than partiioning position
// increment left side pointer until find a value bigger than partitioning position
// swap left and right pointers value
// when j>i swap a[j] with a[lo]

public class QuickSort
{
  private static int partition(Comparable[] a, int lo, int hi)
  {
     int i=lo, j=hi+1;
    //partitioning element a[lo]
    while(true)
    {
      while(less(a[++i],a[lo]))
        if(i==hi) break;

      while(less(a[lo],a[--j]))
        if(j==lo) break;

      if(i>=j) break;
      exch(a, i, j);

    }
    exch(a,lo,j);
    return j;
  }
  
  public static void sort(Comparable[] a)
  {
    StdRandom.shuffle(a);
    sort(a,0,a.length-1);
  }
  
  private static void sort(Comparable[] a, int lo, int hi)
  {
    if(hi <= lo) return;
    int j = partition(a, lo, hi);
    sort(a, lo, j-1);
    sort(a, j+1, hi);
  }
}

// worst case is quadratic 1/2 N^2 that is why we have to shuffle it first.
// average case is 1.39 NlogN
// 38% more compares than mergesort, but because it doesn't copy files in and out of aux array it is faster.

//if there are lots of duplicate items it may become quadratic 

//quicksort it not stable

//ways to make it faster
//  use insertion sort for small subarrays (=10) or leave the smaller subarrays unsorted and run one insertion sort at the end
// sample 3 items and chose the medium as partitioning element


// given an array of N items, find the Kth largest

public static Comparable select(Comparable[] a, int k)
{
  StdRandom.shuffle(a);
  int lo=0, hi= a.length-1;
  while(hi>lo)
  {
    int j = partition(a,lo,hi);
    if (j>k) lo=j+1;
    else if (j<k) hi=j-1;
    else return a[k];
  }
  return a[k]
}
// on average it takes linear time (2N)


//3 way implementation of quicksort, moves the partitioning element and all of it's duplicates to it's place 
private static sort(Comparable[] a, int lo, int hi)
{
  if(lo>=hi) return;
  int lt=lo, gt=hi;
  Comparable v=a[lo];
  int i=lo;
  while(i>=gt)
  {
    int cmp= a[i].compareTo(v);
    if ( cmp<0 ) exch(a, lt++, i++);
    else if(cmp>0) exch(a, i, gt--);
    else i++;
  }
  sort(a, lo, lt-1);
  sort(a, gt+1,hi);
} 

