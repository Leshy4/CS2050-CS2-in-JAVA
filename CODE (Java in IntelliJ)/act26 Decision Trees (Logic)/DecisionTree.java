
public class DecisionTree {

    private DecisionTreeNode root;

    public DecisionTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public DecisionTreeNode getRoot() {
        return root;
    }

    public void setRoot(DecisionTreeData data) {
        root = new DecisionTreeNode(data);
    }

    public void setLeft(DecisionTree subtree) {
        root.setLeft(subtree.getRoot());
    }

    public void setRight(DecisionTree subtree) {
        root.setRight(subtree.getRoot());
    }

    // Classify Recursively
    private void classifyRecursively(DecisionTreeNode current, DataPoint dp) {
        DecisionTreeData data = current.getData();  // Get DecisionTreeData from current DecisionTreeNode
        if (data instanceof Decision) {              // If DecisionTreeData is an instance of Decision,
            Decision decision = (Decision) data;     // cast it to Decision and
            int attribute = decision.getAttribute();
            double value = decision.getValue();      // use the object to decide whether to call classifyRecursively
            if (dp.getAttribute(attribute) <= value) // to the left or to the right
                classifyRecursively(current.getLeft(), dp);
            else
                classifyRecursively(current.getRight(), dp);
        }
        else {                               // If DecisionTreeData is an instance of Target,
            Target target = (Target) data;   // cast it to Target and
            dp.setTarget(target.getValue()); // set the target of the data point
        }
    }

    public void classify(DataPoint dp) {
        classifyRecursively(root, dp);
    }

    @Override
    public String toString() {
        Queue<DecisionTreeNode> queue = new Queue<>();
        DecisionTreeNode current = root;
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
}