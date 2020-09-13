class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> merged = new ArrayList<int[]>();
        merged.add(newInterval);
        for(int i = 0; i < n; i++) {
            int[] currentInterval = intervals[i];
            boolean isMerged = false;
            for(int[] m : merged) {
                if(m[0] <= currentInterval[1] && currentInterval[0] <= m[1]) {
                    isMerged = true;
                    m[0] = Math.min(currentInterval[0], m[0]);
                    m[1] = Math.max(currentInterval[1], m[1]);
                }
            }
            if(!isMerged)
                merged.add(currentInterval);
        }
        Collections.sort(merged, new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                return a[0] - b[0];
            }
        });
        int[][] result = new int[merged.size()][2]; 
        for(int i = 0; i < merged.size(); i++)
            result[i] = merged.get(i);
        return result;
    }
}