package edu.bupt.linkedlist;

import java.util.LinkedList;

public class Utils {
  /**
   * 反转单链表，非递归
   * leetcode-206
   * @param current
   * @return
   */
  public static ListNode reverse(ListNode current) {
    ListNode pre = null;
    ListNode next = null;
    while (current != null) {
      next = current.next;
      current.next = pre;
      pre = current;
      current = next;
    }

    return pre;
  }

  /**
   * 反转单链表，递归方式
   * @param current
   * @return
   */
  public static ListNode reverse2(ListNode current) {
    if (current == null || current.next == null) {
      return current;
    }

    ListNode next = current.next;
    current.next = null;
    ListNode reverseListNode = reverse2(next);
    next.next = current;
    return reverseListNode;
  }

  /**
   * 逆序打印单链表
   * @param current
   */
  public static void reversePrint(ListNode current) {
    if (current == null) {
      return;
    }

    reversePrint(current.next);
    System.out.println(current.value);
  }

  /**
   * 判断单链表是否有环
   * leetcode-141
   * @param head
   * @return
   */
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }

    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null) {
      if (slow == fast) {
        return true;
      }
      slow = slow.next;
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
      }
    }
    return false;
  }

  /**
   * 两个有序链表合并，不去重
   * Given two sorted linked list, and merge them without using extra space (using constant space is allowed).
   * For example, if 1 -> 2 -> 5 merges with 2 -> 4 -> 5, we have 1 -> 2 -> 2 -> 4 -> 5 > 5
   * leetcode-21
   * @param l1
   * @param l2
   * @return
   */
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    ListNode head = null , current = null;
    if (l1.value <= l2.value) {
      head = current = l1;
      l1 = l1.next;
    } else {
      head = current = l2;
      l2 = l2.next;
    }

    while (l1 != null && l2 != null) {
      if (l1.value <= l2.value) {
        current.next = l1;
        current = l1;
        l1 = l1.next;
      } else {
        current.next = l2;
        current = l2;
        l2 = l2.next;
      }
    }

    if (l1 != null) {
      current.next = l1;
    }
    if (l2 != null) {
      current.next = l2;
    }

    return head;
  }

  /**
   * 两个有序链表合并，去重(每个单链表无重复数据)
   * Given two sorted linked list, and merge them without using extra space (using constant space is allowed).
   * For example, if 1 -> 2 -> 5 merges with 2 -> 4 -> 5, we have 1 -> 2 -> 4 -> 5
   * @param l1
   * @param l2
   * @return
   */
  public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    ListNode head = null , current = null;
    if (l1.value <= l2.value) {
      head = current = l1;
      l1 = l1.next;
    } else {
      head = current = l2;
      l2 = l2.next;
    }

    while (l1 != null && l2 != null) {
      if (l1.value <= l2.value) {
        if (current.value != l1.value) {
          current.next = l1;
          current = l1;
        }
        l1 = l1.next;
      } else {
        if (current.value != l2.value) {
          current.next = l2;
          current = l2;
        }
        l2 = l2.next;
      }
    }

    while (l1 != null) {
      if (current.value != l1.value) {
        current.next = l1;
      }
      l1 = l1.next;
    }
    while (l2 != null) {
      if (current.value != l2.value) {
        current.next = l2;
      }
      l2 = l2.next;
    }

    return head;

  }

  /**
   * 删除倒数第n个节点
   * leetcode-19
   * 如果是要找到倒数第n个节点的话，初始化时让behind=head，while不用判断behind是否为null了，改成behind = behind.next, while后直接返回behind即可
   * @param head
   * @param n
   * @return
   */
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null || n <= 0) {
      return null;
    }
    // 定义两个指针，front: 先走 behind：后走
    ListNode behind = null, front = head;

    int count = 0;
    // front指针先向后走n步
    while (count < n && front != null) {
      front = front.next;
      count++;
    }
    // 说明n大于列表长度
    if (count != n) {
      return head;
    }

    // front和behind一起走，front走到null时，behind指向要删除的节点的前一个节点
    while (front != null) {
      front = front.next;
      behind = behind == null ? head : behind.next;
    }

    // behind是null说明上面的while没有执行，要删除的是头结点
    if (behind == null) {
      return head.next;
    }
    // 删除倒数第n个节点
    behind.next = behind.next.next;
    return head;
  }

  /**
   *  Middle of the Linked List
   *  Input: [1,2,3,4,5,6]
   *  Output: Node 4 from this list (Serialization: [4,5,6])
   *  Since the list has two middle nodes with values 3 and 4, we return the second one.
   * leetcod-876
   * 解题思路还是快慢指针
   * @param head
   * @return
   */
  public static ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head, fast = head;
    while (fast != null) {
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
      } else {
        break;
      }
      slow = slow.next;
    }

    return slow;
  }

  public static boolean isValid(String s) {
    LinkedList<Character> stack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ')' || c == ']' || c == '}') {
        if (stack.isEmpty()) {
          return false;
        }
        char head = stack.removeFirst();
        if ((c == ')' && head != '(') || (c == ']' && head != '[') || (c == '}' && head != '{')) {
          return false;
        }
      } else {
        stack.addFirst(c);
      }
    }

    if (!stack.isEmpty()) {
      return false;
    }

    return true;
  }


  public static void main(String[] args) {
    System.out.println(isValid("()[]{}"));
//    ListNode a = new ListNode('a', null);
//    ListNode b = new ListNode('b', null);
//    ListNode c = new ListNode('c', null);
//    ListNode d = new ListNode('d', null);
//    ListNode e = new ListNode('e', null);
//    ListNode f = new ListNode('f', null);
//    ListNode g = new ListNode('g', null);
//    a.next = b;
//    b.next = c;
//    c.next = d;
//    d.next = e;
//    e.next = f;
//    f.next = g;
//
//    ListNode r = middleNode(a);
//    while (r != null) {
//      System.out.println(r.value);
//      r = r.next;
//    }

//    ListNode l1a = new ListNode('1', null);
//    ListNode l1b = new ListNode('2', null);
//    ListNode l1c = new ListNode('5', null);
//    l1a.next = l1b;
//    l1b.next = l1c;
//
//    ListNode l2a = new ListNode('2', null);
//    ListNode l2b = new ListNode('4', null);
//    ListNode l2c = new ListNode('5', null);
//    l2a.next = l2b;
//    l2b.next = l2c;
//
//    reversePrint(l1a);
//    System.out.println("++++++++++++");
//    reversePrint(l2a);
//    System.out.println("++++++++++++");
//    ListNode head = mergeTwoLists(l1a, l2a);
//    ListNode head = mergeTwoLists(l1a, l2a);
//    while (head != null) {
//      System.out.println(head.value);
//      head = head.next;
//    }
  }
}
