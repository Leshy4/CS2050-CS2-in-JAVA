    /**  Like a Linked List, but the Head is the Bottom Node */
public class StackDriver {

    public static void main(String[] args) {
        StaticStack stack = new StaticStack(5);
        System.out.println(stack);
        stack.push(5);
        System.out.println(stack);
        stack.push(8);
        System.out.println(stack);
        stack.push(3);
        System.out.println(stack);
        int data = stack.pop();
        System.out.println("data: " + data);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
    }
}