//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            int left = dfs(nums1, 0, nums2, 0, total / 2);
            int right = dfs(nums1, 0, nums2, 0, total / 2 + 1);
            return (left + right) / 2.0;
        } else {
            return dfs(nums1, 0, nums2, 0, total / 2 + 1);
        }
    }

    public int dfs(int[] nums1, int i, int[] nums2, int j, int k) {
        if (nums1.length - i > nums2.length - j) return dfs(nums2, j, nums1, i, k);
        if (nums1.length == i) return nums2[j + k - 1];
        if (k == 1) return Math.min(nums1[i], nums2[j]);

        int si = Math.min(i + k / 2, nums1.length);
        int sj = j + k / 2;

        if (nums1[si - 1] > nums2[sj - 1]) {
            return dfs(nums1, i, nums2, j + k / 2, k - k / 2);
        } else {
            return dfs(nums1, si, nums2, j, k - (si - i));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
