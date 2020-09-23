class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, start = 0, balanceGas = 0;
        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            balanceGas += gas[i] - cost[i];
            if(balanceGas < 0) {
                balanceGas = 0;
                start = i + 1;
            }
        }
        return (totalGas < 0) ? -1 : start;  
    }
}