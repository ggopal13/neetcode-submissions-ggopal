class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0)
            return 0;

        Arrays.sort(nums);

        int streak = 1;
        int res = 1;
        
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == nums[i-1]+1)
                streak++;
            else if(nums[i] == nums[i-1])
                continue;
            else{
                streak =1;
            }
            res = Math.max(res,streak);
        }

        return res;
    }
}
