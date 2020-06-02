package stack.postfix_notation;

import java.util.*;

public class Solution {
  
  public static String infix_to_posfix(String input){
    String posFix = "";
    Stack<Character> stack = new Stack<>();
    int inputLength = input.length();
    int index = 0;
    while (index < inputLength) {
      char operator = input.charAt(index);
      if (isDigit(operator)) {   // ���� �� ��, ���ڰ� ���� �� ���� ���ڿ��� �߰�
        while (index < inputLength && isDigit(input.charAt(index))) {
          posFix+=input.charAt(index);
          index++;
        }
        posFix+=' ';
      }
      else {      // ������ �� ��, ���ÿ� Ǫ��
        if (operator == '(') {
          stack.push(operator);
          index++;
        }
        else if (operator == ')') { // ���� ��ȣ( ')' )�� ������, ���ÿ��� ���� ��ȣ( '(' ) ���� �� ���� ������ pop
          while (stack.peek()!='(') {
            posFix+=stack.pop();
            posFix+=' ';
          }
          stack.pop();
          index++;
        }
        else if (isOperator(operator)) { // �����ڶ��, ���� �ֻ��� ����� �����Ϳ� �켱���� �񱳸� �Ѵ�
          if (!stack.isEmpty() && priority(stack.peek()) >= priority(operator)) {
            posFix+=stack.pop();
            posFix+=' ';
          }
          stack.push(operator);
          index++;
        }
        else
          throw new IllegalArgumentException("�Է��� ������ �߸��Ǿ����ϴ�.");
      }
    }
    while (!stack.isEmpty()) {
      posFix+=stack.pop();
      posFix+=" ";
    }
    return posFix;
  }
  
  public static boolean isDigit(char ch) {
    int tmp = ch-'0';
    return (tmp>=0&&tmp<=9 ? true : false);
  }
  
  public static boolean isOperator(char operator) {
    return (operator=='-' || operator=='+' || operator=='*' || operator=='/');
  }
  
  public static int priority(char operator) {
    if (operator == '(') {
      return 0;
    }else if (operator == '-' || operator == '+') {
      return 1;
    }else if (operator == '*' || operator == '/') {
      return 2;
    }
    return -1;
  }
  
  public static long cal(String postFix) {
    System.out.println(postFix);
    return 0;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String inputStr = sc.next();
    System.out.println(cal(infix_to_posfix(inputStr)));
  }
}
