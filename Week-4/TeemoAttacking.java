class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int prevEnd = -1;
        int n = timeSeries.length;
        int totalDuration = 0;
        for(int i = 0; i < n; i++) {
            int currentStart = timeSeries[i];
            if(currentStart <= prevEnd) {
                totalDuration += duration - (prevEnd - currentStart + 1);
            } else {
                totalDuration += duration; 
            }
            prevEnd = currentStart + duration - 1;
        }
        return totalDuration;
    }
}