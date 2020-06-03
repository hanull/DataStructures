package stack.postfix_notation;

import java.util.*;

public class Solution {
  
  public static String infix_to_postfix(String input){
    String posFix = "";
    Stack<Character> stack = new Stack<>();
    int inputLength = input.length();
    int index = 0;
    while (index < inputLength) {
      char operator = input.charAt(index);
      if (isDigit(operator)) {   // 숫자 일 때, 숫자가 끝날 때 까지 문자열에 추가
        while (index < inputLength && isDigit(input.charAt(index))) {
          posFix+=input.charAt(index);
          index++;
        }
        posFix+=' ';
      }
      else {      // 연산자 일 때, 스택에 푸시
        if (operator == '(') {
          stack.push(operator);
          index++;
        }
        else if (operator == ')') { // 닫힌 괄호( ')' )를 만나면, 스택에서 열린 괄호( '(' ) 나올 때 까지 연산자 pop
          while (stack.peek()!='(') {
            posFix+=stack.pop();
            posFix+=' ';
          }
          stack.pop();
          index++;
        }
        else if (isOperator(operator)) { // 연산자라면, 스택 최상위 노드의 데이터와 우선순위 비교를 한다
          if (!stack.isEmpty() && priority(stack.peek()) >= priority(operator)) {
            posFix+=stack.pop();
            posFix+=' ';
          }
          stack.push(operator);
          index++;
        }
        else
          throw new IllegalArgumentException("입력한 수식이 잘못되었습니다.");
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
  
  public static long tmpCal(long tmp1, long tmp2, char operator) {
    if(operator=='+') {
      return (tmp1 + tmp2);
    }else if(operator=='-') {
      return (tmp1 - tmp2);
    }else if(operator=='*') {
      return (tmp1 * tmp2);
    }else {
      return (tmp1 / tmp2);
    }
  }
  
  public static long cal(String postFix) {
    Stack<Long> stack = new Stack<>();
    String[] splitPostFix = postFix.split(" ");
    long tmp1,tmp2;
    for(int i=0; i<splitPostFix.length; i++) {
      if (isOperator(splitPostFix[i].charAt(0))) {
        tmp1=stack.pop();
        tmp2=stack.pop();
        stack.push(tmpCal(tmp1,tmp2, splitPostFix[i].charAt(0)));
      }else {
        stack.push(Long.valueOf(splitPostFix[i]));
      }
    }
    return stack.pop();
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String inputStr = sc.next();
    System.out.println("Input : " + inputStr);
    System.out.println("Postfix : " + infix_to_postfix(inputStr));
    System.out.println(cal(infix_to_postfix(inputStr)));
  }
}
