/**  Computer Science II         Appends Nodes in Linked List, Basic O(n) for Turing's Method (Infinite Tape)
     Hashtable<K,V> Class            Hashes By Alphabet.size()         Implement new one with Queue, instead List */
import java.util.*;
import java.util.Iterator;/**         (SIZE++ == HashCOLLISIONS--)      */

public class Hashtable<K,V> implements Iterable<V> {

    private static final int SIZE = 26;  /** Size of the alphabet Works well.   HASHING:: Key % SIZE = Index       */
    private HashNode<K, V> hashTable[];     // Hashtable to hold Lists to hold HashNodes

    public Hashtable(){}    //Empty             // put(HashNode), NOT (K,V)
    public Hashtable(HashNode<K, V> newTableNode){ put(newTableNode);}            // put(HashNode), NOT (K,V)

    public int hash(HashNode<K, V> newHashNode){ return newHashNode.getKey().hashCode() % SIZE;} // == HASH_CODE

    public void put(HashNode<K, V> newHashNode) {  // Append to Hashtables Singly Linked List @ table[index]
        int index = hash(newHashNode);  // HASH:: index points to the location in the table
        if (hashTable[index] == null)   // TODO: if table[index] is unoccupied, Insert node
            hashTable[index] = newHashNode;
        else {         // O(n) List Search for End of List & Append                         Optimized = Queue
            HashNode<K, V> current = hashTable[index];  //Indexing == O(1)   Search == O(n) -> EnQueue == O(1)
            while (current.getNext() != null) {
                if (current.getValue() == newHashNode.getValue()) return;   // Found, No Insertion
                else current = current.getNext();
            }
            current.setNext(newHashNode); //Insert @ End of hashTable[index]
        }
    }

    public HashNode<K, V> get(int index){    //gets first node of index
        if(hashTable[index % SIZE] == null) return null;
        return hashTable[index];
    }

    @Override
    public void toString(int index){
        if(hashTable[index % SIZE] == null) return System.out.println("Nothing at Index: " + index);
        HashNode<K, V> printNode = hashTable[index];
        String allValuesAtIndex = "";
        while(printNode != null) {
            allValuesAtIndex += (printNode.getValue() + " ");
            printNode = printNode.getNext();
        }
        System.out.print(allValuesAtIndex);
        return(allValuesAtIndex);
    }

    @Override
    public String toString(HashNode<K, V> printNode) { //^^ Overloaded Method
        return toString(hash(printNode));
    }

}