        /** DYNAMIC STACK == A Linked List used at a stack.     * Never has to Resize        */
public class DynamicStack {

    private Node top;

    public DynamicStack() {
        top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.setNext(top);
        top = newNode;
    }

    public int pop() {
        if (isEmpty())
            return 0;
        int data = top.getData();
        top = top.getNext();
        return data;
    }

    public int peek() {
        if (isEmpty())
            return 0;
        return top.getData();
    }

    public int size() {
        int count = 0;
        Node current = top;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // top to bottom (left to right)
    @Override
    public String toString() {
        String out = "(top)";
        Node current = top;
        while (current != null) {
            out += " " + current.toString();
            current = current.getNext();
        }
        out += " (bottom)";
        return out;
    }

}