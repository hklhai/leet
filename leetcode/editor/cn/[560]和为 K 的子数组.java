//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // 前缀和数组，s[i] 表示从 nums[0] 到 nums[i-1] 的和
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        // 哈希表用于存储某个前缀和出现的次数
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0, 1); // 初始化，前缀和为0的情况有1种
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += hash.getOrDefault(s[i] - k, 0); // 查找有多少个前缀和等于 s[i] - k
            hash.put(s[i], hash.getOrDefault(s[i], 0) + 1); // 更新前缀和为 s[i] 的数量
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
