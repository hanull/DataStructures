package queue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Stack_Queue<T> implements Queue<T>{
  Stack<T> newStack, oldStack;
  public Stack_Queue() {
    newStack = new Stack<>();
    oldStack = new Stack<>();
  }
  
  @Override
  public void enqueue(T data) {
    newStack.add(data);
  }

  @Override
  public T dequeue() {
    if(isEmpty()) {
      throw new NoSuchElementException();
    }
    shiftStack();
    return oldStack.pop();
  }

  @Override
  public T peek() {
    if(isEmpty()) {
      throw new NoSuchElementException();
    }
    shiftStack();
    return oldStack.peek();
  }

  @Override
  public boolean isEmpty() {
    return (oldStack.size()==0 && newStack.size()==0);
  }
  
  public void shiftStack() {
    if (oldStack.isEmpty()) { // oldStack이 비어있을 경우에만
      while(!newStack.isEmpty()) {
        oldStack.push(newStack.pop());
      }
    }
  }
  
  public int getSize() {
    return (newStack.size() + oldStack.size());
  }
}
