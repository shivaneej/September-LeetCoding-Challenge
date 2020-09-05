class Solution {
    public List<Integer> partitionLabels(String s) {
        List <Integer> result = new ArrayList<Integer>();
        int lastIndex[] = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            lastIndex[index] = i;
        }
        int partitionStart = 0, partitionEnd= -1;
        for(int i = 0; i < n; i++) {
            char current = s.charAt(i);
            int  currentLastIndex = lastIndex[current - 'a'];
            partitionEnd = Math.max(partitionEnd, currentLastIndex);
            if(i == partitionEnd) {
                result.add(partitionEnd - partitionStart + 1);
                partitionStart = partitionEnd + 1;
            }
        }
        return result;
    }
}