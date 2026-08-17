class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        dfs(0,nums, memo);
        return memo[0];
    }

    private int dfs(int index, int[] nums, int[] memo){
        if(index>=nums.length)
            return 0;

        if(memo[index] == 0)
            memo[index] = Math.max(
            nums[index] + dfs(index+2,nums,memo),
            dfs(index+1,nums,memo)
        );
        return memo[index];
    }
}
