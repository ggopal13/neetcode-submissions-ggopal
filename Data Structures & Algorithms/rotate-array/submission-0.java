class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        if(k == 0)
            return;
        
        while(k-->0){
            int last = nums[n-1];
            
            for(int i = n-1; i>=1; i--){
                nums[i] = nums[i-1];
            }

            nums[0] = last;
        }

    
    }
}