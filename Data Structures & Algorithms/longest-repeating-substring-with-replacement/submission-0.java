class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int ans = 0;
        int n = s.length();

        int left = 0;

        for(int right = 0; right<n;right++){
            char c = s.charAt(right);
            freqMap.put(c,freqMap.getOrDefault(c,0) + 1);

            maxFreq = Math.max(maxFreq,freqMap.get(c));

            while(right - left + 1 - maxFreq > k){
                freqMap.put(s.charAt(left),freqMap.get(s.charAt(left++)) - 1);
            }

            ans = Math.max(ans,right-left+1);
        }

        return ans;
    }
}
