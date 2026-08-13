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
    public boolean hasCycle(ListNode head) {
         ListNode slow = head;
        ListNode fast = head;
        if(head==null){
            return false;
        }
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            if (slow.next == fast.next.next) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
