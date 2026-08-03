class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        int j = 0;

        while(j<nums.length){
            curr+=nums[j];
            max = Math.max(curr,max);
            if(curr<0) curr = 0;
            j++;
        }

        return max;
    }
}
