package queue;

public class Main {

  public static void main(String[] args) {
    System.out.println("--------------Array_Queue-------------------------");
    Array_Queue<Integer> arrayQueue = new Array_Queue(100);
    arrayQueue.enqueue(10);
    arrayQueue.enqueue(20);
    arrayQueue.enqueue(30);
    System.out.println("큐 사이즈: "+arrayQueue.getSize());
    System.out.println("dequeue : " + arrayQueue.dequeue());
    System.out.println("큐 사이즈: "+arrayQueue.getSize());
    System.out.println("--------------Stack_Queue-------------------------");
    Stack_Queue<Integer> stackQueue = new Stack_Queue<>();
    stackQueue.enqueue(10);
    stackQueue.enqueue(20);
    System.out.println("큐 사이즈 : " + stackQueue.getSize());
    while(!stackQueue.isEmpty()) {
      System.out.println("dequeue : "+stackQueue.dequeue());
    }
    System.out.println("큐 사이즈 : " + stackQueue.getSize());
    System.out.println("--------------Linkedlist_Queue-------------------------");
    LinkedList_Queue<Integer> linkedlistStack = new LinkedList_Queue<>();
    linkedlistStack.enqueue(10);
    linkedlistStack.enqueue(20);
    System.out.println("큐 사이즈 : " + linkedlistStack.getSize());
    System.out.println("dequeue : "+linkedlistStack.dequeue());
    System.out.println("큐 사이즈 : " + linkedlistStack.getSize());
  }
}
