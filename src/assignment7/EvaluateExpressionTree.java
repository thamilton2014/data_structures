package assignment7;
/**
 * Thomas Hamilton
 * CS3401
 * Professsor Alan Shaw
 */
import java.math.BigDecimal;
import java.util.*;

//********************************************************************
// Evaluates a given expression by first converting it to a
// Postfix Stack and then to an Expression Tree and then
// evaluating the Expression Tree
//********************************************************************

public class EvaluateExpressionTree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an equation in infix notation: " +
                "[Ex: 10+6/3 ]");
        String expression = input.nextLine();
        input.close();

        try {
            System.out.println("Result = " +
                    evaluateExpressionTree(expression).
                            stripTrailingZeros().toPlainString());
        } catch (Exception ex) {
            System.out.println("Bad expression");
        }
    }

    // Converts an expression String into an expresstion Tree
    //   and evaluates it and returns the answer as a BigDecimal
    public static BigDecimal evaluateExpressionTree(String expression) {
        // Create a postfix operandStack of the expression String
        Stack<String> pStack = new ConvertExpression(expression).
                getPostfixStack();

        System.out.println(pStack);

        // Convert the postfix stack to a an expression tree
        ExpressionTree<String> tree = convertTree(pStack);

        // Evaluate the expression tree
        return evaluateExpressionTree(tree);
    }

    // Takes a postfix stack of strings and returns an ExpressionTree
    public static ExpressionTree<String> convertTree(Stack<String> stack) {
        // Your code goes here
        if ( stack.isEmpty())
            return null;

        String token = stack.pop();

        if ( isOp(token )) {
            ExpressionTree<String> rightTree = convertTree(stack);
            ExpressionTree<String> leftTree = convertTree(stack);
            return new ExpressionTree(token, leftTree, rightTree);
        } else
        return new ExpressionTree(token);
    }

    // Takes an ExpressionTree and evalutates it and returns a BigDecimal
    public static BigDecimal evaluateExpressionTree(ExpressionTree<String> tree) {
        // Your code goes here
        if (tree == null || tree.isEmpty()) {
            return null;
        }

        String token = tree.getRootElement();

        if (isOp(token)) {
            BigDecimal b = evaluateExpressionTree(tree.getRightNode());
            BigDecimal a = evaluateExpressionTree(tree.getLeftNode());
            return doOperation(token, a, b);
        } else
            return new BigDecimal(token);
    }

    // Takes a token operator and two operands, evaluates them and
    //returns a BigDecimal
    public static BigDecimal doOperation(String token, BigDecimal a, BigDecimal b) {
        // Your code goes here
        if (token.equals("*"))
            return a.multiply(b);
        if (token.equals("/"))
            return a.divide(b, 12, BigDecimal.ROUND_HALF_UP);
        if (token.equals("+"))
            return a.add(b);
        return a.subtract(b);
    }

    // Takes a token string and checks if it is an operator
    public static boolean isOp(String token) {
        // Your code goes here
        return token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-");
    }
}