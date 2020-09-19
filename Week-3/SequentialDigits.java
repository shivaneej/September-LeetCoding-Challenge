class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> results = new ArrayList<Integer>();
        for(int i = 1; i <= 9; i++) {
            generateSequentialDigits(results, i, low, high);   
        }
        Collections.sort(results);
        return results;
    }
    public static void generateSequentialDigits(List<Integer> results, int currentNumber, int low, int high){
        if(currentNumber >= low && currentNumber <= high) {
            results.add(currentNumber);
        } else if(currentNumber > high) return;
        int lastDigit = currentNumber % 10;
        if(lastDigit < 9)
            generateSequentialDigits(results, currentNumber * 10 + lastDigit + 1, low, high);
    }
}
    