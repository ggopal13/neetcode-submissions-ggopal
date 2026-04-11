class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int n = nums.length;
        int left = 0;
        int right = 0;
        for(;right<=k-2;right++)
            pq.add(nums[right]);
        
        List<Integer> ans = new LinkedList<>();

        while(right<n){
            pq.add(nums[right++]);
            ans.add(pq.peek());
            pq.remove(nums[left++]);
        }

        return ans.stream().mapToInt(i->i).toArray();
    }
}
