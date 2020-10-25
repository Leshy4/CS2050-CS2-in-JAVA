/** CS2050 - Computer Science II
 * Description: Activity 04 - AutomatedTellerMachineDriver   */

import java.util.Random;

public class AutomatedTellerMachineDriver {

    public static void main(String[] args) {
        AutomatedTellerMachine atm = new AutomatedTellerMachine(3, 1, 1, 1);
        while (atm.hasMoney()) {
            System.out.println(atm);
            int amount = (new Random().nextInt(200) + 1) * 5;
            System.out.println("Trying to withdraw $" + amount + " from ATM");
            if (atm.withdraw(amount))
                System.out.println("Success!");
            else
                System.out.println("Not enough bills for the request!");
        }
    }
}
