class Solution {
    public int splitArray(int[] nums, int k) {
        int low = nums[0];
        int high = 0;
        for(int i: nums){
            low = Math.max(low,i);
            high+=i;
        }

        while(low<=high){
            int mid = low + (high-low)/2;

            if(canSplit(nums,k,mid)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return low;
    }

    private boolean canSplit(int[] nums, int k, int maxSum){
        int count = 1;
        int currSum = 0;
        for(int i: nums){
            if(currSum+i > maxSum){
                count++;
                currSum = 0;
            }

            currSum+=i;
        }

        return count <= k;
    }
}