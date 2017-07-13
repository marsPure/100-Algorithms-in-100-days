// for making sort sortable for different data types. we are going to use function callback object's compareTo() method when needed.
// for that we are using comparable interface 

public interface Comparable<item>
{
  public int compareTo(Item that);
}

// compareTo method should impliment this rules.
// Total Order:
//  1- Antisymmetry : if v<=w and w<=v then v==w
//  2- Transitivity : if v<=w and w<=x then v<=x
//  3- Totality : either v<=w or w<=v or both

// v.compareTo(w)
// compareTo return value -> 
// v<w = -1 ---- v==w  = 0 ----- v>w = +1

// to make the sort codes portable to other languages we use below static methods in our sorts

private static boolean less(Comparable v, Comparable w)
{ return v.compareTo(w)<0; }

private static void exch(Comparable[] a, int i, int j)
{
  Comparable swap= a[i];
  a[i] = a[j];
  a[j] = swap;
}

private static boolean isSorted(Comparable[] a)
{
  for (int i = 1; i<a.length ; i++)
    if (less(a[i], a[i-1]))
      return false;
  return true;
}

// ----------------------------------------------------------------

// Selection Sort
 
public class SelectionSort
{
  public Comparable[] sort(Comparable[] a)
  {
    Comparable min;
    for(int i=0 ; i<a.length ; i++)
    {
      min =  i;
      for(int j=i+1; j<a.length ; j++)
      {
        if(less(a[j],a[min]))
           min=j;
      }
      exch(a, i, min);
    }
    return a;
  }
}

// N^2/2 compares and N exchanges

//-----------

// Insertion Sort

public class InsertionSort
{
  public Comparable[] sort(Comparable[] a)
  {
    int j;
    for(int i=1;i<a.length ; i++)
    {
      j=i;
      while(less(a[j],a[j-1]) && j>1)
      {
        exch(a, j, --j);
      }
    }
    return a;
  }
}
// worst case is for decending sorted array it has n^2/2 comparison n^2/2 swaps

//-------------------------
// Shellsort
Public class ShellSort
{
  pubilc static void sort(Comparable[] a)
  {
    int h=1;
    int n = a.length;
    while(h<n/3)
      h=3*h+1;
    while(h>=1)
    {
      for(int i=h;i<a.length ; i++)
      {
        j=i;
        while(less(a[j],a[j-1]) && j>1)
        {
          
          exch(a, j, j-h);
          j -=j;
        }
      }
      h=h/3;
    }
  }
}

//----------------------------------------
//shuffling
// swap i with a randomly selected object in the left

public static void shuffle(Comparable[] a)
{
  for (int i=1; i<n ; i++)
   swap(a, i, StdRandom.uniform(i+1); // .uniform(i+1) between 0 and i
    
}

 
  
  








             
            
                   
