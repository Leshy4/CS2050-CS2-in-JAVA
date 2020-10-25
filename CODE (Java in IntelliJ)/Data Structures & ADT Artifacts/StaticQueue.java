package ClassworksCSII;

public class Activity11StaticQueue
{       /** Has Size (# of Elements) & Capacity (# of Max Elements)
 Always NEED TO KNOW: Front of the Queue         INDEX INSERTION: (Front + Size ) % Capacity   */
    private int front;
    private int capacity;
    private int size;
    private int data[];
    private static final int MIN_CAPACITY = 2;  // 2 For Stacks

    public void StaticQueue()
    {   this.capacity = (MIN_CAPACITY);
    }

    public void StaticQueue(int capacity)
    {   if (capacity < MIN_CAPACITY)
            this.capacity = MIN_CAPACITY;
        else
            this.capacity = capacity;
        size = 0;
        data = new int[this.capacity];
        front = 0;
    }

    public boolean isEmpty()
    {   if (size == 0){
            return true;
        }
        else return false;
    }

    public boolean isFull()
    {   if (size == capacity){
        return true;
    }
    else return false;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void push(int data)
    {   if (!isFull()) {
            int rear = (front + size) % capacity;
            this.data[rear] = data;
            size++;
        }
        // Insert (Front + size) % capacity;        \\Works even if isEmpty.
    }

    public int pop()
    {   if (!isEmpty()) {
            int data = this.data[front];
            front = (front + 1) % capacity;
            size--;
            return data;
        }
        return 0;
    }

    public int peek()
    {   if (!isEmpty()) {
            int data = this.data[front];
            return data;
        }
        return 0;
    }


    @Override
    public String toString()
    {   if(isEmpty()){  return System.out.println("This Queue is Empty.");  }
        else{
            String out = "(front) ";
            int current = front;
            for(int i = 0; i < size; i++)
            {   out += data[current] + " " ;
                current = (current + 1) % capacity;
            }
            out += " (rear)";
            return out;
        }
    }
}   //End of Class