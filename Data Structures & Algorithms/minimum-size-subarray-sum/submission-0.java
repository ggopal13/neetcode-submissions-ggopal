class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length;

        int left = 0;
        int currMax = Integer.MAX_VALUE;
        int currSum = 0;

        for(int right = 0; right<n; right++){
            currSum += nums[right];

            if(currSum>=target){
                while(currSum>=target){
                    currMax = Math.min(currMax,right-left+1);
                    currSum -= nums[left++];
                }
            }

        }

        return currMax == Integer.MAX_VALUE ? 0: currMax;
    }
}