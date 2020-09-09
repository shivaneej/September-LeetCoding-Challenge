class Solution {
    public int compareVersion(String version1, String version2) {
        int a = version1.length(), b = version2.length();
        int i = 0, j = 0;
        while(i < a && j < b) {
            int indexOfPeriod1 = getNextPeriod(version1, i);
            int indexOfPeriod2 = getNextPeriod(version2, j);
            int revision1 = Integer.parseInt(version1.substring(i, indexOfPeriod1));
            int revision2 = Integer.parseInt(version2.substring(j, indexOfPeriod2));
            if(revision1 > revision2) return 1;
            else if(revision1 < revision2) return -1;
            else {
                i = indexOfPeriod1 + 1;
                j = indexOfPeriod2 + 1;
            }
        }
        if(i < a) return checkIfAllZeroOrPeriod(version1, i) ? 0 : 1;
        if(j < b) return checkIfAllZeroOrPeriod(version2, j) ? 0 : -1;
        return 0;
    }
    
    public static int getNextPeriod(String version, int start) {
        int indexOfPeriod = version.indexOf(".", start);
        return (indexOfPeriod == -1) ? version.length() : indexOfPeriod;
    }
    
    public static boolean checkIfAllZeroOrPeriod(String version, int index) {
        int n = version.length();
        for(int i = index; i < n; i++) {
            if(version.charAt(i) != '.' && version.charAt(i) != '0')
                return false;
        }
        return true;
    }
}