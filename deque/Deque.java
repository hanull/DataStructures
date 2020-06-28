package deque;

public interface Deque<T> {
  void offerFirst(T data);
  void offerLast(T data);
  T pollFirst();
  T pollLast();
  T peekFirst();
  T peekLast();
  int getSize();
}
