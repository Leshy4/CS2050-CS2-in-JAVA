/** Student: Chris Welch         *CS2050 - Computer Science II - Spring 2020
  * Instructor: Thyago Mota      * Description: Homework 07 - PatienceSort           */
// Node<T>::    Node(T), T getData(), setData(T), getNext(), setNext(Node), toString()
// Stack<T>:: Node<T> top;     Stack(), push(T), T pop(), T peek(), isEmpty(), toString()
// LinkedList<T>:: Node<T> head;    LinkedList(), append(T), toString(), isEmpty(), size(), T get(int index), remove(index)
import java.util.Arrays;

public class PatienceSort {
    // the patience sort algorithm
    public static void patienceSort(int data[]) {
        boolean DEBUGGING = false;     // true = See the sorted Stacks
        LinkedList<Stack<Integer>> stacks = new LinkedList<>();    // this is the list of stacks (each a stack of integers)

        // TODO #1: loop through the data array and get the array's current element
        for(int x =0; x < data.length; x++) {
        // TODO #3: if there isn't a stack available, create a new one, push the data array's current element onto it,
        //  and then append the newly created stack to the list of stacks.
            if(stacks.isEmpty()){
                Stack<Integer> newStack = new Stack();
                newStack.push(data[x]);
                stacks.append(newStack);
            }
            else{
        // TODO #2: at each iteration, find a stack available and push the array's current element onto it
               int j =0;
               while(j < stacks.size()){   //Add Value to Stack
                   if(stacks.get(j).peek() > data[x]){
                       stacks.get(j).push(data[x]);
                       j = stacks.size();
                   }
                   if(j == stacks.size()-1){ //Add Stack w/Value to stack(s)
                       Stack<Integer> newStack = new Stack();
                       newStack.push(data[x]);
                       stacks.append(newStack);
                       j = stacks.size();
                   }
                   else j++;
               }
            }
            if(DEBUGGING)System.out.println(stacks.toString());
        }

        // merge of stacks
        if (stacks.isEmpty())
            return;
        for (int i = 0; i < data.length; i++) {
            Stack<Integer> stackMin = stacks.get(0);
            int j = 0;
            for (int k = 1; k < stacks.size(); k++) {
                Stack<Integer> stackCurrent = stacks.get(k);
                if (stackCurrent.peek() < stackMin.peek()) {
                    stackMin = stackCurrent;
                    j = k;
                }
            }
            data[i] = stackMin.pop();
            if (stackMin.isEmpty())
                stacks.remove(j);
        }
    }

    public static void main(String[] args) {
        int data[] = {13, 12, 84, 79, 10, 77, 56, 1, 34, 27, 3};
        System.out.println(Arrays.toString(data));
        patienceSort(data);
        System.out.println(Arrays.toString(data));
    }
}