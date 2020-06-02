package stack;

public class Main {

  public static void main(String[] args) {
   /* Array_Stack arrayStack = new Array_Stack(100);
    arrayStack.push(10);
    arrayStack.push(20);
    arrayStack.push(30);
    arrayStack.push(40);
    arrayStack.printStack();
    System.out.println("peek: " + arrayStack.peek() + "   size: " + arrayStack.size());
    arrayStack.pop();
    System.out.println("pop: " + arrayStack.peek() + "   size: " + arrayStack.size());
    arrayStack.printStack();*/
    
    System.out.println("-----------------------------------------------");
    
    LinkedList_Stack listStack = new LinkedList_Stack();
    listStack.push(10);
    listStack.push(20);
    listStack.push(30);
    System.out.println("peek: " + listStack.peek() + "   size: " + listStack.getSize());
    listStack.pop();
    System.out.println("pop and peek:  " + listStack.peek() + "   size: " + listStack.getSize());
    //listStack.printStack();
  }
}
