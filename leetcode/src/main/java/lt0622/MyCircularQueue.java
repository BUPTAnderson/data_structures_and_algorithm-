package lt0622;

/**
 * Created by Anderson on 2021/3/3
 */
public class MyCircularQueue {
  int[] array;
  int length;
  int head = 0;
  int tail = 0;
  public MyCircularQueue(int k) {
    array = new int[k + 1];
    length = k + 1;
  }

  public boolean enQueue(int value) {
    if ((tail + 1) % length == head) {
      return false;
    }
    tail = (tail + 1) % length;
    array[tail] = value;
    return true;
  }

  public boolean deQueue() {
    if (head == tail) {
      return false;
    }
    head = (head + 1) % length;
    return true;
  }

  public int Front() {
    if (head == tail) {
      return -1;
    }
    return array[(head + 1) % length];
  }

  public int Rear() {
    if (head == tail) {
      return -1;
    }
    return array[tail];
  }

  public boolean isEmpty() {
    return head == tail;
  }

  public boolean isFull() {
    return (tail + 1) % length == head;
  }
}
