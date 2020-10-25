package ClassworksCSII;/*
 * CS 2050 -    Computer Science II - Spring 2020
 * Student:     Christopher Welch
 * Instructor:  Thyago Mota
 * Description: Homework 04 - ClassworksCSII.LinkedList     */

public class LinkedList
{   private Node1 head;

    public LinkedList() {
        head = null;
    }

    // add in front
    public void add(int data) {
        Node1 newNode = new Node1(data);
        newNode.setNext(head);
        head = newNode;
    }

    // add tail
    public void append(int data) {
        Node1 newNode = new Node1(data);
        if (isEmpty())
            head = newNode;
        else
        {   Node1 current = head;
            while (current.getNext() != null)
                current = current.getNext();
            current.setNext(newNode);
        }
    }

    @Override
    public String toString() {
        String out = "";
        Node1 current = head;
        while (current != null) {
            out += current.toString() + " ";
            current = current.getNext();
        }
        return out;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node1 current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public int get(int index)
    {
        if(index < 0 || index > (size() - 1)){return 0;}
        int i = 0;
        Node1 current = head;
        while(i != index)
            {   i++;
                current.getNext();
            }
        return current.getData();
    }

    public void set(int index, int data) {
        if (index < 0 || index >= size())
            return;
        int i = 0;
        Node1 current = head;
        while (i < index) {
            i++;
            current = current.getNext();
        }
        current.setData(data);
    }

    void insert(int index, int data)
    {   if (index < 0 || index > size())
        {   System.out.println("Invalid Index");
            return;
        }
        if (index == 0)
        {   add(data);
        }
        else
        {   Node1 current = head;
            for (int i = 0; i < index; i++)
               current = current.getNext();
            Node1 newNode = new Node1(data);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    void remove(int index) {
        if (index < 0 || index >= size())
            return;
        if (index == 0) {
            Node1 toBeRemoved = head;
            head = toBeRemoved.getNext();
            toBeRemoved.setNext(null);
        }
        else {
            int i = 0;
            Node1 current = head;
            while (i < index - 1) {
                i++;
                current = current.getNext();
            }
            // Saving the reference to the node to be removed
            Node1 toBeRemoved = current.getNext();
            current.setNext(toBeRemoved.getNext());
            toBeRemoved.setNext(null);
        }
    }

    // assume that the clear method does what it supposed to do
    void clear() {
        Node1 current = head;
        while (current != null) {
            Node1 temp = current.getNext();
            current.setNext(null);
            current = temp;
        }
        head = null;
    }

        // TODO: implement the invert method
        void invert () {
            // create a new linked list
            LinkedList invertLL = new LinkedList();
            // traverse the original list, adding its elements into the new list using the "add" method
            if (head == null) {System.out.println("The List is Empty!");}
            else
             {  while (head != null) {
                    invertLL.add(head.getData());
                    head = head.getNext();
                }

                // clear the original list
                Node1 temp = new Node1();
                while (head != null) {
                    temp = head.getNext();
                    head = null;
                    head.setNext(temp);
                }

                // make head point to the head of the new linked list
                head = invertLL.head;
                        //head.setData(invertLL.head.getData());    //DON'T NEED?
             }//Else End
        }//Invert End
}//Class End