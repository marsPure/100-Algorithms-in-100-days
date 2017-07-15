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
