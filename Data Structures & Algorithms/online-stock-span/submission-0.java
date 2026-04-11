class StockSpanner {

    Stack<Integer> stack = new Stack<>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {

        // if(!stack.empty() && stack.peek() > price){

        // }
        
        Stack<Integer> temp = new Stack<>();

        while(!stack.empty() && stack.peek() <= price){
            temp.push(stack.pop());
        }

        int res = temp.size();

        while(!temp.empty())
            stack.push(temp.pop());

        stack.push(price);
        
        return res + 1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */