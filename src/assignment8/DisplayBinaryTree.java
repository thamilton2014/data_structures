package assignment8;
/**
 * Course: CS 3401
 * Section: .....
 * Name: Thomas Hamilton
 * Professor: Alan Shaw
 * Assignment #: 8
 * */

//********************************************************************
//  An Application for displaying Binary Search Tree nodes
//********************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayBinaryTree extends JPanel {
    private BinaryTree<Integer> tree; // A binary tree to be displayed

    private JTextField jtfKey = new JTextField(5);
    private TreeView view = new TreeView();
    private JButton jbtInsert = new JButton("Insert");
    private JButton jbtDelete = new JButton("Delete");

    /**
     * Add three new buttons
     * Show Inorder
     * Show Preorder
     * Show Postorder
     */
    private JButton jbtInorder = new JButton("Show Inorder");
    private JButton jbtPreorder = new JButton("Show Preorder");
    private JButton jbtPostorder = new JButton("Show Postorder");

    /** Construct a view for a binary tree */
    public DisplayBinaryTree(BinaryTree<Integer> tree) {
        this.tree = tree; // Set a binary tree to be displayed
        setPreferredSize (new Dimension(800, 400));
        setUI();
    }

    /** Initialize UI for binary tree */
    private void setUI() {
        this.setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter a key: "));
        panel.add(jtfKey);
        panel.add(jbtInsert);
        panel.add(jbtDelete);

        /**
         * Add to layout
         */
        panel.add(jbtInorder);
        panel.add(jbtPreorder);
        panel.add(jbtPostorder);

        add(panel, BorderLayout.SOUTH);

        jbtInorder.addActionListener(new ActionListener() {
            protected String inorder(BinaryTree.TreeNode<Integer> root) {
                String result = "";
                if (root == null) return "";
                result += inorder(root.left);
                System.out.print(root.element + " ");
                result += root.element;
                result += inorder(root.right);
                return " " + result + " ";
            }
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Inorder list is: " + inorder(tree.root));
            }
        });

        jbtPreorder.addActionListener(new ActionListener() {
            protected String preorder(BinaryTree.TreeNode<Integer> root) {
                String result = "";
                if (root == null) {
                    return "";
                }
                System.out.print(root.element + " ");
                result += root.element;
                result += preorder(root.left);
                result += preorder(root.right);
                return " " + result;
            }
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Preorder list is: " + preorder(tree.root));
            }
        });

        jbtPostorder.addActionListener(new ActionListener() {
            protected String postorder(BinaryTree.TreeNode<Integer> root) {
                String result = "";
                if (root == null) {
                    return "";
                }
                result += postorder(root.left);
                result += postorder(root.right);
                result += root.element;
                System.out.print(root.element + " ");
                return result + " ";
            }
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Postorder list is: " + postorder(tree.root));
            }
        });

        jbtInsert.addActionListener(new ActionListener() {
            @Override  // Process the Insert button event
            public void actionPerformed(ActionEvent e) {
                int key = Integer.parseInt(jtfKey.getText());
                if (tree.search(key)) { // key is in the tree already
                    JOptionPane.showMessageDialog(null,
                            key + " is already in the tree");
                }
                else {
                    tree.insert(key); // Insert a new key
                    view.repaint(); // Redisplay the tree
                }
            }
        });

        jbtDelete.addActionListener(new ActionListener() {
            @Override  // Process the Delete button event
            public void actionPerformed(ActionEvent e) {
                int key = Integer.parseInt(jtfKey.getText());
                if (!tree.search(key)) { // key is not in the tree
                    JOptionPane.showMessageDialog(null,
                            key + " is not in the tree");
                }
                else {
                    tree.delete(key); // Delete a key
                    view.repaint(); // Redisplay the tree
                }
            }
        });
    }



    // Inner class TreeView for displaying a tree on a panel
    class TreeView extends JPanel {
        private int radius = 20; // Tree node radius
        private int vGap = 50; // Gap between two levels in a tree

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (tree.getRoot() != null) {
                // Display tree recursively

                displayTree(g, tree.getRoot(), getWidth() / 2, 30,
                        getWidth() / 4);
            }
        }

        /** Display a subtree rooted at position (x, y) */
        private void displayTree(Graphics g,
                                 BinaryTree.TreeNode<Integer> root,
                                 int x, int y, int hGap) {
            // Display the root
            g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
            g.drawString(root.element + "", x - 6, y + 4);

            if (root.left != null) {
                // Draw a line to the left node
                connectTwoCircles(g, x - hGap, y + vGap, x, y);
                // Draw the left subtree recursively
                displayTree(g, root.left, x - hGap, y + vGap, hGap / 2);
            }

            if (root.right != null) {
                // Draw a line to the right node
                connectTwoCircles(g, x + hGap, y + vGap, x, y);
                // Draw the right subtree recursively
                displayTree(g, root.right, x + hGap, y + vGap, hGap / 2);
            }
        }

        /** Connect two circles centered at (x1, y1) and (x2, y2) */
        private void connectTwoCircles(Graphics g,
                                       int x1, int y1, int x2, int y2) {
            double d = Math.sqrt(vGap * vGap + (x2 - x1) * (x2 - x1));
            int x11 = (int)(x1 - radius * (x1 - x2) / d);
            int y11 = (int)(y1 - radius * (y1 - y2) / d);
            int x21 = (int)(x2 + radius * (x1 - x2) / d);
            int y21 = (int)(y2 + radius * (y1 - y2) / d);
            g.drawLine(x11, y11, x21, y21);
        }
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Display Binary Tree");
        frame.add(new DisplayBinaryTree(new BinaryTree<Integer>()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}