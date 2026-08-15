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
    public void reorderList(ListNode head) {
        
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == fast) {
            return;
        }
        ListNode current = slow, firstHalfHead = head;
        slow = null;
        ListNode prev = null;
        while (current != null) {
            ListNode tempRemain = current.next;
            current.next = prev;
            prev = current;
            current = tempRemain;
        }
        ListNode secondHalf = prev;

        ListNode tempRemain = null;
        while (secondHalf.next != null && firstHalfHead!= null) {
            tempRemain = firstHalfHead.next;
            ListNode temp2ndRemain = secondHalf.next;
            firstHalfHead.next = secondHalf;
            secondHalf.next = tempRemain;
            secondHalf = temp2ndRemain;
            firstHalfHead = firstHalfHead.next.next;
        }

    }
}
