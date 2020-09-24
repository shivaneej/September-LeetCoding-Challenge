class Solution {
    public char findTheDifference(String s, String t) {
        int sum = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            sum += t.charAt(i);  
            sum -= s.charAt(i);
        }
        sum += t.charAt(n);  
        return (char)sum;
    }
}