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
    public Integer dfs(ListNode head, int n) {
        if (head == null) {
            return 0;
        }
        
        int cnt = dfs(head.next, n) + 1;
        
        if (cnt == n + 1) head.next = head.next.next;
        return cnt;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;
        if (head.next == null && n == 1) return null;
        int cnt = dfs(head, n);
        if (cnt == n) return head.next;
        return head;
    }
}