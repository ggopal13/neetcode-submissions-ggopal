class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int i: stones)
            pq.add(i);
        
        while(pq.size() > 1){
            int top = pq.poll();
            int secondTop = pq.poll();
            if(top == secondTop) continue;
            pq.add(Math.abs(top-secondTop));
        }

        return pq.size() > 0 ? pq.poll() : 0;
    }
}
