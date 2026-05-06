class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        nums = Arrays.stream(nums)
                         .boxed()
                         .sorted(Collections.reverseOrder())
                         .mapToInt(Integer::intValue)
                         .toArray();
        int n = nums.length;
        int total = 0;

        for(int i = 0; i<n; i++){
            total+=nums[i];
        }

        if(total % k != 0)
            return false;
        
        int side = total/k;
        int[] sides = new int[k];

        return backtrack(nums, 0, sides, side, k);
    }

    private boolean backtrack(int[] matchsticks, int index, int[] sides, int side, int k){
        
        if(index >= matchsticks.length )
            return checkEqual(sides);

        for(int i = 0; i<k; i++){
            if(sides[i] + matchsticks[index]<= side){
 sides[i] += matchsticks[index];
            if(backtrack(matchsticks, index+1, sides, side, k))
                return true;
            sides[i] -= matchsticks[index];
            }
           
        }

        return false;
    }

    private boolean checkEqual(int[] sides){
        int n = sides.length;
        int s = sides[0];
        for(int i = 1; i<n; i++){
            if(sides[i] != s)
                return false;
        }
        return true;
    }
}