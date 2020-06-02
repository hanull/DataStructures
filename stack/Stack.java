package stack;

public interface Stack {
  void push(Object data);
  Object pop();
  Object peek();
  boolean isEmpty();
}
