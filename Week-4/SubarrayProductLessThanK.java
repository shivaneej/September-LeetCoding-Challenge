class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int prod = 1, start = 0, end = 0, count = 0;
        while(end < n) {
            prod *= nums[end];
            while(start < end && prod >= k) {
                prod /=  nums[start++];
            }
            if(prod < k) {
                count += (end - start) + 1;
            }
            end++;
        }
        return count;
    }
}
