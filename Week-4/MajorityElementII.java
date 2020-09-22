class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer candidate1 = null, candidate2 = null;
        int count1 = 0, count2 = 0;
        int n = nums.length;
        for(int i = 0 ; i < n; i++) {
            if(candidate1 != null && nums[i] == candidate1) count1++;
            else if(candidate2 != null && nums[i] == candidate2) count2++;
            else if(count1 == 0) {
                candidate1 = nums[i]; count1 = 1;
            } else if(count2 == 0) {
                candidate2 = nums[i]; count2 = 1;
            } else {
                count1--; count2--;
            } 
        }
        count1 = 0; count2 = 0;
        for(int i = 0; i < n; i++) {
            if(candidate1 != null && nums[i] == candidate1) count1++;
            if(candidate2 != null && nums[i] == candidate2) count2++;
        }
        List<Integer> result = new ArrayList<Integer>();
        if(count1 > (n/3))
            result.add(candidate1);
        if(candidate2 != candidate1 && count2 > (n/3))
            result.add(candidate2);
        return result;
    }
}