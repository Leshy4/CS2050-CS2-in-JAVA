/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Motaimport java.util.*;
 * Description: Activity 22 - SortingObjectsSol class
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortingObjectsSol {

    private static final String NAMES_FILENAME = "names.txt";

    // Merge 2 lists returning a new list with the elements sorted
    public static LinkedList<Student> merge(LinkedList<Student> left, LinkedList<Student> right) {
        int i = 0, j = 0;
        LinkedList<Student> sorted = new LinkedList<>();
        while (i < left.size() && j < right.size()) {
            Student leftStudent  = left.get(i);
            Student rightStudent = right.get(j);
            if (leftStudent.compareTo(rightStudent) < 0) {  // Empties 1 list or the other i | j
                sorted.append(leftStudent);
                i++;
            }
            else {
                sorted.append(rightStudent);
                j++;
            }
        }
        while (i < left.size()) {                   // Append the rest if right list == isEmpty
            Student leftStudent  = left.get(i++);
            sorted.append(leftStudent);
        }
        while (j < right.size()) {                  // Append the rest if left list == isEmpty
            Student rightStudent  = right.get(j++);
            sorted.append(rightStudent);
        }
        left.clear();       // Clear Memory Location
        right.clear();
        return sorted;
    }

    // Merge sort using a linked list
    public static LinkedList<Student> mergeSort(LinkedList<Student> students) {
        if (students.size() <= 1)   // base case
            return students;

        // Divide the students list into two lists: left and right
        int middle = students.size() / 2;
        LinkedList<Student> left = new LinkedList<>();  // Left List
        for (int i = 0; i < middle; i++)
            left.append(students.get(i));
        LinkedList<Student> right = new LinkedList<>(); // Right List
        for (int i = middle; i < students.size(); i++)
            right.append(students.get(i));

        // Recursively call mergeSort w/ left and right linked lists
        left  = mergeSort(left);    // Break into Lists of 1
        right = mergeSort(right);   // Both Left, then Right Lists

        // Return the result of merging left and right linked lists
        return merge(left, right);  // Appends left || right & i++ || j++
    }

    public static void main(String[] args) throws FileNotFoundException {

        LinkedList<Student> students = new LinkedList<>();
        Scanner in = new Scanner(new FileInputStream(NAMES_FILENAME));
        int id = 1;
        while (in.hasNextLine()) {      // Read File & instantiate all as Students
            String name = in.nextLine();
            Student student = new Student(id, name);
            students.append(student);
            id++;
        }
        in.close();                     // Close File after read
        System.out.println(students);                               // Print Unsorted Student List
        LinkedList<Student> studentsSorted = mergeSort(students);   // SORT student list
        System.out.println(studentsSorted);                         // Print Sorted List
    }
}