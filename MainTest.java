import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

  @Test
  public void test() {
    Assertions.assertNull(Main.remove(null, 1));
    Assertions.assertNull(Main.remove(null, 0));
    Assertions.assertNull(Main.remove(null, -10));

    /**
     * Input: head = [1], n = 1
     * Output: []
     */
    Assertions.assertNull(Main.remove(build(1), 1));

    /**
     * Input: head = [1,2], n = 1
     * Output: [1]
     */
    Assertions.assertTrue(hasSameValues(build(1), Main.remove(build(1, 2), 1)));

    /**
     * Input: head = [1,2,3,4,5], n = 2
     * Output: [1,2,3,5]
     */
    Assertions.assertTrue(hasSameValues(build(1, 2, 3, 5), Main.remove(build(1, 2, 3, 4, 5), 2)));

    /**
     * Input: head = [1,2,3,4,5], n = 8
     * Output: [1,2,3,4,5], nothing is removed
     */
    Assertions.assertTrue(hasSameValues(build(1, 2, 3, 4, 5), Main.remove(build(1, 2, 3, 4, 5), 8)));

    /**
     * Input: head = [1,2,3,4,5], n = 1
     * Output: [1,2,3,4]
     */
    Assertions.assertTrue(hasSameValues(build(1, 2, 3, 4), Main.remove(build(1, 2, 3, 4, 5), 1)));

    /**
     * Input: head = [1,2,3,4,5], n = 5
     * Output: [2,3,4,5]
     */
    Assertions.assertTrue(hasSameValues(build(2, 3, 4, 5), Main.remove(build(1, 2, 3, 4, 5), 5)));

    /**
     * Input: head = [1,2,3,4,5], n = 3
     * Output: [1,2,4,5]
     */
    Assertions.assertTrue(hasSameValues(build(1, 2, 4, 5), Main.remove(build(1, 2, 3, 4, 5), 3)));
  }

  private static Node build(Integer... values) {
    Node prev = null;
    Node head = null;

    for (Integer value : values) {
      Node n = new Node(value);

      if (prev == null) {
        head = n;
      } else {
        prev.next = n;
      }

      prev = n;
    }

    return head;
  }

  private static boolean hasSameValues(Node a, Node b) {
    while (a != null && b != null) {
      if (a.data != b.data) {
        return false;
      }

      a = a.next;
      b = b.next;
    }

    return a == null && b == null;
  }

}
