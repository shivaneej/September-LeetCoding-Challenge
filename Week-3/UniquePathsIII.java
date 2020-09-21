class Solution {
    public int uniquePathsIII(int[][] grid) {
        int startRow = 0, startCol = 0;
        int endRow = 0, endCol = 0;
        List<Integer> squaresToVisit = new ArrayList<Integer>();
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                int value = grid[row][col];
                if(value == 1) {
                    startRow = row; startCol = col;
                } else if(value == 2) {
                    endRow = row; endCol = col;
                }
                if(value >= 0)
                    squaresToVisit.add(row * 100 + col);
            }
        }
        return uniquePaths(startRow, startCol, endRow, endCol, grid, squaresToVisit);
    }
    
    public static int uniquePaths(int x1, int y1, int x2, int y2, int grid[][], List<Integer>squaresToVisit) {
        
        if(x1 == x2 && y1 == y2) {
            return squaresToVisit.size() == 1 ? 1 : 0;
        }
        List<Integer> clones = new ArrayList<Integer>();
        clones.addAll(squaresToVisit);
        clones.remove(new Integer(x1 * 100 + y1));
        int sum = 0;
        if(canTraverse(grid, x1 + 1, y1) && squaresToVisit.contains((x1 + 1) * 100 + y1)) 
            sum += uniquePaths(x1 + 1, y1, x2, y2, grid, clones);
        if(canTraverse(grid, x1 - 1, y1) && squaresToVisit.contains((x1 - 1) * 100 + y1)) 
            sum += uniquePaths(x1 - 1, y1, x2, y2, grid, clones);
        if(canTraverse(grid, x1, y1 + 1) && squaresToVisit.contains(x1 * 100 + y1 + 1)) 
            sum += uniquePaths(x1, y1 + 1, x2, y2, grid, clones);
        if(canTraverse(grid, x1, y1 - 1) && squaresToVisit.contains(x1 * 100 + y1 - 1)) 
            sum += uniquePaths(x1, y1 - 1, x2, y2, grid, clones);
        return sum;       
    }
    
    public static boolean canTraverse(int grid[][], int x, int y) {
        return ((x >= 0 && x < grid.length) && (y >= 0 && y < grid[0].length));
    }
}

    
