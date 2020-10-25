import java.util.Random;

public class PracticeClasses {

    public static class AccountClass
    {   private int accIDNum;
        private String accName;
        private float balance;
        private float moneyAmount;

        public void createAccount(int accIDNum, String accName)
        {   this.accIDNum = accIDNum;
            this.accName = accName;
            this.balance = 0;
        }

        public void depositMoney(float moneyAmount)
        {   this.balance += moneyAmount; }

        public void withdrawMoney(float moneyAmount)
        {   if ((this.balance - moneyAmount) < 0)
            {   System.out.println("You don't have enough money!");
                System.out.println("You have $" + balance);
            }   else {this.balance -= moneyAmount;}
        }

        public void toStringAccount()
        {   System.out.println("Account ID: " + accIDNum + "\nAccount Name: " + accName + "\nBalance: $" + balance);    }
    }

    /* A sandwich is defined by a name, number of calories (integer is fine), and price. Users should be able to create a
    sandwich given its name, number of calories, and price. If informed number of calories or price is negative, make
    sure those values are initialized to zero. Define “toString” and a method called “isHealthy” that returns true if
    the number of calories is less than 250, false otherwise.     */
    //************ SANDWICH CLASS ******************
    public static class Sandwich
    {   private String name;
        private int calories;
        private double price;
        boolean isHealthy;

        public void makeASandwich(String name, int calories, double price)
        {   this.name = name;
            if (calories > 0)
            {   this.calories = calories;
            }   else { this.calories = 0;}
            if (price > 0)
            {   this.price = price;
            }   else { this.price = 0;}
        }

        public void toStringSandwich()
        {   System.out.println("GoogleMapProject.Sandwich name: " + name + "\nCalories: " + calories + "\nPrice: $" + price);    }

        public boolean isHealthy()
        {   if (calories < 250) {return isHealthy = true;}
            else {return isHealthy = false;}
        }
    }

    /* A dice is defined by a number of sides (at least 2) and a value that keeps the dice’s current value (always set to
    1 upon initialization). Users should be able to create a dice given its number of sides. If the informed value is < 2,
    set it to 2. Users should also be able to create a dice without informing its number of sides (in that case, set the
    number of sides to 6). Remember, the current value of a dice should always be set to 1 upon creation. Create a method
    called “getValue” that returns the dice’s current value. Also, define a method called “roll” to randomly pick another
    value for the dice, based of course on the number of sides.     */
    //*********** DICE CLASS*************************
    public static class Dice
    {   private int numOfSides; //Atleast 2
        private int rollValue;  //Atleast 1

        public void createDie(int numOfSides)
        {   if(numOfSides < 2){this.numOfSides = 2;}
            else{this.numOfSides = numOfSides;}
            this.rollValue = 1;
        };

        public void createDie()
        {   this.rollValue = 1;
            this.numOfSides = 6;
        }

        public int getValue(){return rollValue;}

        public int roll()
        {   Random randomRoll = new Random();
            int randomVal = (randomRoll.nextInt(this.numOfSides) + 1);
            return randomVal;
        }
    }

    //A MAIN: If I want to run some code
    public static void main(String[] args)
    {   // Creating a Bank Account & Paying Rent
        AccountClass bankAccount1 = new AccountClass();
        bankAccount1.createAccount('1',"Christopher Welch");
        bankAccount1.depositMoney((float)1750);
        bankAccount1.withdrawMoney((float)850.76);
        bankAccount1.toStringAccount();

        // Making a GoogleMapProject.Sandwich
        Sandwich hammySammy = new Sandwich();
        hammySammy.makeASandwich("Hammy Sammy", 250, 7.49);
        System.out.println("This GoogleMapProject.Sandwich is healthy! " + hammySammy.isHealthy());

        // Make Dice
        Dice d12 = new Dice();
        d12.createDie(12);
        System.out.println("10 Rolls of a D12: ");
        for (int i = 0; i < 10; i++)
        {   if (i == 9) {System.out.print(d12.roll());}
            else {System.out.print(d12.roll() + ", ");}
        }
        Dice d6 = new Dice();
        d6.createDie();
        System.out.println("\n10 Rolls of a D6: ");
        for (int i = 0; i < 10; i++)
        {   if (i == 9) {System.out.print(d6.roll());}
            else {System.out.print(d6.roll() + ", ");}
        }
    }

}

