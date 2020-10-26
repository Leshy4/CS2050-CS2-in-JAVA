/**             SELECTION SORT              SLOW ALGORITHM - Looks for Minimum Value & searches n^2 times */
import java.util.Arrays;

public class SelectionSort {            // Selection sort algorithm ==  Big O= O(n^2)
    public static void selectionSort(int data[]) {    // Find min in array, insert at data[i] & i++.
        int i = 0;      // i == Number Of Sorted Elements
        for (int j = 0; j < data.length; j++) {     // j == Holds Sorted Index
            int min = j;                            //min,j=0 //k=1
            for (int k = j + 1; k < data.length; k++)   // k == Looks for new minimum
                if (data[k] < data[min]) // New Minimum?
                    min = k;             // Swap values & continue searching
            int temp = data[i];          //Search rest of Array
            data[i] = data[min];                //Swap Values
            data[min] = temp;
            i++;                                // sortedArray++
        }
    }

    public static void main(String[] args) {
        int data[] = {13, 12, 84, 79, 10, 77, 56, 1, 34, 27, 3};
        System.out.println(Arrays.toString(data));
        selectionSort(data);
        System.out.println(Arrays.toString(data));
    }
}