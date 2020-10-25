package ClassworksCSII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void testInvertingEmptyList() {
        LinkedList ll = new LinkedList();
        ll.invert();
        assertTrue(ll.isEmpty());
        assertEquals(0, ll.size());
    }

    @Test
    void testInvertingSingleElementList() {
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.invert();
        assertFalse(ll.isEmpty());
        assertEquals(1, ll.size());
        assertEquals(1, ll.get(0));
    }

    @Test
    void testInvertingThreeElementList() {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.invert();
        assertFalse(ll.isEmpty());
        assertEquals(3, ll.size());
        assertEquals(3, ll.get(0));
        assertEquals(2, ll.get(1));
        assertEquals(1, ll.get(2));
    }

    public static void main(String[] args) {
        LinkedList somet = new LinkedList();
        somet.add(1);
        somet.add(2);
        somet.add(3);
        somet.add(4);
        somet.add(12);
        System.out.println(somet);
        somet.invert();
        System.out.println(somet);
    }

}