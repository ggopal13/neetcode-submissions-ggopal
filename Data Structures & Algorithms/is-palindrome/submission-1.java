class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        int i = 0;
        int j = n-1;

        while(i<j){
            char ci = Character.toUpperCase(s.charAt(i));
            char cj = Character.toUpperCase(s.charAt(j));
            if(!Character.isLetterOrDigit(ci)){
                i++;
            }
            else if(!Character.isLetterOrDigit(cj)){
                j--;
            }
            else{
                if(ci!=cj)
                    return false;
                i++;
                j--;
            }
        }

        return true;
    }
}
