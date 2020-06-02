package stack;

public class Array_Stack implements Stack{
  private int maxSize;
  private int index;
  private Object[] stackArray;
  
  public Array_Stack(int maxSize) {
    this.maxSize = maxSize;
    this.index = 0;
    stackArray = new Object[maxSize];
  }
  
  @Override
  public void push(Object data) {
    if (index < maxSize) {
      stackArray[index] = data;
      index++;
    }else {
      throw new IndexOutOfBoundsException("Stack is FULL!!!");
    }
  }

  @Override
  public Object pop() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Empty stack");
    }else {
      Object res = peek();
      stackArray[index-1] = null;
      index--;
      return (res);
    }
  }

  @Override
  public Object peek() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Empty stack");
    }else {
      Object res = stackArray[index - 1];
      return (res);
    }
  }

  @Override
  public boolean isEmpty() {
    return (index == 0);
  }

  public void empty() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Stack is already empty");
    }else {
      stackArray = new Object[100];
    }
  }
  
  public void printStack() {
    if (isEmpty()) {
      System.out.println("Stack is empty");
    }else {
      int i=0;
      while(stackArray[i] != null) {
        System.out.println(stackArray[i]);
        i++;
      }
    }
  }
  
  public int size() {
    if (isEmpty()) {
      return 0;
    }else {
      return (index);
    }
  }
}
