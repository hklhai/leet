import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        if (nums.length == 0) return ans;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (m.containsKey(tmp)) {
                ans[0] = i;
                ans[1] = m.get(tmp);
                return ans;
            }
            m.put(nums[i], i);
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
