package leetcode.q641;

public class LinkedList {
    
    public static void main(String[] args) {

    }
    
}

class MyCircularDeque {

    private Node tail;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {
        this.tail = new Node(-1);
        this.tail.next = this.tail;
        this.tail.prev = this.tail;
        this.size = 0;
        this.capacity = k;
    }

    public boolean insertFront(int value) {
        
    }

    public boolean insertLast(int value) {

    }

    public boolean deleteFront() {

    }

    public boolean deleteLast() {

    }

    public int getFront() {

    }

    public int getRear() {

    }

    public boolean isEmpty() {

    }

    public boolean isFull() {

    }

    private static class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
            prev = next = null;
        }
    }
}
