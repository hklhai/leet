//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 回溯


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    boolean[] col, a, b;
    public int totalNQueens(int n) {
        for (int i = 0; i < n; i++) {
            path.add(".".repeat(n));
        }
        col = new boolean[n];
        a = new boolean[n * 2];
        b = new boolean[n * 2];

        dfs(0, n);
        return ans.size();
    }

    public void dfs(int u, int n) {
        if (n == u) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !a[i + u] && !b[i - u + n]) {
                col[i] = a[i + u] = b[i - u + n] = true;
                path.set(u, path.get(u).substring(0, i) + "Q" + path.get(u).substring(i + 1));
                dfs(u + 1, n);
                col[i] = a[i + u] = b[i - u + n] = false;
                path.set(u, path.get(u).substring(0, i) + "." + path.get(u).substring(i + 1));
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
