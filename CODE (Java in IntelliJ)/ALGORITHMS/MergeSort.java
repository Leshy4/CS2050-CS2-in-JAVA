
/**~~~~~~~~~~MERGE SORT~~~~~~~Classic Divide & Conquer    O(Logn) almost always, usually fastest
 MergeSort(int data[], int begin, int end) <= Recursively cuts arrays in half, until only 1 Element in data[]
 THEN==> Merge sortedArrays into an array of sortedArrays.size() * 2                                                                       */
import java.util.Arrays;

public class MergeSortSolved {

    public static void merge(int data[], int begin, int middle, int end) {  // Iteratively Merges Sorted Arrays
        int i = begin;                                                      // in order
        int j = middle + 1;
        int size = (end - begin) + 1;
        int sorted[] = new int[size];
        int k = 0;
        while (i <= middle && j <= end)
            if (data[i] < data[j])
                sorted[k++] = data[i++];
            else
                sorted[k++] = data[j++];
        while (i <= middle)
            sorted[k++] = data[i++];
        while (j <= end)
            sorted[k++] = data[j++];
        for (i = begin, k = 0; k < size; i++, k++)
            data[i] = sorted[k];
    }

    public static void mergeSort(int data[], int begin, int end) {
        if (begin >= end) return;       // base case (Breaks into data[sizeONE]), then recurse up
// DIVIDE
        int middle = begin + (end - begin) / 2;     // <== OPTIMIZED From:: int middle = (begin + end) / 2;
        mergeSort(data, begin, middle);             // ^Prone to Overflow ^ do as Implemented for !Vflag
        mergeSort(data, middle + 1, end);
// & CONQUER (merge)
        merge(data, begin, middle, end);
    }

    public static void main(String[] args) {

        int data[] = {13, 12, 84, 79, 10, 77, 56, 1, 34, 27, 3};
        System.out.println(Arrays.toString(data));
        mergeSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }
}