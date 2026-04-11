class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int ans = 0;
        while(j<s.length()){
            char c = s.charAt(j);
            if(set.contains(c)){
                ans = Math.max(ans, j-i);
                while(set.contains(c)){
                    set.remove(s.charAt(i++));
                }
            }
            else{
                set.add(c);
                j++;
            }
        }
        ans = Math.max(ans,j-i);
        return ans;
    }
}
