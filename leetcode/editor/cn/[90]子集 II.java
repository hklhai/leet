//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 位运算 数组 回溯


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[] nums, int u) {
        if (nums.length == u) {
            ans.add(new ArrayList<>(path));
            return;
        }

        int k = u + 1;
        while (k < nums.length && nums[k] == nums[u]) k++;
        int cnt = k - u;

        for (int i = 0; i <= cnt; i++) {
            dfs(nums, k);
            path.add(nums[u]);
        }

        for (int i = 0; i <= cnt; i++) {
            path.remove(path.size() - 1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
