class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        createCombinations(k, n, result, new ArrayList<Integer>(), 1);
        return result;
    }
    private static void createCombinations(int k, int n, List<List<Integer>> result, List<Integer> combination, int start) {
        if(k == combination.size() && n == 0) {
            result.add(new ArrayList(combination));
            return;
        }
        for(int i = start; i <= 9; i++) {
            if(n - i >= 0) {
                combination.add(i);
                createCombinations(k, n - i, result, combination, i + 1);
                combination.remove(new Integer(i));
            } else break;
        }
    }
}