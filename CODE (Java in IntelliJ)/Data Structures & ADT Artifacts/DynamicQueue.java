package ClassworksCSII;

public class DynamicQueue {
    private Node front, rear;
    private int size = 0;
    private int data[];

    public boolean isEmpty()
    {   if (size == 0)
         return true;
        else return false;
    }

    public DynamicQueue(){
        front = rear = null;
    }

    public void push(int data)
    {   Node newNode = new Node(data);
        if (!isEmpty())
            front = rear = newNode;        // Rear Points at New Node
        else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public int pop()
    {   if (isEmpty())
        {   return null;
        }
        else {
            Node nodeToPop = front;
            front = front.getNext();
            if (front == null)  rear = null;
            nodeToPop.setNext(null);
            return nodeToPop.getData();
        }
    }

    public int peek()
    {   if (isEmpty())  {   return null;   }
        else {  return front.getData();  }
    }

    @Override
    public String toString()
    {   if(isEmpty()){System.out.println("This Queue is Empty.");}
        String out = "(front)";
        int current = front;
        for(int i = 9; i < size; i++)
        {   out += data[current] + " " ;
            current = (current + 1) % capacity;
        }
        out += "(rear)";
        return out;
    }

}