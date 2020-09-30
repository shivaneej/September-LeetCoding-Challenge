class Solution {
    public int firstMissingPositive(int[] nums) {
        int minPositive = Integer.MAX_VALUE;
        int n = nums.length, i;
        for(i = 0; i < n; i++) {
            if(nums[i] < minPositive && nums[i] > 0)
                minPositive = nums[i];
        }
        if(minPositive != 1) return 1;
        for(i = 0; i < n; i++) {
            if(nums[i] < 1 || nums[i] > n)
                nums[i] = 1;
        }
        for(i = 0; i < n; i++) {
            int current = Math.abs(nums[i]);
            if(current == n)
                nums[0] = -1 * Math.abs(nums[0]);
            else
                nums[current] = -1 * Math.abs(nums[current]);
        }
        for(i = 0; i < n; i++) {
            int current = nums[i];
            if(current > 0 && i > 0)
                return i;
        }
        if(nums[0] > 0) return n;
        return n + 1;
    }
}
