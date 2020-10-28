/**   Binary Tree class      &       Breadth First Tree toString Method with Queues */

public class BinaryTree<T extends Comparable<T>> {
    private BinNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private BinNode<T> addRecursively(BinNode<T> current, final T data) {
        if (current == null)
            return new BinNode<T>(data);
        else {
            if (data.compareTo(current.getData()) < 0)
                current.setLeft(addRecursively(current.getLeft(), data));

            else if (data.compareTo(current.getData()) > 0)
                current.setRight(addRecursively(current.getRight(), data));

            return current;
        }
    }

    public void add(final T data) {
        if (isEmpty())
            root = new BinNode<T>(data);
        else
            addRecursively(root, data);
    }

    // toString method using a Breadth First tree traversal using a Queue of Binary Nodes
    @Override
    public String toString() {
        Queue<BinNode<T>> queue = new Queue<>();
        BinNode<T> current = root;
        queue.push(current);
        String str = "";
        while (!queue.isEmpty()) {
            current = queue.pop();
            str += current.getData() + " ";
            if (current.getLeft() != null)
                queue.push(current.getLeft());
            if (current.getRight() != null)
                queue.push(current.getRight());
        }
        return str;
    }

    private boolean searchRecursively(final BinNode<T> current, final T data) {
        if (current == null)
            return false;
        else if (data.compareTo(current.getData()) == 0)
            return true;
        else if (data.compareTo(current.getData()) < 0)
            return searchRecursively(current.getLeft(), data);
        else
            return searchRecursively(current.getRight(), data);
    }

    public boolean search(final T data) {
        return searchRecursively(root, data);
    }
}
