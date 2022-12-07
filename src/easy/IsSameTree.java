package easy;

public class IsSameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode pLeft = new TreeNode(2);
        TreeNode pRight = new TreeNode(3);
        p.left = pLeft;
        p.right = pRight;

        TreeNode q = new TreeNode(1);
        TreeNode qLeft = new TreeNode(2);
        TreeNode qRight = new TreeNode(3);
        q.left = qLeft;
        q.right = qRight;
        
        System.out.println(isSameTree(p,q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q!= null){
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) || isSameTree(p.right,q.right);
        }
        return true;
    }
}
