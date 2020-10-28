/**  Binary Search     O(logn) -- One of the Fastest Searching methods (Only on Sorted Arrays)
    1D BinSearch:: if(searchNum < array[num]) searchLeftHalf || if(searchNum > array[num]) searchRightHalf

          2D BinSearch => 2dArray[Y,X] <== USE INSTEAD:: 2dArray[rows,cols]
 Start @ BottomLeft= [rows-1 , 0] && if(searchNum < array[num]) MoveUp || if(searchNum > array[num]) MoveRight
     ||  TopRight= [0 , cols-1]   && if(searchNum < array[num]) MoveLeft || if(searchNum > array[num]) MoveDown       */


import java.util.*;

public class BinarySearch {

    static boolean bsearch(int data[], int left, int right, int numberBeingSearched) {

// BASE CASE: Didn't find value. WouldBeIndex->(left == right), THEN->ValueNotFound==(left>right)
        if (left > right || left < 0 || right < 0 
         || left >= data.length || right >= data.length)
            return false;

        // get the middle element
        int middle = (left + right) / 2;  // or left + (right - left) / 2

        // is middle the element we are searching for?
        if (data[middle] == numberBeingSearched)
            return true;

        // base case #2
        if (left == right)
            return false;

        // is the element greater than middle -> go right then
        if (numberBeingSearched > data[middle])
            return bsearch(data, middle + 1, right, numberBeingSearched);

        // if not, go left
        return bsearch(data, left, middle - 1, numberBeingSearched);
    }

    public static void main(String[] args) {
        int data[] = new int[100];
        Random r = new Random();
        for (int i = 0; i < 100; i++)
            data[i] = r.nextInt(100);
        Arrays.sort(data); // in-place sort available from Arrays class
        if (bsearch(data, 0, data.length - 1, 27))
            System.out.println("Found!");
        else
            System.out.println("Not found!");
    }
}
