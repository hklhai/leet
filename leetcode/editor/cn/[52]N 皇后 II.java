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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[] col, dg, udg;
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public int totalNQueens(int n) {
        col = new boolean[n];
        dg = new boolean[n * 2];
        udg = new boolean[n * 2];
        for (int i = 0; i < n; i++) {
            path.add(".".repeat(n));
        }
        dfs(0, n);
        return ans.size();
    }

    private void dfs(int u, int n) {
        if (u == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[u - i + n] && !udg[u + i]) {
                col[i] = dg[u - i + n] = udg[u + i] = true;
                path.set(u, path.get(u).substring(0, i) + 'Q' + path.get(u).substring(i + 1));
                dfs(u + 1, n);
                col[i] = dg[u - i + n] = udg[u + i] = false;
                path.set(u, path.get(u).substring(0, i) + '.' + path.get(u).substring(i + 1));
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
