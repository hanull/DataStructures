package stack;

import java.util.EmptyStackException;

class Node{
  private Object data;
  public Node next;
  
  public Node(Object data) {
    this.data = data;
    this.next = null;
  }
  
  public Object getData() {
    return (this.data);
  }
}

public class LinkedList_Stack implements Stack{  
  private Node top;
  private Node bottom;
  private int stackSize;
  
  public LinkedList_Stack() {
    top = null;
    bottom = null;
    stackSize = 0;
  }
  
  @Override
  public void push(Object data) {
    Node newNode = new Node(data);
    if (isEmpty()) {
      top = newNode;
      bottom = top;
    }else {
      newNode.next = top;
      top = newNode;
    }
    stackSize++;
  }

  @Override
  public Object pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }else {
      Object data = peek();
      if (top == bottom) {
        top = bottom = null;
      }else {
        top = top.next;
      }
      stackSize--;
      return (data);
    }
  }

  @Override
  public Object peek() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Stack is Empty!");
    }else {
      return (top.getData());
    }
  }

  @Override
  public boolean isEmpty() {
    return (stackSize == 0);
  }
  
  public int getSize() {
    return (stackSize);
  }
}
