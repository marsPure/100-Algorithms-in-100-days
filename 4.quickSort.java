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



