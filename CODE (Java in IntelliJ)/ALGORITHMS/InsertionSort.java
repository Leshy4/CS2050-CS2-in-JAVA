/**      INSERTION SORT      ==>   How cards are sorted in ones hand.
// Partitions Sorted -> NonSorted  & Inserts Value in Sorted Order    // SORTED = O(n)    Unsorted = O(n^2)         */

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int data[]) {
        for (int i = 1; i < data.length; i++) {
            int j = i;
            int k = i - 1;
            while (k >= 0) {
                if (data[j] < data[k]) { //  (j=1 < k=0)?
                    int temp = data[j];
                    data[j] = data[k];  //Swap
                    data[k] = temp;     //Swap
                    j = k;
                    k--;
                }
                else break;
            }
        }
    }

    public static void main(String[] args) {
        int data[] = {13, 12, 84, 79, 10, 77, 56, 1, 34, 27, 3};
        System.out.println(Arrays.toString(data));
        insertionSort(data);
        System.out.println(Arrays.toString(data));
    }

}