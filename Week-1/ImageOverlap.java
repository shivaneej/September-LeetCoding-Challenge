class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        int largestOverlap = Integer.MIN_VALUE;
        for(int i = -n + 1; i < n; i++) {
            for(int j = -n + 1; j < n; j++) {
                largestOverlap = Math.max(largestOverlap, getOverlap(A, B, i, j));
            }
        }
        return largestOverlap;
    }
    
    private static int getOverlap(int A[][], int B[][], int rowOffset, int colOffset) {
        int n = A.length;
        int overlapCount = 0;
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if((row + rowOffset < 0 || row + rowOffset >= n) ||
                   (col + colOffset < 0 || col + colOffset >= n) ||
                   (A[row][col] + B[row + rowOffset][col + colOffset] != 2))
                    continue;
              overlapCount++;  
            }
        }
        return overlapCount;
    }
}