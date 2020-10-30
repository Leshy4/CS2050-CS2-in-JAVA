
public class Target extends DecisionTreeData {

    private int value;

    public Target(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{" + "target = " + value + '}';
    }
}
