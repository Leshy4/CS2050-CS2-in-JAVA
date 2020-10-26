package PostfixEvaluationP;/* Student: Christopher Welch
 * CS2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota           * Description: Homework 05 - Node       */

public class Node {

    private int  data;
    private Node next;

    public Node() {
        data = 0;
        next = null;
    }

    public Node(int data) {
        this.data = data;
        next = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data + "";
    }
}