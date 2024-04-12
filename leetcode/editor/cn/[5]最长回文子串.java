//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) return "";

            String res = "";
            for (int i = 0; i < s.length(); i++) {
                int l = i, r = i;

                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }
                // l,r第一个不匹配的位置 (r - 1) - (l + 1) + 1 = r - l - 1
                if (res.length() < r - l - 1) {
                    // substring 方法在 Java 中是半开区间，即包括开始索引，不包括结束索引
                    res = s.substring(l + 1, r);
                }

                l = i;
                r = i + 1;
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }
                if (res.length() < r - l - 1) {
                    res = s.substring(l + 1, r);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
