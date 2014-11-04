package assignment8;

//********************************************************************
//  The ExpressionTree class that extends the BinaryTree class
//********************************************************************

import java.util.*;

public class ExpressionTree<E extends Comparable<E>>
        extends BinaryTree<E> {

    /**
     * Creates an empty ExpressionTree.
     */
    public ExpressionTree()
    {
        super();
    }

    /**
     * Creates an ExpressionTree from a single operand.
     * This would be for an expression with no operator.
     *
     * @param element     the expression tree for the center
     */
    public ExpressionTree(E element)
    {
        root = createNewNode(element);
        root.left = null;
        root.right = null;
    }

    /**
     * Creates an ExpressionTree from the three expression elements.
     * This would be for a tree with the operator at the center and
     * two operands on either side.
     *
     * @param element1     the expression tree for the center
     * @param element2     the expression tree for the left subtree
     * @param element3     the expression tree for the right subtree
     */
    public ExpressionTree(E element1, E element2, E element3)
    {
        root = createNewNode(element1);
        root.left = createNewNode(element2);
        root.right = createNewNode(element3);
    }

    /**
     * Creates an ExpressionTree from an element and two specified
     * expression trees. This would be for an operator in the center
     * with two expressions on either side as the operands.
     *
     * @param element      the expression tree for the center
     * @param leftSubtree  the expression tree for the left subtree
     * @param rightSubtree the expression tree for the right subtree
     */
    public ExpressionTree(E element, ExpressionTree<E> leftSubtree,
                          ExpressionTree<E> rightSubtree)
    {
        root = createNewNode(element);
        root.left = (leftSubtree == null) ? null : leftSubtree.getRoot();
        root.right = (rightSubtree == null) ? null : rightSubtree.getRoot();
    }

    /**
     * Returns the element at the root of the tree.
     */
    public E getRootElement()
    {
        return (root == null) ? null : root.element;
    }

    /**
     * Returns the left node of the tree.
     */
    public ExpressionTree<E> getLeftNode()
    {
        return getTreeNode(root.left);
    }

    /**
     * Returns the right node of the tree.
     */
    public ExpressionTree<E> getRightNode()
    {
        return getTreeNode(root.right);
    }

    // Get's an ExpressionTree object from a Tree node
    private ExpressionTree<E> getTreeNode(TreeNode<E> root) {
        if (root == null)
            return null;
        return(new ExpressionTree<E>(root.element,
                getTreeNode(root.left),
                getTreeNode(root.right)));
    }

    /**
     * Returns the number of nodes in the tree
     */
    public int getSize()
    {
        int size = 0;
        Iterator<E> iterator = iterator();

        while (iterator.hasNext()) {
            iterator.next();
            ++size;
        }
        return size;
    }

    /**
     * Returns a string with the expression in infix notation
     * since the BinaryTree iterator uses inOrder traversal.
     */
    public String toString()
    {
        Iterator<E> iterator = iterator();
        String result = "";

        while (iterator.hasNext()) {
            result += iterator.next() + " ";
        }
        return result;
    }
}