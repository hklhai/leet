//给你一个满足下述两条属性的 m x n 整数矩阵： 
//
// 
// 每行中的整数从左到右按非严格递增顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] ma, int target) {
        if (ma == null || ma.length == 0 || ma[0].length == 0) return false;
        int n = ma.length;
        int m = ma[0].length;

        int l = 0, r = n * m - 1;

        while (l < r) {
            int mid = l + r >> 1;
            if (ma[mid / m][mid % m] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return ma[r / m][r % m] == target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
