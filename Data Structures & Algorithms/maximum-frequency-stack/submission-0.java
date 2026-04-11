class FreqStack {

    private PriorityQueue<int[]> heap;
    private Map<Integer, Integer> map;
    int index;

    public FreqStack() {
        heap = new PriorityQueue<>(
            (a,b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]
        );
        map = new HashMap<>();
        index=0;
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val,0)+1);
        int[] element = new int[]{map.get(val),index++,val};
        heap.offer(element);
    }
    
    public int pop() {
        int[] maxElement = heap.poll();
        int val = maxElement[2];
        map.put(val,map.get(val)-1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */