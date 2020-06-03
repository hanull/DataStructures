package queue;

import java.util.NoSuchElementException;

public class Array_Queue<T> implements Queue<T>{
  private int queueSize;
  private int maxSize;
  private T arrayQueue[];
  private int front;
  private int rear;
  
  @SuppressWarnings("unchecked")
  public Array_Queue(int maxSize) {
    arrayQueue = (T[]) new Object[maxSize];
    this.maxSize = maxSize;
    this.front = -1;
    this.rear = -1;
    queueSize = 0;
  }
  
  @Override
  public void enqueue(T data) {
    if (isFull()) {
      throw new IndexOutOfBoundsException("Å¥°¡ ²Ë Ã¡½À´Ï´Ù.");
    }
    arrayQueue[++rear] = data;
    queueSize++;
  }

  @Override
  public T dequeue() {
    if(isEmpty()) {
      throw new NoSuchElementException();
    }
    queueSize--;
    return arrayQueue[++front];
  }

  @Override
  public T peek() {
    if(isEmpty()) {
      throw new NoSuchElementException();
    }
    return arrayQueue[front];
  }

  @Override
  public boolean isEmpty() {
    return (queueSize==0);
  }
  
  public boolean isFull() {
    return (rear==maxSize-1);
  }
  
  public void print() {
    for(int i=front+1; i<=rear; i++) {
      System.out.println(arrayQueue[i]);
    }
  }

  public int getSize() {
    return queueSize;
  }

}
