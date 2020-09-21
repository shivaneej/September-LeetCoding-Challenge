class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        HashMap<Integer, Integer> overlap = new HashMap<Integer, Integer>();
        for(int i = 0; i <  trips.length; i++){
            int currentTrip[] = trips[i];
            for(int j = currentTrip[1]; j < currentTrip[2]; j++) {
                Integer current = overlap.getOrDefault(j, 0);
                if(currentTrip[0] + current > capacity)
                    return false;
                overlap.put(j, currentTrip[0] + current);
            }
            
        }
        return true;
    }
}