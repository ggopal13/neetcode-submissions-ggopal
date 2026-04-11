class MyStack {

    private Queue<Integer> q;

    public MyStack() {
        q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        int[] temp = new int[q.size()];
        int index = 0;
        while(q.size()!=0)
            temp[index++] = q.poll();
        q.offer(x);
        for(int n: temp)
            q.offer(n);
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */