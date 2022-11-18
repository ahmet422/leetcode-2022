package binaryEasy;
//https://leetcode.com/problems/invert-binary-tree/

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode(11);
        TreeNode nodeB = new TreeNode(12);
        TreeNode nodeC = new TreeNode(13);
        TreeNode nodeD = new TreeNode(14);
        TreeNode node1 = new TreeNode(6, nodeA,nodeB);
        TreeNode node2 = new TreeNode(7,nodeC, nodeD);
        TreeNode root = new TreeNode(5, node1, node2);
        System.out.println(root);
        System.out.println(invertTree(root));;

    }
    public static TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }

    public static void invertTreeHelper(TreeNode root) {

        if(root == null) return;

        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
    }
}
