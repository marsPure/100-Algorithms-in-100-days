// union: connect 2 nodes
// connected : determine if 2 nodes are connected or not

//assumtions : 
//  reflexive : p is connected to p
//  symmetric : if p is connected to q, q is connected to p.
//  transitive: if p is connected to q and q is connected to r, then p is connected to r.



//file sample 
/*
tinyUF.text
10
4 3
3 8
6 5
9 4
2 1
8 9
5 0
7 2
6 1
1 0
6 7

*/

public static void main (String[] args){
  int n = StdIn.readInt();
  UF uf = new UF(n);
  while (!StdIn.isEmpty()){
    int p = StdIn.readInt();
    int q = StdIn.readInt();
    if (!uf.connected(p,q))
    {
      uf.union(p,q);
      stdOut.println(p+" "+q);
    }
 }
        
}

        
  // QUICK FIND
  //     0  1  2  3  4  5  6  7  8  9   
  //   [ 0, 1, 1, 8, 8, 0, 0, 1, 8, 8]
  // 0,5,6 are connected - 1,2,7 are connected - 3,4,8,9 are connected
        
   
        public class QuickFindUF
        {
          private int[] id;
          public QuickFindUF(int n)
          {
            id= new int[n];
            for (int i=0;i<n;i++)
              id[i]=i;
          }
          public bool connected(int p,int q)
          {
            return id[p]==id[q];
          }
          public void union(int p,int q)
          {
            int pid=id[p];
            int qid=id[q];
            for(int i=0; i<id.length; i++)
              if(id[i]==pid)
                id[i]=qid
          }
          

 // Quick Union
//     0  1  2  3  4  5  6  7  8  9   
//   [ 0, 1, 9, 4, 9, 6, 6, 7, 8, 9]  

// id[i] is parent of i 
// i is root if id[i] == i

          public class QuickUnionUF
          {
            private int[] id;
            public QuickUnionUF(int n)
            {
              id= new int[n];
              for (int i=0; i<n ; i++)
                id[i]=i;
            }
            public bool connected(int p , int q)
            {
              
              return root(p) == root(q);
            }
            public void union(int p, int q)
            {
              p = root(p);
              q = root(q);
              id[p]=q;
            }
            private int root(int p)
            {
              while (id[p]!=p)
                p=id[p];
              return p;
            }
          }
                
            
   // Quick-Union improvements
   // just make sure the tree is more balanced and flatten it when it is accessed.
            public class QuickUnionFastUF
            {
              private int[] id;
              public QuickUnionUF(int n)
              {
                id= new int[n];
                for (int i=0; i<n ; i++)
                  id[i]=i;
              }
            
              public bool connected(int p , int q)
              {
                return root(p) == root(q);
              }
              public void union(int p, int q)
              {
                Root rp = root(p);
                Root rq = root(q);
                if(rp.i>rq.i) id[rq.value]=rp.value;
                else id[rp.value]=rq.value;
              }
              private Root root(int p)
              {
                int i=0;
                while (id[p]!=p)
                {
                  id[p]=id[id[p]];//to flatten the tree while we are accessing it
                  p=id[p];
                  i++;
                }
                return new Root(p,i);
              }
                static class Root()
              {
                int value;
                int i;
                Root(int value, int i)
                {
                  this.value=value;
                  this.i=i;
                }
              }
            }
              
          
          
          
          // Sample problem
          
          /*
          Social network connectivity. Given a social network containing n members and a log file containing m timestamps at which times 
          pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected
          (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that 
          friendship is an equivalence relation. The running time of your algorithm should be mlogn or better and use extra space proportional 
          to n.
          */
          
          public class Connectivity
          {
            QuickUnionFastUF uf;
            int cnt=0;
            public int shortest(int n, int[] m , int[] p, int[] q)
            {
              uf = new QuickUnionFastUF(n);
              for(int i; i<m.length; i++)
              {
                if(!uf.connected (p,q)){
                  uf.union(p,q)
                  cnt++;
                  if(cnt>n) return m[i];
                }
                
              }
            }
          }
    /*
    Union-find with specific canonical element.
    Add a method find() to the union-find data type so that find(i) returns the largest element in the connected component containing i.
    The operations, union(), connected(), and find() should all take logarithmic time or better.

    For example, if one of the connected components is {1,2,6,9}, then the find() method should return 9 for each of the four 
    elements in the connected components.
    */
          
          public class QuickUnionFastUF
            {
              private int[] id;
              public QuickUnionUF(int n)
              {
                id= new int[n];
                for (int i=0; i<n ; i++)
                  id[i]=i;
              }
            
              public bool connected(int p , int q)
              {
                return root(p) == root(q);
              }
              public void union(int p, int q)
              {
                if(p>q) id[root(q)]=id[root(p)];
                else  id[root(p)]=id[root(q)];
              }
              private Root root(int p)
              {
                while (id[p]!=p)
                {
                  id[p]=id[id[p]];//to flatten the tree while we are accessing it
                  p=id[p];
                }
                return p;
              }
              public int find(int p)
              {
                return root(p); 
              }
            }
        /*
        Successor with delete. Given a set of n integers S={0,1,...,n−1} and a sequence of requests of the following form:

        Remove x from S
        Find the successor of x: the smallest y in S such that y≥x.
        design a data type so that all operations (except construction) take logarithmic time or better 
        */
        
