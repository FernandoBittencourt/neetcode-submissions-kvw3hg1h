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
        ListNode root=null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b)->a.val-b.val);
        for(ListNode listNode:lists){
            pq.add(listNode);
        }
        ListNode current=null;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(root==null){
                root=node;
                current=node;
            } else{
                current.next=node;
                current=node;
            }
            
            if(node.next!=null){
                pq.add(node.next);
            }

            if(pq.isEmpty()){
                current.next=null;
            }
        }

        return root;
    }
}
