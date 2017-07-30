public class LinearProbingHashTable
{
    private int M= 30001;
    private Value[] vals = (Value[]) new Object[M];
    private Key[] keys = (Keys[]) new Object[M];
    
    private int hash(Key key){}
    
    public Value get(Key key){
        int h = hash(key);
        while(keys[h]!=null){
            if(keys[h].equals(key))
                return vals[h];
            else h=(h+1) % M;
        }
        return null;
    }
    
    public void put(Key key, Value val){
        int h = hash(key);
        while(keys[h] != null){
            if(keys[h].equals(key))
                break;
            h=(h+1) % M;
        }
        keys[h]=key;
        vals[h]=val;
    }
}
