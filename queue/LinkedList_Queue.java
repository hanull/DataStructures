package queue;

import java.util.NoSuchElementException;

public class LinkedList_Queue<T> implements Queue<T>{
  private class Node<T>{
    private T data;
    private Node<T> next;
    
    public Node(T data) {
      this.data = data;
      this.next = null;
    }
  }
  private Node<T> front, rear;
  private int size;
  
  public LinkedList_Queue() {
    front = rear = null;
    size = 0;
  }
  @Override
  public void enqueue(T data) {
    Node<T> tmp = new Node<T>(data);
    if (rear != null) {
      rear.next = tmp;
    }
    rear = tmp;
    size++;
    if (front==null) {
      front = rear;
    }
  }

  @Override
  public T dequeue() {
    if (isEmpty())
      throw new NoSuchElementException();
    T data = peek();
    front = front.next;
    size--;
    if (front==null) {
      rear=null;
    }
    return data;
  }

  @Override
  public T peek() {
    if (isEmpty())
      throw new NoSuchElementException();
    return (front.data);
  }

  @Override
  public boolean isEmpty() {
    return (size==0);
  }
  
  public int getSize() {
    return (size);
  }
}
