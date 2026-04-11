class Solution {
    public boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        if(sLength!=tLength)
            return false;
        
        int[] sFreq = new int[200];
        int[] tFreq = new int[200];

        for(char c: s.toCharArray()){
            sFreq[c-'a']++;
        }

        for(char c: t.toCharArray()){
            tFreq[c-'a']++;
        }

        for(int i = 0; i<26; i++)
            if(sFreq[i]!=tFreq[i])
                return false;
        
        return true;
    }
}
