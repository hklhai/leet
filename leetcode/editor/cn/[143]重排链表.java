//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics 栈 递归 链表 双指针 👍 1476 👎 0


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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // 输入：head = [1,2,3,4,5] 输出：[1,5,2,4,3]
        ListNode f = head;
        ListNode s = head;

        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }

        // head  s s.next   f
        ListNode a = s.next;
        s.next = null;

        ListNode b = a.next;
        a.next = null;

        while (b != null) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }

        // head    ; a
        ListNode first = head;
        ListNode second = a;
        while (first != null && second != null) {
            ListNode t = first.next;
            first.next = second;
            first = second;
            second = t;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
