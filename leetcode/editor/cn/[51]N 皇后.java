//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// Related Topics 数组 回溯


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    boolean[] col, a, b;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        a = new boolean[2 * n];
        b = new boolean[2 * n];

        for (int i = 0; i < n; i++) {
            path.add(".".repeat(n));
        }

        dfs(0, n);
        return ans;
    }

    public void dfs(int u, int n) {
        if (u == n) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !a[u + i] && !b[u - i + n]) {
                col[i] = a[u + i] = b[u - i + n] = true;
                path.set(u, path.get(u).substring(0,i) + "Q"+ path.get(u).substring(i+1));
                dfs(u + 1, n);
                col[i] = a[u + i] = b[u - i + n] = false;
                path.set(u, path.get(u).substring(0,i) + "."+ path.get(u).substring(i+1));
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
