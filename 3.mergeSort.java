
// Divide and conqure ! 

public class MergeSort
{
  public static void sort(Comparable[] a) //mine
  {
    if(a.length<=1) return a;
    comparable[] fh= sort(Arrays.copyOfRange(a,0,a.lenght/2));
    comparable[] sh= sort(Arrays.copyOfRange(a,a.length/2,a.lenght));
    int ifh=0, ish=0;
    for(int i=0; i < a.length; i++)
    {
      if(ifh>=fh.length)        a[i]=sh[ish++];
      if(ish>=sh.length)        a[i]=fh[ifh++];
      if(less(fh[ifh],sh[ish])) a[i]=fh[ifh++];
      else                      a[i]=sh[ish++];
    }
    return a;
  }
  
  public static merge(Comparable[] a)
  {
    
}
  
  
  public class Merge {

    // This class should not be instantiated.
    private Merge() { }

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // copy to aux[]
        int z=0;
        for (int k = lo; k <= mid-lo; k++) {
            aux[z++]= a[k]; 
        }

        // merge back to a[]
        int i = 0, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid-lo)              a[k] = a[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = a[j++];
            else                           a[k] = aux[i++];
        }

        // postcondition: a[lo .. hi] is sorted
        assert isSorted(a, lo, hi);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
    }

