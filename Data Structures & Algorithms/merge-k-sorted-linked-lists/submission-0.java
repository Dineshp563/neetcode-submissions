/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
     
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case: completely empty input
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Use a standard Queue
        LinkedList<ListNode> queue = new LinkedList<>();

        // Safely add lists to the queue, skipping the null ones
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        // Edge case: What if all lists inside the array were empty? (e.g., [[]])
        if (queue.isEmpty()) {
            return null;
        }

        while (queue.size() > 1) {
            ListNode list4 = queue.pop();
            ListNode list3 = queue.pop();
            queue.add(this.mergeTwoLists(list3, list4));
        }

        return queue.pop();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }
        return head.next;
    }
}
