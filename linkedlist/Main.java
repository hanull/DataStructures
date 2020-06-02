package linkedlist;

public class Main {

  public static void main(String[] args) {
    LinkedList numbers = new LinkedList();
    numbers.addFirst(30);
    numbers.addFirst(20);
    numbers.addFirst(10);
    numbers.addFirst(6);
    numbers.addNode(4, 95);
    // 6 10 20 30 95 
    
    
    numbers.deleteFirst();
    numbers.deleteLast();
    numbers.printList(); // 10 20 30
    numbers.deleteNode(3);
    numbers.printList(); // 10 30
  }
}
