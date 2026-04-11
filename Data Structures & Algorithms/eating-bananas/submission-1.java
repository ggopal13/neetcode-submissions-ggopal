class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);
        int ans = high;
        while(low<=high){
            int mid = low + (high-low)/2;

            int hoursTaken = hoursToConsume(piles,mid);

            if(hoursTaken > h){
                low = mid+1;
            }
            else{
                ans = Math.min(ans,mid);
                high = mid - 1;
            }
        }

        return ans;
    }

    private int hoursToConsume(int[] piles, int k){
        int h=0;
        for(int i = 0; i<piles.length;i++){
            int bananas = piles[i];
            h+=(bananas/k + (bananas%k == 0? 0: 1));
        }
        return h;
    }

    private int getMax(int[] piles){
        int max = piles[0];
        for(int i: piles)
            max = Math.max(max,i);
        return max;
    }
}
