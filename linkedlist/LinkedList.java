package linkedlist;

public class LinkedList {
   private Node head;
   private Node tail;
   private int size = 0;
   
   private class Node{
     private Object data;
     private Node next;
     public Node(Object input) {
       this.data = input;
       this.next = null;
     }
     public String toString() {
       return String.valueOf(this.data);
     }
   }
   public void addFirst(Object input) {
     Node newNode = new Node(input);
     newNode.next = head;
     head = newNode;
     size++;
     if (head.next == null) {
       tail = head;
     }
   }
   public void addLast(Object input) {
     Node newNode = new Node(input);
     if (size == 0) {
       addFirst(input);
     }
     else {
       tail.next = newNode;
       tail = newNode;
       size++; 
     }
   }
   public Node searchNode(int idx) {
     int i = 0;
     Node res = head;
     while (i != idx) {
       res = res.next;
       i++;
     }
     return res;
   }
   public void addNode(int idx, Object input) {
     if (idx < 0)
        return ;
     if (idx == 0) {
       addFirst(input);
     }
     else if (idx >= size) {
       addLast(input);
     }
     else {
       Node newNode = new Node(input);
       Node preNode = searchNode(idx-1);
       Node nextNode = preNode.next;
       preNode.next = newNode;
       newNode.next = nextNode;
       size++;
     }
   }
   public void printList() {
     Node tmp = head;
     while (tmp != null) {
       System.out.print(tmp.data + " ");
       tmp = tmp.next;
     }
     System.out.println();
   }
   public void deleteFirst() {
     Node delNode = null;
     if (size == 0)
       return ;
     if (size == 1) {
       head = null;
       tail = null;
       size = 0;
     }else {
       delNode = head;
       Node tmp = delNode.next;
       head = tmp;
       delNode = null;
       size--;
     }
   }
   public void deleteLast() {
     if (size == 0)
       return ;
     if (size == 1) {
       deleteFirst();
     }else {
       Node preNode = searchNode(size - 2);
       preNode.next = null;
       tail = preNode;
       size--;
     }
   }
   public void deleteNode(int idx) {
     if (size == 0 || idx < 0)
       return ;
     if (idx == 0 || size == 1) {
       deleteFirst();
     }else if (idx >= size - 1) {
       deleteLast();
     }else {
       Node delNode = searchNode(idx);
       Node NextNode = delNode.next;
       Node preNode = searchNode(idx - 1);
       preNode.next = NextNode;
       delNode.next = null;
       size--;
     }
   }
}
