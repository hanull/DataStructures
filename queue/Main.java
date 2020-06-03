package queue;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Array_Queue<Integer> arrayQueue = new Array_Queue(100);
    arrayQueue.enqueue(10);
    arrayQueue.enqueue(20);
    arrayQueue.enqueue(30);
    arrayQueue.print();
    System.out.println("큐 사이즈: "+arrayQueue.getSize());
    System.out.println("dequeue : " + arrayQueue.dequeue());
    System.out.println("큐 사이즈: "+arrayQueue.getSize());
    arrayQueue.print();
  }
}
