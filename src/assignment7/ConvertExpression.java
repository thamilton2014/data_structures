package assignment7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//********************************************************************
// A Class that converts a Infix expression String into a
//   Prefix stack and Postfix stack
//********************************************************************

public class ConvertExpression {
    Stack<String> prefixStack;
    Stack<String> postfixStack;

    public ConvertExpression(String expression) {
        // Create an stack of strings to hold the prefix expression
        prefixStack = new Stack<String>();
        // Create an stack of strings to hold the postfix expression
        postfixStack = new Stack<String>();

        // Put spaces to the left and right of each operator in the expression
        expression = insertBlanks(expression);

        // Store operands and operators into an array of tokens
        String[] tokens = expression.split("\\s+");

        // Convert the tokens into a prefix stack
        convertToPrefix(tokens);

        // Convert the prefix stack into a postfix stack
        convertToPostfix();
    }

    // Returns the prefix stack
    public Stack<String> getPrefixStack() {
        return prefixStack;
    }

    // Returns the postfix stack
    public Stack<String> getPostfixStack() {
        return postfixStack;
    }

    // Converts an infix array into the prefixStack field
    private void convertToPrefix(String[] infix) {
        Stack<String> opStack = new Stack<String>();
        Collections.reverse(Arrays.asList(infix));

        opStack.push("#");
        for (String symbol : infix) {
            if (symbol.length() == 0)
                continue;
            if (!isOp(symbol) && !isPar(symbol)) {
                prefixStack.push(symbol);
            } else if (isClosePar(symbol)) {
                opStack.push(symbol);
            } else if (isOp(symbol)) {
                while(higherPrec(opStack.peek(),symbol))
                    prefixStack.push(opStack.pop());
                opStack.push(symbol);
            } else if (isOpenPar(symbol)) {
                while (!isClosePar(opStack.peek()))
                    prefixStack.push(opStack.pop());
                opStack.pop();
            }
        }
        while (!opStack.isEmpty() && !opStack.peek().equals("#"))
            prefixStack.push(opStack.pop());
        Collections.reverse(prefixStack);
    }

    // Converts the prefixStack field into the postfixStack field
    private void convertToPostfix() {
        List<String> prefixList = new ArrayList<String>();
        prefixList.addAll(prefixStack);
        Stack<String> opStack = new Stack<String>();

        for (String symbol : prefixList) {
            if (isOp(symbol)) {
                opStack.push(symbol);
            } else {
                postfixStack.push(symbol);
                while (!opStack.isEmpty() && opStack.peek().equals("#")) {
                    opStack.pop();
                    postfixStack.push(opStack.pop());
                }
                opStack.push("#");
            }
        }
    }

    // Determines if a given token is a close parenthesis
    private boolean isClosePar(String token) {
        return token.equals(")");
    }

    // Determines if a given token is a open parenthesis
    private boolean isOpenPar(String token) {
        return token.equals("(");
    }

    // Determines if a given token is a parenthesis
    private boolean isPar(String token) {
        return (isClosePar(token) || isOpenPar(token));
    }

    // Determines if a given token is a higher precedence operator
    private boolean isHigherPrec(String token) {
        return (token.equals("*") || token.equals("/"));
    }

    // Determines if one operator's precedence is higher than the other
    private boolean higherPrec(String op1, String op2) {
        return (isHigherPrec(op1) && !isHigherPrec(op2));
    }

    // Determines if a given token is an operator
    private boolean isOp(String token) {
        return token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/");
    }

    // Inserts blanks into a given expression string
    private String insertBlanks(String str) {
        // Create an empty string to hold the result
        String result = "";

        // For the length of the string
        for (int i = 0; i < str.length(); i++) {
            // If the current char is a (, ), +, -, * or /
            if (str.charAt(i) == '(' || str.charAt(i) == ')' ||
                    str.charAt(i) == '+' || str.charAt(i) == '-' ||
                    str.charAt(i) == '*' || str.charAt(i) == '/') {
                // Append the current char to the result string
                //   with a space in front and behind it
                result += " " + str.charAt(i) + " ";
            } else {  // The current char is a number
                // Append the current char to the result string
                result += str.charAt(i);
            }
        }
        // Return the result string
        return result;
    }
}