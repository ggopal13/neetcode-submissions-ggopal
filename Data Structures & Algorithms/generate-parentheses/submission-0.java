class Solution {
    private List<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        generateParenthesis(n,0,0,new StringBuilder());
        return res;
    }

    private void generateParenthesis(int n, int open, int close, StringBuilder sb){
        if(sb.length() == 2*n){
            res.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append('(');
            generateParenthesis(n,open+1,close,sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(open>close){
            sb.append(')');
            generateParenthesis(n,open,close + 1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
