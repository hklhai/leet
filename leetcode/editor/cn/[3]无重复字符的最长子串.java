//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s.length() == 0) return res;
        Map<Character, Integer> m = new HashMap<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ci = s.charAt(i);
            m.put(ci, m.getOrDefault(ci, 0) + 1);

            while (m.get(ci) > 1) {
                char cj = s.charAt(j);
                j++;
                m.put(cj, m.get(cj) - 1);
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
