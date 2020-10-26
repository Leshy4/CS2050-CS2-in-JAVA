 /**        Computer Science II
 Description: Hashtables - HashNode class            */
                        // Has Key 'K'  &&  Value 'V'  &&  next
import java.util.*;     // VERY USEFUL! Many O(1) actions with Hashtables.
                        // Uses Hash Function to produce K->     K = someValue % hashTableSize
public class HashNode<K, V> {
                                     //TODO: ONLY Difference it has a Key to be Hashed into an array @ O(1)
    private K  key;                 // array[node.getkey()]     :: THEN Acts as a Singly Linked List from there
    private V  value;               // get || set -> Key(),Value(),next()
    private HashNode<K, V> next;

    public HashNode() {
        key = null;
        value = null;
        next = null;
    }

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public HashNode<K, V> getNext() {
        return next;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNext(HashNode<K, V> next) {
        this.next = next;
    }

    @Override
    public String toString() { return "(" + key.toString() + ", " + value.toString() + ")";  }
}