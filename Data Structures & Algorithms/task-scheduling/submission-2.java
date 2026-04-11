class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> b.frequency - a.frequency
        );

        Queue<Pair> q = new LinkedList<>();

        Map<Character,Integer> map = new HashMap<>();

        for(char c: tasks){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character,Integer> e: map.entrySet()){
            pq.add(new Pair(e.getKey(),e.getValue(),0));
        }

        int cycles = 0;
        while(pq.size() > 0 || q.size() > 0){
            cycles++;
            if(pq.size() > 0){
                Pair p = pq.poll();
                if(p.frequency != 1){
                    p.frequency = p.frequency - 1;
                    p.next = cycles+n;
                    q.offer(p);
                }
            }
            
                Pair p = q.peek();
                if(p!=null && p.next == cycles){
                    pq.add(p);
                    q.poll();
                }
            

            
            

        }

        return cycles;
    }

    class Pair{
        char c;
        int frequency;
        int next;

        public Pair(char c, int freq, int next){
            this.c = c;
            this.frequency = freq;
            this.next = this.next;
        }

        public String toString(){
            return c + " " + frequency + " " + next;
        }
    }
}
