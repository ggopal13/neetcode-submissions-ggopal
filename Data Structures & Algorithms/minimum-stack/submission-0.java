class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(min.empty()){
            min.push(val);
        }
        else{
            int lastMin = min.peek();
            if(lastMin >= val)
                min.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        int val = stack.pop();
        if(val == min.peek())
            min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
