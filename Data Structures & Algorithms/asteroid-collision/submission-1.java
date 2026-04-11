class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int n: asteroids){
            while(!stack.empty() && (stack.peek() > 0 && n < 0)){
                int diff = stack.peek() + n;

                if(diff > 0){
                    n = 0;
                }
                else if(diff < 0){
                    stack.pop();
                }
                else if(diff == 0){
                    stack.pop();
                    n = 0;
                }
            }
            if(n!=0)
                stack.push(n);
        }

        int[] res = new int[stack.size()];

        int index = stack.size()-1;

        while(!stack.empty())
            res[index--] = stack.pop();

        return res;
    }
}