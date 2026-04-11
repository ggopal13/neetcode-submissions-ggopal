class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int n = s2.length();

        if(k>n) return false;

        int left = 0;
        int right = 0;

        int[] targetCounts = getCounts(s1);
        int[] windowCounts = new int[26];

        while(right<n){
            windowCounts[s2.charAt(right++) - 'a']++;

            if(right-left == k){
                if(Arrays.equals(windowCounts, targetCounts))
                    return true;
                
                windowCounts[s2.charAt(left++) - 'a']--;
            }
        }

        return false;

    }

    private int[] getCounts(String s){
        int[] counts = new int[26];
        for(char c: s.toCharArray())
            counts[c - 'a']++;
        return counts;
    }
}