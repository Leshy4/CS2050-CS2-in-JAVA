package ClassworksCSII;// TEST STUFF*************************************************
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {
    void helperRun1to15(FizzBuzz fb) {
        assertEquals(1, fb.getCurrent());
        assertEquals("1", fb.toString());
        fb.next();
        assertEquals(2, fb.getCurrent());
        assertEquals("2", fb.toString());
        fb.next();
        assertEquals(3, fb.getCurrent());
        assertEquals("Fizz", fb.toString());
        fb.next();
        assertEquals(4, fb.getCurrent());
        assertEquals("4", fb.toString());
        fb.next();
        assertEquals(5, fb.getCurrent());
        assertEquals("Buzz", fb.toString());
        fb.next();
        assertEquals(6, fb.getCurrent());
        assertEquals("Fizz", fb.toString());
        fb.next();
        assertEquals(7, fb.getCurrent());
        assertEquals("7", fb.toString());
        fb.next();
        assertEquals(8, fb.getCurrent());
        assertEquals("8", fb.toString());
        fb.next();
        assertEquals(9, fb.getCurrent());
        assertEquals("Fizz", fb.toString());
        fb.next();
        helperRun10to15(fb);
    }

    void helperRun10to15(FizzBuzz fb) {
        assertEquals(10, fb.getCurrent());
        assertEquals("Buzz", fb.toString());
        fb.next();
        assertEquals(11, fb.getCurrent());
        assertEquals("11", fb.toString());
        fb.next();
        assertEquals(12, fb.getCurrent());
        assertEquals("Fizz", fb.toString());
        fb.next();
        assertEquals(13, fb.getCurrent());
        assertEquals("13", fb.toString());
        fb.next();
        assertEquals(14, fb.getCurrent());
        assertEquals("14", fb.toString());
        fb.next();
        assertEquals(15, fb.getCurrent());
        assertEquals("ClassworksCSII.FizzBuzz", fb.toString());
    }

    @Test
    void testDefaultStart() {
        FizzBuzz fb = new FizzBuzz();
        helperRun1to15(fb);
    }

    @Test
    void testZeroStart() {
        FizzBuzz fb = new FizzBuzz(0);
        helperRun1to15(fb);
    }

    @Test
    void testNegativeStart() {
        FizzBuzz fb = new FizzBuzz(-1);
        helperRun1to15(fb);
    }

    @Test
    void testArbitraryStart() {
        FizzBuzz fb = new FizzBuzz(10);
        helperRun10to15(fb);
    }

    //*********** Is This how to TEST??? **************
    public static void main(String[] args)
    {   System.out.println("What Number would you like to start with?\t");
        Scanner fbInput = new Scanner(System.in);
        int fbNumber = Integer.parseInt(fbInput.nextLine());
        FizzBuzzTest tester = new FizzBuzzTest();
        FizzBuzz fbTester = new FizzBuzz(fbNumber);
            // Helper Functions
        //tester.helperRun1to15(fbTester);
        //tester.helperRun10to15(fbTester);
            // @Tests
        tester.testArbitraryStart();
        tester.testDefaultStart();
        tester.testNegativeStart();
        tester.testZeroStart();
    }

}

