//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
//
// 示例 1： 
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 提示： 
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] s;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return ans;
        s = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0, path);
        return ans;
    }

    public void dfs(int[] nums, int u, List<Integer> path) {
        if (nums.length == u) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!s[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !s[i - 1]) continue;
                s[i] = true;
                path.add(nums[i]);
                dfs(nums, u + 1, path);

                s[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
