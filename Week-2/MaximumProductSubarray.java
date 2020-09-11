class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int prevMax = 1, prevMin = 1;
        for(int i = 0; i < nums.length; i++) {
            int currentMax = Math.max(prevMax * nums[i], prevMin * nums[i]);
            int currentMin = Math.min(prevMax * nums[i], prevMin * nums[i]);
            int temp = Math.max(Math.max(currentMax, currentMin), nums[i]);
            prevMax = Math.max(nums[i], currentMax);
            prevMin = Math.min(nums[i], currentMin);
            maxProduct = Math.max(temp, maxProduct);
        }
        return maxProduct;
    }
}