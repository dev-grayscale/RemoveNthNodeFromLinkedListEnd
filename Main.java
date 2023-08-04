/**
 * Given the head of a linked list, remove the n^th node from the end of the list and return its head.
 *
 * E.g.
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * For this problem, we'll assume the following Node structure:
 *
 * public class Node {
 *   public Node next;
 *   public int data;
 *
 *   public Node(int data) {
 *     this.data = data;
 *   }
 * }
 *
 * Let's divide the solution in two parts:
 *
 * 1. Find n^th node from the end of the list
 * 2. Remove it
 *
 * The 1st step could be solved by either approach from this challenge: <link>Return kth to last in linked list</link>.
 * The 2nd part.. either by similar method of <link>Delete middle node in linked list</link> or by having a pointer to the previous node of the one
 * we want to delete and detach it from the chain as: <b>previous.next = previous.next.next</b>.
 *
 * In the solution below, we advance the fast pointer with n position and then with 1 more so that when the end is reached,
 * the slow will be 1 position before the node we want to delete, which would allow us to detach just like we mentioned above:
 * <b>previous.next = previous.next.next</b>.
 *
 * We need to be careful with the following scenarios
 *
 * <ol>
 *   <li>If n < 1 -> return head</li>
 *   <li>If n > linked list size -> return head</li>
 *   <li>If the head of the list is to be removed -> return the next node as head</li>
 *   <li>Handle null pointers accordingly</li>
 * </ol>
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Main {
  public static Node remove(Node head, int n) {
    if (n < 1) {
      return head;
    }

    Node slow = head;
    Node fast = head;

    while (--n > 0 && fast != null) {
      fast = fast.next;
    }

    // n > list size
    if (fast == null) {
      return head;
    }

    // advance one more position
    // so slow would point to target position - 1
    fast = fast.next;

    while (fast != null && fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    // when only 1 node present
    if (slow == head && fast == null) {
      return head.next;
    }

    // remove node by detaching it from the chain
    slow.next = slow.next.next;

    return head;
  }
}
