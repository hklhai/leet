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


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target, path);
        return ans;
    }

    public void dfs(int[] candidates, int u, int sum, int target, List<Integer> path) {
        if (candidates.length == u) {
            if (sum == target) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        int k = u + 1;
        while (k < candidates.length && candidates[u] == candidates[k]) k++;

        int cnt = k - u;

        for (int i = 0; i <= cnt && sum + i * candidates[u] <= target; i++) {
            dfs(candidates, k, sum + i * candidates[u], target, path);
            path.add(candidates[u]);
        }
        for (int i = 0; i <= cnt && sum + i * candidates[u] <= target; i++) {
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
