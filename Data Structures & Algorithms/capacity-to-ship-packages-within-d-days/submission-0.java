class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0];
        int high = 0;
        for(int i: weights){
            low = Math.max(low,i);
            high += i;
        }
        int ans = high;

        while(low<=high){
            int mid = low + (high-low)/2;

            int totalDaysTaken = getTotalDays(weights,mid);

            if(totalDaysTaken > days){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }

        return ans;
    }

    private int getTotalDays(int[] weights, int capacity){
        int days=1;
        int current = 0;
        for(int i: weights){
            if(i+current> capacity){
                days++;
                current = 0;
            }
            current+=i;
        }
        return days;
    }
}