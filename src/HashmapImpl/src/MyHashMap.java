public class MyHashMap<K,V> {

    class Entry<K,V>{
        public K key;
        public V value;
        public Entry<K,V> next;

        Entry(K k,V v){
            key = k;
            value = v;
        }
    }

    private static final int INITIAL_SIZE = 1<<4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;


    public Entry<K,V>[] hashTable;

    public MyHashMap(){
        hashTable = new Entry[INITIAL_SIZE];
    }
    public MyHashMap(int capacity){
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    final int tableSizeFor(int cap){
        int n = cap-1;
        n |= n>>>1;
        n |= n>>>2;
        n |= n>>>4;
        n |= n>>>8;
        n |= n>>>16;

        return (n<0) ?1:(n>=Integer.MAX_VALUE?MAXIMUM_CAPACITY:n+1);
    }

    public void put(K key,V value){
        int hashCode = key.hashCode() % hashTable.length;
        Entry<K, V> node = hashTable[hashCode];

        if(node == null){
            Entry<K, V> newNode = new Entry(key,value);
            hashTable[hashCode] = newNode;
        }else{
            Entry<K, V> previousNode = node;
            while (node!=null){
                if(node.key == key){
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            Entry<K, V>newNode = new Entry(key,value);
            previousNode.next = newNode;
        }
    }

    public V get(K key){
        int hashCode = key.hashCode() % hashTable.length;
        Entry<K, V>node = hashTable[hashCode];

        while (node!=null){
            if(node.key.equals(key)){
                return (V)node.value;
            }
            node = node.next;
        }
        return null;
    }


}
