class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String arr[] = new String[n];
        String result = "";
        for(int i = 0; i < n; i++)
            arr[i] = String.valueOf(nums[i]);
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return -(s1 + s2).compareTo(s2 + s1);
            }
        });
        if(arr[0].equals("0"))
            return arr[0];
        for(String s : arr) 
            result += s;
        return result;
    }
}