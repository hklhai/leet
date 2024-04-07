//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3543 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, "");
        return ans;
    }

    public void dfs(int n, int l, int r, String path) {
        if (n == l && l == r) {
            ans.add(path);
            return;
        }

        if (l < n) {
            dfs(n, l + 1, r, path + "(");
        }

        if (r < l) {
            dfs(n, l, r + 1, path + ")");
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
