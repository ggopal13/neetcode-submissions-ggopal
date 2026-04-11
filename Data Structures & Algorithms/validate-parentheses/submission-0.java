class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(c == '{' || c =='[' || c == '(')
                stack.push(c);
            else{
                if(stack.empty())
                    return false;
                
                char lastChar = stack.pop();

                if(c==']' && lastChar!='[')
                    return false;
                if(c=='}' && lastChar!='{')
                    return false;
                if(c==')' && lastChar!='(')
                    return false;
            }
        }

        return stack.empty();
    }
}
