class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<Long>();
        for(int i = 0; i < nums.length; i++) {
            long current = nums[i];
            Long floor = set.floor(current + t);
            Long ceil = set.ceiling(current - t);
            if(floor != null && floor >= current) return true;
            if(ceil != null && ceil <= current) return true;
            set.add(current);
            if(i >= k)
                set.remove((long)nums[i - k]);
        }
        return false;
    }
}