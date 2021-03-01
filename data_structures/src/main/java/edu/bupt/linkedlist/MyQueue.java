package edu.bupt.linkedlist;

/**
 * leetcode-232
 */
public class MyQueue {
  class Node {
    int value;
    Node next;

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  Node head = null, tail = null;
  /** Initialize your data structure here. */
  public MyQueue() {
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    if (tail == null) {
      head = tail = new Node(x, null);
    } else {
      tail.next = new Node(x, null);
      tail = tail.next;
    }
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if (head == null) {
      return -1;
    }
    int v = head.value;
    if (head.next == null) {
      head = tail = null;
    } else {
      head = head.next;
    }
    return v;
  }

  /** Get the front element. */
  public int peek() {
    if (head != null) {
      return head.value;
    }
    return -1;
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return head == null;
  }

  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();
    myQueue.push(1);
    myQueue.push(2);
    myQueue.push(3);
    myQueue.push(4);
    System.out.println(myQueue.pop());
    myQueue.push(5);
    System.out.println(myQueue.pop());
    System.out.println(myQueue.pop());
    System.out.println(myQueue.pop());
    System.out.println(myQueue.pop());
  }
}
