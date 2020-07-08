package tree;

public class Main {

  public static void main(String[] args) {
    BinaryTree<Integer> tree = new BinaryTree<>();
    Node<Integer> n5 = tree.makeNode(null, null, 5);
    Node<Integer> n4 = tree.makeNode(null, null, 4);
    Node<Integer> n3 = tree.makeNode(null, null, 3);
    Node<Integer> n2 = tree.makeNode(n4, n5, 2);
    Node<Integer> n1 = tree.makeNode(n2, n3, 1);
    tree.setRoot(n1);
    System.out.print("inorder : ");
    tree.inOrderTraversal(tree.getRoot());
    System.out.println();
    
    System.out.print("preorder : ");
    tree.preOrderTraversal(tree.getRoot());
    System.out.println();
    
    System.out.print("postorder : ");
    tree.postOrderTraversal(tree.getRoot());
  }
}
