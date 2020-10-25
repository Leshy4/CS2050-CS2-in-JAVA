package PriorityQueue;

/* Student: Christopher Welch   3/6/20
 * CS2050 - Computer Science II - Spring 2020
 *Instructor: Thyago Mota  *Description: Homework 06 - PriorityQueue  */
public class PriorityQueue
{
    private Node front;     // priority queue does not benefit much by having a rear pointer, so let's not worried about it
    private int priorityValue;  // Priority Value Variable Added

    public PriorityQueue() {front = null;}

    // TODO: finish the implementation of the method
    public void push(Customer customer)
    {// create a new node with customer
        Node node = new Node(customer);
     // add the new node as the front node if queue is empty
        if (isEmpty())
        {   this.front = node;
            front.setCustomer(node.getCustomer());
            System.out.println("Inserted " + customer.getName());
            return;}
     // if the queue is not empty

        if (!isEmpty())
        {   System.out.println("Inserted " + customer.getName());          /////////////////////////////XXXXXXXXXX
     // if New customer has a higher priority than the front customer, add the new node as the front node
            if(node.getCustomer().getPriority() > front.getCustomer().getPriority())
                    {node.setNext(front);                    // newNode.next = oldFront
// MAY NEED IT       Node temp = front;                     // tempNode = oldFront
                this.front = node;                          // front = newNode
                return;
            } //If
            else    //// if that is not the case, use the previous/current strategy
             {  Node current = front;
                Node oldCurrent = current;

                while (current != null)
                {   //Add the new node in the correct location of the queue
                    if(current.getNext() == null)   // If you haven't returned at this point,
                        {   current.setNext(node);      // add the new node at the rear of the queue
                            return;
                        }
                    if(current.getCustomer().getPriority() < node.getCustomer().getPriority())
                    {   node.setNext(current);
                        oldCurrent.setNext(node);
                        return;
                    }
                    oldCurrent = current;
                    current = current.getNext();
                } //While
             } //Else
        } // if !isEmpty
    } // Push

    public Customer pop() {
        if (isEmpty())
            return null;
        Customer customer = front.getCustomer();
        Node temp = front;
        front = front.getNext();
        temp.setNext(null);
        return customer;
    } // Customer.pop()

    public Customer peek() {
        if (isEmpty())
            return null;
        return front.getCustomer();
    } // Customer.peek()
    public int size() {
        int count = 0;
        Node current = front;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    } // size
    public boolean isEmpty() {
        return front == null;
    }
    // top to bottom (left to right)
    @Override
    public String toString() {
        String out = "(front)";
        Node current = front;
        while (current != null) {
            out += " " + current.toString();
            current = current.getNext();
        }
        out += " (rear)";
        return out;
    } // toString
} // Priority Queue