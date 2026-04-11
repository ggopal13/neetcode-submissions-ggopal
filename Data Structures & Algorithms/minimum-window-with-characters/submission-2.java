class Solution {
    public String minWindow(String s, String t) {
        
        if(t.isEmpty())
        return "";

        Map<Character,Integer> tCount = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        for(char c: t.toCharArray())
            tCount.put(c, tCount.getOrDefault(c,0) +1);

        int need = tCount.size();
        int have = 0;
        int n = s.length();
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int[] resIndex = {-1,-1};

        for(int right = 0; right<n;right++){
            char c = s.charAt(right);

            window.put(c, window.getOrDefault(c,0) + 1);

            if(tCount.containsKey(c) && tCount.get(c).equals(window.get(c)))
                have++;

            while(have == need){
                int resultLen = right-left+1;
                if(resultLen<ans){
                    ans = resultLen;
                    resIndex[0] = left;
                    resIndex[1] = right;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar,window.get(leftChar) - 1);

                if(tCount.containsKey(leftChar) && window.get(leftChar) < tCount.get(leftChar))
                    have--;
                left++;
            }


        }

        return ans == Integer.MAX_VALUE ? "" : s.substring(resIndex[0], resIndex[1]+1);
    }
}
