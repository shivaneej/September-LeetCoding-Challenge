class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> charMapping = new HashMap<Character, String>();
        HashMap<String, Character> strMapping = new HashMap<String, Character>();
        String[] words = str.split(" ");
        if(words.length != pattern.length()) return false;
        int n = words.length;
        for(int i = 0; i < n; i++) {
            char current = pattern.charAt(i);
            String word = words[i].strip();
            if(charMapping.containsKey(current) && strMapping.containsKey(word)) {
                if(!charMapping.get(current).equals(word) || strMapping.get(word) != current)
                    return false;
            } else if(!charMapping.containsKey(current) && !strMapping.containsKey(word)) {
                charMapping.put(current, word);
                strMapping.put(word, current);
            } else return false;
        }
        return true;
    }
}