//给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。 
//
// 
//
// 示例 1： 
// 
// 
//输入: root = [5,3,6,2,4,null,7], k = 9
//输出: true
// 
//
// 示例 2： 
// 
// 
//输入: root = [5,3,6,2,4,null,7], k = 28
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// 题目数据保证，输入的 root 是一棵 有效 的二叉搜索树 
// -10⁵ <= k <= 10⁵ 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<Integer> nums;

    public boolean findTarget(TreeNode root, int k) {
        nums = new ArrayList<>();
        if (root == null) return false;
        inorder(root);
        int n = nums.size();
        int l = 0, r = n - 1;
        while (l < r) {
            int sum = nums.get(l) + nums.get(r);
            if (sum == k) return true;
            if (sum > k) {
                r--;
            } else {
                l++;
            }

        }
        return false;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        nums.add(root.val);
        inorder(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
