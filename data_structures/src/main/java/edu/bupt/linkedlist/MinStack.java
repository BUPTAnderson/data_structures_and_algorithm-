package edu.bupt.linkedlist;

/**
 * leet-code 155
 */
public class MinStack {
  class Node {
    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  private Node current = null;
  private int min;
  public MinStack() {
  }

  public void push(int x) {
    Node newNode = new Node(x, current);
    if (current == null) {
      min = x;
    } else {
      if (x < min) {
        min = x;
      }
    }
    current = newNode;
  }

  private int getMin(Node current) {
    if (current == null) {
      return -1;
    }
    int min = current.value;
    current = current.next;
    while (current != null) {
      if (current.value < min) {
        min = current.value;
      }
      current = current.next;
    }
    return min;
  }
  public void pop() {
    if (current != null) {
      int v = current.value;
      current = current.next;
      if (v == min) {
        min = getMin(current);
      }
    }
  }

  public int top() {
    if (current == null) {
      return -1;
    }
    return current.value;
  }

  public int getMin() {
    if (current == null) {
      return -1;
    }
    return min;
  }

  public static void main(String[] args) {

  }
}
