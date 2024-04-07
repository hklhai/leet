//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] s;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return ans;
        s = new boolean[nums.length];
        dfs(nums, 0, path);
        return ans;
    }

    public void dfs(int[] nums, int u, List<Integer> path) {
        if (u == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!s[i]) {
                path.add(nums[i]);
                s[i] = true;
                dfs(nums, u + 1, path);
                s[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
