class Solution {

    private List<String> res = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        
        if(digits.length()==0)
            return res;

        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backtrack(0,digits,map,new StringBuilder());
        return res;
    }

    private void backtrack(int i, String digits, Map<Character,String> map, StringBuilder sb){
        if(i >= digits.length()){
            res.add(sb.toString());
            return;
        }

        char c = digits.charAt(i);
        String letters = map.get(c);

        for(char ch: letters.toCharArray()){
            sb.append(ch);
            backtrack(i+1,digits,map,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
