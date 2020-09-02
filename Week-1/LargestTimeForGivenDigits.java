class Solution {
    
    public String largestTimeFromDigits(int[] A) {
        ArrayList<String> results = new ArrayList<String>();
        permutations(A, 0, results);
        return (results.size() == 0) ? "" : Collections.max(results);
    }
    
    public static void permutations(int arr[], int index, ArrayList<String> results) {
        if(index >= arr.length - 1) {
            String timeString = convertToValidTimeString(arr);
            if(timeString != null) {
                results.add(timeString);
            }
        } else {
            for(int i = index; i < arr.length; i++) {
                swap(arr, i, index);
                permutations(arr, index + 1, results);
                swap(arr, i, index);
            }   
        }
    }
    
    public static String convertToValidTimeString(int arr[]) {
        int hours = arr[0]*10 + arr[1];
        int minutes = arr[2]*10 + arr[3];
        if(hours < 24 && minutes < 60)
            return String.format("%02d", hours) + ":" + String.format("%02d", minutes);
        return null;
    }
    
    public static void swap(int arr[], int i, int j) {
        if(i == j) return;
        arr[i] += arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] -= arr[j];
    }
}