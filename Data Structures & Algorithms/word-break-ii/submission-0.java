class Solution {

    List<String> ans = new LinkedList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<Integer> hash = new HashSet<>();
        for(String k: wordDict){
            hash.add(k.hashCode());
        }    
        fillUpSentences(s,hash,new ArrayList<>());
        return ans;
    }

    private void fillUpSentences(String s, Set<Integer> hash, List<String> curr){
        if(s.length()==0){
            ans.add(String.join(" ",curr));
            return;
        }
        for(int i = 0; i<s.length(); i++){
            if(hash.contains(s.substring(0,i+1).hashCode())){
                curr.add(s.substring(0,i+1));
                fillUpSentences(s.substring(i+1),hash,curr);
                curr.remove(curr.size()-1);
            }
        }
    }


}