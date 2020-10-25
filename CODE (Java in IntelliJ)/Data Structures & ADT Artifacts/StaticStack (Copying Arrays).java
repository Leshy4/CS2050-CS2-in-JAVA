/**~~~~~~~~~~Stacks
STATIC ARRAY IMPLEMENTATION
-Stack Capacity = How many elements a Stack can hold.
-Maintains the Size of the Stack.
-Where is TOP Index? A Pointer.
-USE data.index(size) || data.index(size) , while (In)(De)crementing
DYNAMIC IMPLEMENTATION  Resembles a Linked List
-Has no Capacity because it is a Linked List                                */

public class StaticStack {
    private int[] data;
    private int capacity;
    private int size;
    private static final int MIN_CAPACITY = 2;

    public StaticStack(int capacity)
    {   if (capacity < MIN_CAPACITY)
            this.capacity = MIN_CAPACITY;
        else
            this.capacity = capacity;
        size = 0;
        data = new int[this.capacity];
    }

    public StaticStack()
    {
//  {   this.capacity = MIN_CAPACITY;
//      size = 0;
//      data = new int[this.capacity];
        this(MIN_CAPACITY);
    }

    public void push(int data)
    {   if (!isFull()) {
            this.data[size] = data;
            size++;
        }
    }

    public int pop() {
        if (!isEmpty())
        {   int data = this.data[size-1];
            size--;
            return data;
        }
        return 0;
    }

    public int peek()
    {
        return data[0];
    }

    public boolean isFull()
    {   if (this.size == capacity){return true;}
        else return false;
    }

    public boolean isEmpty()
    {   if (this.size == 0)
            return true;
        else return false;
    }

    @Override
    public String toString()
    {   String out = "(top)";
        for (int i = size-1; i >=0; i--)
            out += " " + data[i];
            return out;
    }

}