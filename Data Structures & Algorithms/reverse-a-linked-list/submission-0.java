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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        if(curr==null){
            return curr;
        }
        ListNode second = curr.next;
        while (second != null) {
            ListNode third = second.next;
            second.next = curr;
            curr = second;
            second = third;

        }
        head.next = null;
        return curr;
    }
}
