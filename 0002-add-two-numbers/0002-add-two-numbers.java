// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Deserialize method to convert a string like "[2,4,3]" to a linked list
    public static ListNode deserialize(String data) {
        data = data.replaceAll("\\[|\\]|\\s", ""); // remove brackets and spaces
        if (data.isEmpty()) return null;

        String[] parts = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String part : parts) {
            current.next = new ListNode(Integer.parseInt(part));
            current = current.next;
        }

        return dummy.next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy node to simplify logic
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }
}

// You can use this class to run and test the code
public class Main {
    public static void main(String[] args) {
        ListNode l1 = ListNode.deserialize("[2,4,3]");
        ListNode l2 = ListNode.deserialize("[5,6,4]");

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        printList(result);  // Expected: 7 -> 0 -> 8
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
