class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length(), i;
        int[] secretDigits = new int[10];
        int[] guessDigits = new int[10];
        int bulls = 0, cows = 0;
        for(i = 0; i < n; i++)
        {
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if(a == b)
                bulls++;
            else
            {
                secretDigits[a-48]++;
                guessDigits[b-48]++;
            }
        }
        for(i = 0; i < 10; i++)
            cows += Math.min(secretDigits[i],guessDigits[i]);
        return Integer.toString(bulls)+"A"+Integer.toString(cows)+"B";      
    }
}