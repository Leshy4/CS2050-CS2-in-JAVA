package ClassworksCSII;

public class LinkedListDriver {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        System.out.println(ll);
        if (ll.isEmpty())
            System.out.println("Is empty!");
        else
            System.out.println("Not empty!");
        System.out.println("Size: " + ll.size());
        ll.add(8);
        System.out.println(ll);
        ll.add(2);
        System.out.println(ll);
        ll.add(5);
        System.out.println(ll);
        if (ll.isEmpty())
            System.out.println("Is empty!");
        else
            System.out.println("Not empty!");
        System.out.println("Size: " + ll.size());
        System.out.println(ll.get(0));
        System.out.println(ll.get(1));
        System.out.println(ll.get(2));
        System.out.println(ll.get(3));
    }
}