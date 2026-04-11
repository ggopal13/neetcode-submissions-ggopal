class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String op: operations){
            switch(op){
                case "+":
                    int first = stack.pop();
                    int second = stack.pop();
                    int sum = first + second;
                    stack.push(second);
                    stack.push(first);
                    stack.push(sum);
                    break;
                
                case "D":
                    int newScore = 2*stack.peek();
                    stack.push(newScore);
                    break;
                
                case "C":
                    stack.pop();
                    break;
                
                default:
                    int num = Integer.parseInt(op);
                    stack.push(num);
            }
        }

        int sum = 0;
        while(!stack.empty())
            sum += (stack.pop());

        return sum;
    }
}