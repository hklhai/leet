//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aacecaaa"
//输出："aaacecaaa"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd"
//输出："dcbabcd"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 哈希函数 滚动哈希


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String shortestPalindrome(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();

        String combined = " " + s + "#" + t;
        int[] ne = new int[n * 2 + 2];  // KMP table

        for (int i = 2, j = 0; i <= n * 2 + 1; i++) {
            while (j > 0 && combined.charAt(i) != combined.charAt(j + 1)) {
                j = ne[j];
            }
            if (combined.charAt(i) == combined.charAt(j + 1)) {
                j++;
            }
            ne[i] = j;
        }

        int len = ne[n * 2 + 1];
        String right = s.substring(len);

        return new StringBuilder(right).reverse().toString() + s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
