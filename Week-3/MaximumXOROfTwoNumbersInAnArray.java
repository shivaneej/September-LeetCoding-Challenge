class Solution {
    public int findMaximumXOR(int[] nums) {
        if(nums.length == 0) return 0;
        int maxXOR = Integer.MIN_VALUE;
        Trie root = new Trie();
        for(int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            Trie currentNode = root;
            for(int bit = 31; bit >= 0; bit--) {
                int currentBit = (currentNum >>> bit) & 1;
                if(currentNode.children[currentBit] == null)
                    currentNode.children[currentBit] = new Trie();
                currentNode = currentNode.children[currentBit];
            }
        }
        for(int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            Trie currentNode = root;
            int currentXOR = 0;
            for(int bit = 31; bit >= 0; bit--) {
                int currentBit = (currentNum >>> bit) & 1;
                if(currentNode.children[currentBit ^ 1] == null)
                    currentNode = currentNode.children[currentBit];
                else {
                    currentXOR += (1 << bit);
                    currentNode = currentNode.children[currentBit ^ 1];
                }
            }
            maxXOR = Math.max(maxXOR, currentXOR);
        }
        return maxXOR;
    }
}

class Trie {
    Trie children[];
    public Trie() {
        children = new Trie[2];
    }
}