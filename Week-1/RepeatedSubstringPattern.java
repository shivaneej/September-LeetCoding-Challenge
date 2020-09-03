class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if(n == 1) return false;
        for(int k = 1; k <= n / 2; k++) {
                String substr = s.substring(0, k);
                StringBuilder str = new StringBuilder(substr);
                for(int i = 2; i <= n / k; i++) 
                    str.append(substr);
                if(str.toString().equals(s)) return true;   
        }
        return false;
    }
}