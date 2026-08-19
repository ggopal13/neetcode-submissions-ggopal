class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1)
            return nums[0];

        int val1 = dfs(Arrays.copyOfRange(nums,1,nums.length));
        int val2 = dfs(Arrays.copyOfRange(nums,0,nums.length-1));

        return Math.max(val1,val2);
    }

    private int dfs(int[] nums){

        if(nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);

        for(int i = 2; i<nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[nums.length-1];

        
    }
}
