import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    public void testEmptyTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertTrue(tree.isBalanced());
        assertEquals(0, tree.height());
    }

    @Test
    public void testSingleElementTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        assertTrue(tree.isBalanced());
        assertEquals(1, tree.height());
    }

    @Test
    public void testTwoElementsTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(3);
        assertTrue(tree.isBalanced());
        assertEquals(2, tree.height());
    }

    @Test
    public void testTreeElementsBalancedTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(8);
        assertTrue(tree.isBalanced());
        assertEquals(2, tree.height());
    }

    @Test
    public void testTreeElementsLeftUnbalancedTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(1);
        assertFalse(tree.isBalanced());
        assertEquals(3, tree.height());
    }

    @Test
    public void testTreeElementsRightUnbalancedTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(8);
        tree.add(10);
        assertFalse(tree.isBalanced());
        assertEquals(3, tree.height());
    }

    @Test
    public void testFiveElementsBalancedTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(1);
        tree.add(8);
        tree.add(10);
        assertTrue(tree.isBalanced());
        assertEquals(3, tree.height());
    }

    @Test
    public void testFiveElementsLeftUnbalancedTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(8);
        assertFalse(tree.isBalanced());
        assertEquals(4, tree.height());
    }

    @Test
    public void testFiveElementsRightUnbalancedTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        assertFalse(tree.isBalanced());
        assertEquals(4, tree.height());
    }

    @Test
    public void testFiveElementsSuperLeftUnbalancedTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        assertFalse(tree.isBalanced());
        assertEquals(5, tree.height());
    }

    @Test
    public void testFiveElementsSuperRightUnbalancedTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        assertFalse(tree.isBalanced());
        assertEquals(5, tree.height());
    }
}