package leetcode.q772;

import java.util.Deque;
import java.util.ArrayDeque;

public class TwoStacks {
    public int calculate(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> optStack = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if ("+-*/".indexOf(c) != -1) {
                while (!optStack.isEmpty() && getOrder(optStack.peekFirst()) >= getOrder(c)) {
                    doCalculate(numStack, optStack);
                }
                optStack.offerFirst(c);
                i++;
            } else if (c >= '0' && c <= '9') {
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = 10 * num + s.charAt(i) - '0'; 
                    i++;
                }
                numStack.offerFirst(num);
            } else if (c == '(') {
                optStack.offerFirst('(');
                i++;
            } else {
                while (optStack.peekFirst() != '(') {
                    doCalculate(numStack, optStack);
                }
                optStack.pollFirst();
                i++;
            }
        }
    
        while (!optStack.isEmpty()) {
            doCalculate(numStack, optStack);
        }
        return numStack.peekFirst();
    }
    
    private int doCalculate(Deque<Integer> numStack, Deque<Character> optStack) {
        int num2 = numStack.pollFirst();
        int num1 = numStack.pollFirst();
        char opt = optStack.pollFirst();
        
        switch (opt) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return -1;
        }
    }
    
    private int getOrder(char c) {
        switch (c) {
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            
            default:
                return -1;
        }
    }
}
