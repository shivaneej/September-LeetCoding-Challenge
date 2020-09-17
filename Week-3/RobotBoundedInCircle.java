class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] navigation = navigate(instructions, 0, 0, 'N');
        return ((navigation[0] == 0 && navigation[1] == 0) || navigation[2] != 'N');
    }
    
    public static int[] navigate(String instructions, int currentX, int currentY, char currentDirection) {
        int n = instructions.length();
        for(int i = 0; i < n; i++) {
            char currentInst = instructions.charAt(i);
            if(currentInst == 'G') {
                if(currentDirection == 'N')
                    currentX++;
                else if(currentDirection == 'S')
                    currentX--;
                else if(currentDirection == 'W')
                    currentY--;
                else if(currentDirection == 'E')
                    currentY++;
            } else 
                currentDirection = turn(currentDirection, currentInst);
        }
        return new int[] {currentX, currentY, (int) currentDirection};
    }
    public static char turn(char currentDirection, char inst) {
        if(currentDirection == 'N')
            return (inst == 'L') ? 'W' : 'E';
        else if(currentDirection == 'S')
            return (inst == 'L') ? 'E' : 'W';
        else if(currentDirection == 'W')
            return (inst == 'L') ? 'S' : 'N';
        else if(currentDirection == 'E')
            return (inst == 'L') ? 'N' : 'S';
        return ' ';
    }
}