//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics 链表 双指针


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }

        k %= len;
        if (k == 0) return head;

        ListNode f = head;
        ListNode s = head;
        // [1,2,3,4,5], k = 2  -> [4,5,1,2,3]
        while (k > 0) {
            f = f.next;
            k--;
        }

        while (f.next != null) {
            f = f.next;
            s = s.next;
        }

        ListNode newHead = s.next;
        s.next = null;
        f.next = head;

        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
