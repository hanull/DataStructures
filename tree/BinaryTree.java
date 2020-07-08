package tree;

class Node<T>{
  T data;
  Node<T> left;
  Node<T> right;
}

public class BinaryTree<T> {
  public Node<T> root; 
  
  public void setRoot(Node<T> node) {
    this.root = node;
  }
  
  public Node<T> getRoot(){
    return root;
  }
  
  public Node<T> makeNode(Node<T> left, Node<T> right, T data) {
    Node<T> newNode = new Node<T>();
    newNode.left = left;
    newNode.right = right;
    newNode.data = data;
    return newNode;
  }
  
  public void inOrderTraversal(Node<T> node) {
    if(node != null) {
      inOrderTraversal(node.left);
      visit(node);
      inOrderTraversal(node.right);
    }
  }
  
  public void preOrderTraversal(Node<T> node) {
    if(node != null) {
      visit(node);
      preOrderTraversal(node.left);
      preOrderTraversal(node.right);
    }
  }

  public void postOrderTraversal(Node<T> node) {
    if(node != null) {
      postOrderTraversal(node.left);
      postOrderTraversal(node.right);
      visit(node);
    }
  }
  
  public void visit(Node<T> node) {
    System.out.print(node.data + " ");
  }
}
