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
        ListNode node=head;
        while(node != null){
            node.val=-1;
            node=node.next;
            if(node!=null && node.val==-1){
                return true;
            } 
        }
        return false;
    }
}
