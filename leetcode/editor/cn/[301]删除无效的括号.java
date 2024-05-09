//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。 
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
//
// Related Topics 广度优先搜索 字符串 回溯


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        for (char x : s.toCharArray()) {
            if (x == '(') l++;
            else if (x == ')') {
                if (l == 0) r++;
                else l--;
            }
        }
        dfs(s, 0, new StringBuilder(), 0, l, r);
        return ans;
    }

    private void dfs(String s, int u, StringBuilder path, int cnt, int l, int r) {
        if (u == s.length()) {
            if (cnt == 0) ans.add(path.toString());
            return;
        }
        if (s.charAt(u) != '(' && s.charAt(u) != ')') {
            dfs(s, u + 1, path.append(s.charAt(u)), cnt, l, r);
            path.deleteCharAt(path.length() - 1); // 恢复现场
        } else if (s.charAt(u) == '(') {
            int k = u;
            while (k < s.length() && s.charAt(k) == '(') k++;
            l -= k - u;
            for (int i = k - u; i >= 0; i--) {
                if (l >= 0) dfs(s, k, path, cnt, l, r);
                path.append('(');
                cnt++;
                l++;
            }
        } else if (s.charAt(u) == ')') {
            int k = u;
            while (k < s.length() && s.charAt(k) == ')') k++;
            r -= k - u;
            for (int i = k - u; i >= 0; i--) {
                if (r >= 0 && cnt >= 0) dfs(s, k, path, cnt - i, l, r);
                path.append(')');
                cnt--;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
