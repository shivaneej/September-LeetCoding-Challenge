class Solution {
    public int rob(int[] nums) {
        int maxSumExcluding = 0, maxSumIncluding = 0;
        for(int i = 0; i < nums.length; i++) {
            int currentMaxSumExcluding = Math.max(maxSumIncluding, maxSumExcluding);
            maxSumIncluding = nums[i] + maxSumExcluding;
            maxSumExcluding = currentMaxSumExcluding;
        }
        return Math.max(maxSumExcluding, maxSumIncluding);
    }
}