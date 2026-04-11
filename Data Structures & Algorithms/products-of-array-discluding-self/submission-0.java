class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixSums = new int[n+1];
        int[] suffixSums = new int[n+1];

        prefixSums[0] = suffixSums[0] = prefixSums[n] = suffixSums[n] = 1;

        for(int i = 0; i<n; i++){
            prefixSums[i+1] = prefixSums[i] * nums[i];
        }

        for(int i = n-1; i>=0; i--){
            suffixSums[i] = suffixSums[i+1] * nums[i];
        }

        int[] res = new int[n];
        for(int i = 0; i<n ;i++){
            res[i] = suffixSums[i+1] * prefixSums[i];
        }

        return res;
    }
}  
