
// set of key value pairs 

// values are not null
// get return null if ket not present
// put overwrites old value with new value
public abstract class SymbolTable<Key, Value>
{
  void abstract put(Key key, Value val);
  Value abstract get(Key key);
  
  void delete(Key key)
  {
    put(key, null); 
  }
  
  boolean contains(Key key)
  {
    return get(key) != null;
  }
  
  boolean abstract isEmpty();
  
  int abstract size();
  Iterable<Key> abstract keys();
  
 }
 
public class SimpleST<Key,Value> extends SymbolTable<Key,Value>
{
   
  
