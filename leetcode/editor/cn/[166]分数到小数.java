//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 如果存在多个答案，只需返回 任意一个 。 
//
// 对于所有给定的输入，保证 答案字符串的长度小于 10⁴ 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numerator = 1, denominator = 2
//输出："0.5"
// 
//
// 示例 2： 
//
// 
//输入：numerator = 2, denominator = 1
//输出："2"
// 
//
// 示例 3： 
//
// 
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= numerator, denominator <= 2³¹ - 1 
// denominator != 0 
// 
//
// Related Topics 哈希表 数学 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            result.append("-");
        }

        long x = Math.abs((long) numerator);
        long y = Math.abs((long) denominator);

        result.append(x / y);
        x %= y;

        if (x == 0) {
            return result.toString();
        }

        result.append(".");
        HashMap<Long, Integer> map = new HashMap<>();

        while (x != 0) {
            if (map.containsKey(x)) {
                int start = map.get(x);
                String part1 = result.substring(0, start);
                String part2 = result.substring(start);
                return part1 + "(" + part2 + ")";
            }

            map.put(x, result.length());
            x *= 10;
            result.append(x / y);
            x %= y;
        }

        return result.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
