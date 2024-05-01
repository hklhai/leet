//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。 
//
// 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
//
// Related Topics 栈 数学 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Stack<Integer> num = new Stack<>();
    Stack<Character> op = new Stack<>();
    HashMap<Character, Integer> map = new HashMap<>();

    private void eval() {
        int b = num.pop();
        int a = num.pop();
        char c = op.pop();
        int r = 0;
        if (c == '+')
            r = a + b;
        else if (c == '-')
            r = a - b;
        else if (c == '*')
            r = a * b;
        else
            r = a / b;
        num.add(r);
    }

    public int calculate(String s) {
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;
            if (c >= '0' && c <= '9') {
                int x = 0, j = i;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    x = x * 10 + s.charAt(j) - '0';
                    j++;
                }
                i = j - 1;
                num.add(x);
            } else {
                while (!op.isEmpty() && map.get(op.peek()) >= map.get(c))
                    eval();
                op.add(c);
            }
        }

        while (!op.isEmpty())
            eval();

        return num.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
