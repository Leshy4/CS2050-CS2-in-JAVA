package PostfixEvaluationP; /* Student: Christopher Welch
 * CS2050 - Computer Science II      * Description: Homework 05 - PostfixEvaluation      */

public class PostfixEvaluation {
    static final int INVALID_OP = 0;
    static final int ADD_OP = 1;
    static final int SUB_OP = 2;
    static final int MUL_OP = 3;
    static final int DIV_OP = 4;

    // returns true/false depending whether the given symbol is an operand
    public static boolean isOperand(String symbol) {
        try {
            Integer.parseInt(symbol);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    // returns the operand associated with the given symbol; 0 if symbol is not a valid operand
    public static int getOperand(String symbol) {
        if (isOperand(symbol))
            return Integer.parseInt(symbol);
        return 0;
    }

    // returns true/false depending whether the given symbol is an operator
    public static boolean isOperator(String symbol) {
        if (symbol.length() > 1)
            return false;
        char c = symbol.charAt(0);
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // returns the operator code associated with the given symbol; INVALID_OP if symbol is not a valid operator
    public static int getOperator(String symbol) {
        if (!isOperator(symbol))
            return INVALID_OP;
        char c = symbol.charAt(0);
        if (c == '+')
            return ADD_OP;
        else if (c == '-')
            return SUB_OP;
        else if (c == '*')
            return MUL_OP;
        else
            return DIV_OP;
    }

    // TODO: finish the method's implementation
    public static int postfixEval(String exp) {
        DynamicStack stack = new DynamicStack();
        String symbols[] = exp.split(" ");
        int intBuffer1 = 0;
        int intBuffer2 = 0;
        int answerBuffer = 0;

        for (int i = 0; i < symbols.length; i++)
        {
            String symbol = symbols[i];

            if (isOperator(symbol)) {    // TODO: finish this part of the code...    //   !!! + - * /
                intBuffer2 = stack.pop();
                intBuffer1 = stack.pop();
                switch (getOperator(symbol)) {
                    case 0:
                        System.out.println("Invalid Operator.");
                        break;
                    case 1:
                        answerBuffer = (intBuffer1 + intBuffer2);
                        break;
                    case 2:
                        answerBuffer = (intBuffer1 - intBuffer2);
                        break;
                    case 3:
                        answerBuffer = (intBuffer1 * intBuffer2);
                        break;
                    case 4:
                        answerBuffer = (intBuffer1 / intBuffer2);
                        break;
                    default:
                        System.out.println("No Operation processed");
                        break;
                }
                stack.push(answerBuffer);
                intBuffer1 = 0;
                intBuffer2 = 0;
                System.out.println("Operation Complete:\t" + stack.peek());
            }

            if (isOperand(symbol)){   // TODO: finish this part of the code...    // #'s
                if (intBuffer1 == 0 && intBuffer2 == 0){
                    intBuffer1 = getOperand(symbol);
                }
                if (intBuffer1 != 0){
                    intBuffer2 = getOperand(symbol);
                }
                stack.push(getOperand(symbol));
            }

        } // For Loop End
            if (stack.size() != 1)
            {
                System.out.println("Couldn't evaluate expression!");
                System.exit(1);
            }
        //End For Loop
        return stack.peek();
    }   //End of postfixEval function

    public static void main (String[]args)
    {
        String expression = "4 3 + 5 2 - *";
        System.out.println("Result: " + postfixEval(expression));
    } // End Main
}   //End of Class       ???????????????

/**~~~~~~~~~~~~~~~CLASS NOTES~~~~~~~~~~Stacks~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*** STATIC ARRAY IMPLEMENTATION
    -Stack Capacity = How many elements a Stack can hold.
    -Maintains the Size of the Stack.
    -Where is TOP Index? A Pointer.
*** DYNAMIC IMPLEMENTATION  Resembles a Linked List
    -Has no Capacity because it is a Linked List                          */