public class ExpressionTree {

    private BinNode<Term> root;

    public ExpressionTree(Queue<Term> input) {
        root = add(input);
    }

    public boolean isEmpty() {
        return root == null;
    }

    // TODO: implement the add private method
    private BinNode<Term> add(Queue<Term> input) {
        return null;
    }

    public String inOrder(final BinNode<Term> current) {
        if (current != null)
            return  inOrder(current.getLeft())  +
                    current.getData() + " "     +
                    inOrder(current.getRight());
        return "";
    }

    @Override
    public String toString() {
        return inOrder(root);
    }
}