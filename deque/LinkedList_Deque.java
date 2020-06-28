package deque;

import java.util.NoSuchElementException;

public class LinkedList_Deque<T> implements Deque<T>{
  private Node front;
  private Node rear;
  private int size = 0;
  
  private class Node{
    private Node prev;
    private Node next;
    private T data;
    
    public Node(T data) {
      prev = next = null;
      this.data = data;
    }
  }

  @Override
  public void offerFirst(T data) {
    Node newNode = new Node(data);
    size++;
    if (front == null) {
      rear = front = newNode;
    }else {
      newNode.next = front;
      front.prev = newNode;
      front = newNode;
    }
  }

  @Override
  public void offerLast(T data) {
    Node newNode = new Node(data);
    size++;
    if (front == null) {
      front = rear = newNode;
    }else {
      rear.next = newNode;
      newNode.prev = rear;
      rear = newNode;
    }
  }
  
  @Override
  public T pollFirst() {
    if (front == null) {
      throw new NoSuchElementException();
    }
    T data = front.data;
    front = front.next;
    size--;
    return data;
  }

  @Override
  public T pollLast() {
    if (front == null) {
      throw new NoSuchElementException();
    }
    T data = rear.data;
    rear = rear.prev;
    rear.next = null;
    size--;
    return data;
  }

  @Override
  public T peekFirst() {
    if (front == null) {
      throw new NoSuchElementException();
    }
    return front.data;
  }

  @Override
  public T peekLast() {
    if (front == null) {
      throw new NoSuchElementException();
    }
    return rear.data;
  }

  @Override
  public int getSize() {
    return size;
  }
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    for(Node node = front; node != null; node=node.next) {
      builder.append(node.data);
      if (node.next != null) {
        builder.append(",");
      }
    }
    builder.append("]");
    return builder.toString();
  }

}
