public class QueueDriver {

    public static void main(String[] args) {
        DynamicQueue st = new DynamicQueue();
        System.out.println(st);
        st.push(5);
        System.out.println(st);
        st.push(8);
        System.out.println(st);
        st.push(3);
        System.out.println(st);
        int data = st.peek();
        System.out.println("data = " + data);
        System.out.println(st);
        data = st.pop();
        System.out.println("data = " + data);
        System.out.println(st);
        data = st.pop();
        System.out.println("data = " + data);
        System.out.println(st);
        st.push(5);
        System.out.println(st);
        st.push(8);
        System.out.println(st);
        st.push(3);
        System.out.println(st);
        data = st.pop();
        System.out.println("data = " + data);
        System.out.println(st);
    }
}