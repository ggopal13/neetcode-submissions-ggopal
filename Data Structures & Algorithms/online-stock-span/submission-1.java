class StockSpanner {

    Stack<int[]> stack = new Stack<>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {

        int span = 1;

        while(!stack.empty() && stack.peek()[0] <= price){
            int[] pair = stack.pop();
            span+=pair[1];
        }

        stack.push(new int[]{price,span});

        return span;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */