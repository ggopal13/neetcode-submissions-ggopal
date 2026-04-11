class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            
            if(s.charAt(i) != ']'){
                stack.push(String.valueOf(s.charAt(i)));
            }
            else{

                StringBuilder subString = new StringBuilder();

                while(stack.peek().charAt(0) != '['){
                    subString.insert(0,stack.pop());
                }
                stack.pop();

                StringBuilder number = new StringBuilder();
                while(!stack.empty() && Character.isDigit(stack.peek().charAt(0))){
                    number.insert(0,stack.pop());
                }

                int count = Integer.parseInt(number.toString());
                String resultWord = subString.toString().repeat(count);
                stack.push(resultWord);
            }

        }

        StringBuilder sb = new StringBuilder();
        for(String res: stack)
            sb.append(res);
        
        return sb.toString();
    }
}