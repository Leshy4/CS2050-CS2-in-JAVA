
public class DecisionTreeNode {         // BINARY NODE, but used for Decision Tree

    private DecisionTreeData data;
    private DecisionTreeNode left, right;

    public DecisionTreeNode() {
        data = null;
        left = right = null;
    }

    public DecisionTreeNode(DecisionTreeData data) {
        this.data = data;
        left = right = null;
    }

    public DecisionTreeData getData() {
        return data;
    }

    public void setData(DecisionTreeData data) {
        this.data = data;
    }

    public DecisionTreeNode getLeft() {
        return left;
    }

    public void setLeft(DecisionTreeNode left) {
        this.left = left;
    }

    public DecisionTreeNode getRight() {
        return right;
    }

    public void setRight(DecisionTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}