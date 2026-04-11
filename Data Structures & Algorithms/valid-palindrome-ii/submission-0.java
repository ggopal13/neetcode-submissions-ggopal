class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i = 0;
         int j = n-1;
        while(i<j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(ci!=cj){
                return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int l, int r){
        while(l<r){
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            if(cl!=cr)
                return false;
            l++;
            r--;
        }

        return true;
    }
}