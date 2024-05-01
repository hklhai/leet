//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    boolean[][] f;

    public List<List<String>> partition(String s) {
        int n = s.length();
        f = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    f[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j) && (i + 1 > j - 1 || f[i + 1][j - 1])) {
                    f[i][j] = true;
                }
            }
        }
        dfs(s, 0);
        return ans;
    }

    private void dfs(String s, int u) {
        if (u == s.length()) {
            ans.add(new ArrayList<>(path));
        } else {
            for (int i = u; i < s.length(); i++) {
                if (f[u][i]) {
                    path.add(s.substring(u, i + 1));
                    dfs(s, i + 1);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
