class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<s.length(); i++)
            map.put(s.charAt(i),i);
        
        int i = 0;
        int lastIndex = 0;
        int currSize = 0;

        while(i<s.length()){
            currSize++;
            char c = s.charAt(i);
            int currLastIndex = map.get(c);

            lastIndex = Math.max(lastIndex,currLastIndex);

            if(i==lastIndex){
                res.add(currSize);
                lastIndex = i+1;
                currSize = 0;
            }

            i++;

        }

        return res;
    }
}
