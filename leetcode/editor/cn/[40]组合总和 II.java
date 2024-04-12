//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] c, int target) {
        Arrays.sort(c);

        dfs(c, 0, target);
        return ans;
    }

    public void dfs(int[] c, int u, int target) {
        if (c.length == u) {
            if (target == 0) ans.add(new ArrayList<>(path));
            return;
        }

        int k = u + 1;
        while (k < c.length && c[k] == c[u]) k++;
        int cnt = k - u;

        for (int i = 0; i <= cnt && target - i * c[u] >= 0; i++) {
            dfs(c, k, target - i * c[u]);
            path.add(c[u]);
        }
        for (int i = 0; i <= cnt && target - i * c[u] >= 0; i++) {
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
