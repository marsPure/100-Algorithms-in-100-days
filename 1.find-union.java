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
    if (!uf.connected(p,q){
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
          

 
 
