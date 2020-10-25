package ClassworksCSII;/*  CS 2050 -    Description: Homework 03 - ClassworksCSII.FizzBuzz                                      */

public class FizzBuzz {

    private int current;
    private static final int DEFAULT_START = 1;

    // TODO: implement parameter-less constructor which should set the current number to the default start
    public FizzBuzz()
    {   this.current = DEFAULT_START;
    }

    // TODO: implement parameterized constructor which should set the current number based on the user provided value;
    //  if start is less than 1, set current to the default start
    public FizzBuzz(int start)
    {   if(start < 1) {this.current = DEFAULT_START;}
        else {this.current = start;}
    }

    // TODO: implement the getter method that should return the value of current
    public int getCurrent()
    {   return this.current;
    }

    // TODO: implement next which should increment current by 1 unit
    public void next()
    {   ++this.current;
    }

    // TODO: override toString which should return the current number as a string, or the words "Fizz", "Buzz", or
    //  "ClassworksCSII.FizzBuzz" depending whether the number is a multiple of 3, 5, or both, respectively
    @Override
    public String toString()
    {   String output = "";
        if (this.current % 5 == 0 && this.current % 3 == 0)
        {   return "ClassworksCSII.FizzBuzz";
        }
        else if (this.current % 5 != 0 && this.current % 3 == 0)
        {   return "Fizz";
        }
        else if (this.current % 5 == 0 && this.current % 3 != 0)
        {   return "Buzz";
        }   else {return String.valueOf(current);}
    }

    // MAIN Method
    public static void main(String[] args)
    {}

}