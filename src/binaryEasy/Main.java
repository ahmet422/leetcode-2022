package binaryEasy;

public class Main {
    public static void main(String[] args) {

     Node root = new Node(8);
     Node n1 = new Node(7);
     Node n2 = new Node(5);
     Node n3 = new Node(6);
     Node n4 = new Node(9);
     Node n5 = new Node(10);
     Node n6 = new Node(11);

     root.left = n1;
     n1.left = n2;
     n1.right = n3;

     root.right = n5;
     n5.left = n4;
     n5.right = n6;

     BinaryTree bt = new BinaryTree();
     bt.root = root;
     bt.traverseInOrderWithoutRecursion();

    }
}
