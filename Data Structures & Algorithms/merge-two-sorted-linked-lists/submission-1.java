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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result=null;
        ListNode current=null;
        while(list1!=null && list2!=null){
            ListNode choosen = null;
            if(list1.val<=list2.val){
                choosen=list1;
                list1=list1.next;
            } else {
                choosen=list2;
                list2=list2.next;
            }
            if(result==null){
                result=choosen;
                current=choosen;
            } else {
                current.next=choosen;
                current = current.next;
            }
            choosen=choosen.next;
        }

        if (current == null) {
            return list1 != null ? list1 : list2;
        }

        while(list1!=null){
            current.next=list1;
            current=current.next;
            list1=list1.next;
        }

         while(list2!=null){
            current.next=list2;
            current=current.next;
            list2=list2.next;
        }
        return result;
    }
}