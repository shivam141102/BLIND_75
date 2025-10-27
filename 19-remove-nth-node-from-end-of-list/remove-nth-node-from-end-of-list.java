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
    public ListNode removeNthFromEnd(ListNode head, int n) {
    //     ListNode curr = head;
    //     int cnt = 0;
    //     while(curr != null){
    //         cnt++;
    //         curr = curr.next;
    //     }

    //     curr = head;
    //     int res = cnt - n;

    //     if(res == 0) return head.next;
    //     while(res > 1 && curr != null){
    //         curr = curr.next;
    //         res--;
    //     }
    //     curr.next = curr.next.next;
    //     return head;

    ListNode front = head, back = head;
    int second = n;
    while(second != 0){
        second--;
        front = front.next;
    }

    //Case when n == cnt
    if (front == null) return head.next;

    while(front.next != null){
        front = front.next;
        back = back.next;
    }
    back.next = back.next.next;
    return head;
    }
}