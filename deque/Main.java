package deque;

public class Main {

  public static void main(String[] args) {
    LinkedList_Deque<Integer> deque = new LinkedList_Deque<Integer>();
    deque.offerFirst(9);
    deque.offerFirst(8);
    deque.offerFirst(7);
    deque.offerFirst(0);
    deque.offerLast(100);
    System.out.println(deque.toString());
    System.out.println("peekFirst: " + deque.peekFirst());
    System.out.println("peekLaster: " + deque.peekLast());
    System.out.println("size : " + deque.getSize());
    
    System.out.println("pollFirst: " + deque.pollFirst());
    System.out.println("pollLast: " + deque.pollLast());
    System.out.println("size : " + deque.getSize());
    System.out.println(deque.toString());
  }
}
