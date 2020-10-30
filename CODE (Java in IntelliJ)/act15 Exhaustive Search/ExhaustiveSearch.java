public class ExhaustiveSearch {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    static void search(int n) {
        DynamicStack<String> stack = new DynamicStack<>();
        for (int i = ALPHABET.length() - 1; i >= 0; i--) {  //Load Alphabet on Stack    26--
            char c = ALPHABET.charAt(i);
            stack.push(c + ""); // zyxwvutsrqponmlkjihgfedcba
        }
        while (!stack.isEmpty()) {      //Print Alphabet by popping
            String str = stack.pop();
            if (str.length() == n)      // n == 5
                System.out.println(str);
            else
                for (int i = ALPHABET.length() - 1; i >= 0; i--) { // zyxwv utsrq pqonm lkjih gfedc ab
                    char c = ALPHABET.charAt(i);
                    stack.push(str + c);
                }
        }
    }

    public static void main(String[] args) {
        search(5);
    }
}
