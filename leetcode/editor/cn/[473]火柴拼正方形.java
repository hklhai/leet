//你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能
//折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。 
//
// 如果你能使这个正方形，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: matchsticks = [1,1,2,2,2]
//输出: true
//解释: 能拼成一个边长为2的正方形，每边两根火柴。
// 
//
// 示例 2: 
//
// 
//输入: matchsticks = [3,3,3,3,4]
//输出: false
//解释: 不能用所有火柴拼成一个正方形。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= matchsticks.length <= 15 
// 1 <= matchsticks[i] <= 10⁸ 
// 
//
// Related Topics 位运算 数组 动态规划 回溯 状态压缩


import java.util.Collections;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<Integer> nums;
    private boolean[] st;

    public boolean dfs(int start, int cur, int length, int cnt) {
        if (cnt == 3) return true;
        if (cur == length) return dfs(0, 0, length, cnt + 1);
        for (int i = start; i < nums.size(); i++) {
            if (st[i]) continue;
            if (cur + nums.get(i) <= length) {
                st[i] = true;
                if (dfs(i + 1, cur + nums.get(i), length, cnt)) return true;
                st[i] = false;
            }
            if (cur == 0 || cur + nums.get(i) == length) return false;
            while (i + 1 < nums.size() && nums.get(i + 1).equals(nums.get(i))) {
                i++;
            }
        }
        return false;
    }

    public boolean makesquare(int[] _nums) {
        nums = new ArrayList<>();
        for (int num : _nums) {
            nums.add(num);
        }
        if (nums.isEmpty()) return false;
        st = new boolean[nums.size()];
        int sum = 0;
        for (int x : nums) sum += x;
        if (sum % 4 != 0) return false;
        sum /= 4;
        Collections.sort(nums, Collections.reverseOrder());
        return dfs(0, 0, sum, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
