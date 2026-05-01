class Solution {

    private List<List<String>> res = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtrack(s,0,new ArrayList<>());
        return res;
    }

    private void backtrack(String s, int i, List<String> temp){
        if(i>= s.length()){
            res.add(new ArrayList<>(temp));
        }

        for(int k=i; k<s.length(); k++){
            if(isPalindrome(s,i,k)){
                temp.add(s.substring(i,k+1));
                backtrack(s,k+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }


    private boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))
                return false;
        }
        return true;
    }
}
