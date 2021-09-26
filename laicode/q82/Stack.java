package laicode.q82;

public class Stack {
    public int removeAdjacentIV(char[] array) {
        
        int top = -1;
        for (int i = 0; i < array.length; i++) {
            if (top == -1 || array[top] != array[i]) {
                array[++top] = array[i];
            } else {
                while (top != -1 && array[i] == array[top]) {
                    i++;
                }
                top--;
                i--;
            }
        }
        return top + 1;
    }

    public static void main(String[] args) {
        Stack sol = new Stack();
        char[] array = "abbbaaccz".toCharArray();
        System.out.println(sol.removeAdjacentIV(array));
    }
}
