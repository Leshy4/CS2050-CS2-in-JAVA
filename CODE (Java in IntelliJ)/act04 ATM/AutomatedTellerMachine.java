/** CS2050 - Computer Science II
 * Description: Activity 04 - AutomatedTellerMachine             */

public class AutomatedTellerMachine {

    private int n5, n10, n20, n50;
    private static final int DEFAULT_AMOUNT = 10;

    public AutomatedTellerMachine() {
        n5 = n10 = n20 = n50 = DEFAULT_AMOUNT;
    }

    public AutomatedTellerMachine(int n50, int n20, int n10, int n5) {
        if (n50 < 0)
            this.n50 = 0;
        else
            this.n50 = n50;
        if (n20 < 0)
            this.n20 = 0;
        else
            this.n20 = n20;
        if (n10 < 0)
            this.n10 = 0;
        else
            this.n10 = n10;
        if (n5 < 0)
            this.n5 = 0;
        else
            this.n5 = n5;
    }

    public int getBalance() {
        return n50 * 50 + n20 * 20 + n10 * 10 + n5 * 5;
    }

    public boolean hasMoney() {
        return getBalance() > 0;
    }

    @Override
    public String toString() {
        return "ATM has $" + getBalance() + ": " + n50 + " x $50 + " + n20 + " x $20 + " + n10 + " x $10 + " + n5 + " x $5";
    }

    public boolean withdraw(int amount) {
        if (amount <= 0 || amount > getBalance() || amount % 5 != 0)
            return false;
        int t50 = n50;
        int t20 = n20;
        int t10 = n10;
        int t5  = n5;
        // take as much $50 bills as you can
        int bills = Math.min(amount / 50, t50);
        t50 -= bills;
        amount -= bills * 50;
        // take as much $20 bills as you can
        bills = Math.min(amount / 20, t20);
        t20 -= bills;
        amount -= bills * 20;
        // take as much $10 bills as you can
        bills = Math.min(amount / 10, t10);
        t10 -= bills;
        amount -= bills * 10;
        // take as much $5 bills as you can
        bills = Math.min(amount / 5, t5);
        t5 -= bills;
        amount -= bills * 5;
        if (amount == 0) {
            n50 = t50;
            n20 = t20;
            n10 = t10;
            n5  = t5;
            return true;
        }
        return false;
    }
}