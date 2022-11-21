package binaryEasy;
// https://leetcode.com/problems/subtree-of-another-tree/
public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode(11);
        TreeNode nodeB = new TreeNode(12);
        TreeNode nodeC = new TreeNode(13);
        TreeNode nodeD = new TreeNode(14);
        TreeNode node1 = new TreeNode(6, nodeA,nodeB);
        TreeNode node2 = new TreeNode(7,nodeC, nodeD);
        TreeNode root = new TreeNode(5, node1, node2);
        System.out.println(root);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root.val == subRoot.val){
            isSubtree(root.left,subRoot.left);
            isSubtree(root.right, subRoot.right);
        }
        return false;
    }
}
