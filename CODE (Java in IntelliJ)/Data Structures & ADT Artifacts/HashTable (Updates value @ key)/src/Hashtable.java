/**   Hashtable class       (Update values with the same Key || Inserts @ end of List)            */

import java.util.Iterator;

public class Hashtable<K,V> implements Iterable<V> {

    private static final int SIZE = 17;         // NumberOfElements - SIZE = #ofHashCollisions (Best Case)
    private HashNode<K, V> table[];                 // Worst Case: NumberOfElements == (#ofHashCollisions - 1)

    public Hashtable() {
        table = new HashNode[SIZE];
    }

    // Hash value == key.hashCode() % SIZE  // Insert @ Location, If empty || !empty = Update Information @ Index
    public void put(K key, V value) {
        // Hash = index points to the location in the table
        int index = Math.abs(key.hashCode() % SIZE);
        HashNode<K, V> newHashNode = new HashNode(key, value);  // Create a new HashNode from (key, value)

        // If table @ index is unoccupied, have the location point to the new node
        if (table[index] == null)
            table[index] = newHashNode;

        // Search Linked List @ table[index] for a nodes with the same key
        else {          // If(contains) Update Value;   Else Insert node @ end of list
            HashNode<K, V> current = table[index];
            while (!current.getKey().equals(key) &&
                    current.getNext() != null)
                current = current.getNext();

            // if found, rewrite the value of hash node
            if (current.getKey().equals(key))
                current.setValue(value);

            // if not, add new hash node at end of list
            else current.setNext(newHashNode);
        }
    }

    // Gets int value from the node with that key
    public V get(K key) {
        int index = key.hashCode() % SIZE;  // index points to the location in the table
        HashNode<K, V> current = table[index]; // Get the hash node at table @ index

        while (current != null) {       // Find hash node with same key.
            if (current.getKey().equals(key))
                return current.getValue();       //If found, return the hash node's value
            current = current.getNext();
        }
        return null;    // if not found, the method returns null
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < SIZE; i++) {
            if (table[i] != null) {
                str += "[" + i + "]: ";
                HashNode<K, V> current = table[i];
                while (current != null) {
                    str += current.toString() + " ";
                    current = current.getNext();
                }
                str += "\n";
            }
        }
        return str;
    }

    // Iterator for the hashtable
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            int index = 0;
            HashNode<K, V> current = table[index];

            @Override
            public boolean hasNext() {
                while (true) {
                    if (index == SIZE)
                        break;
                    if (current == null) {
                        index++;
                        if (index < SIZE)
                            current = table[index];
                    }
                    else
                        return true;
                }
                return false;
            }

            @Override
            public V next() {
                if (hasNext()) {
                    V v = current.getValue();
                    current = current.getNext();
                    while (true) {
                        if (index == SIZE)
                            break;
                        if (current == null) {
                            index++;
                            if (index < SIZE)
                                current = table[index];
                        }
                        else
                            break;
                    }
                    return v;
                }
                return null;
            }
        };
    }
}
