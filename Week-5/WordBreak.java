class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        return canSplit(s, wordDict, map);
    }
    public static boolean canSplit(String s, List<String> dict, HashMap<String, Boolean> map) {
        if(dict.contains(s)) return true;
        if(map.containsKey(s)) return map.get(s);
        int n = s.length();
        for(int i = 1; i < n; i++) {
            if(dict.contains(s.substring(0, i)) && canSplit(s.substring(i), dict, map)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
