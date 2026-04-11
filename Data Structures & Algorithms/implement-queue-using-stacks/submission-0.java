class MyQueue {

    Stack<Integer> stack ;
    Stack<Integer> helper;
    public MyQueue() {
        stack = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) {
        while(!stack.empty()){
            helper.push(stack.pop());
        }
        stack.push(x);
        while(!helper.empty())
            stack.push(helper.pop());
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */