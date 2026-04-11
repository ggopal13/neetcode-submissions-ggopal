class Solution {
    public void sortColors(int[] nums) {
        // int[] count = new int[3];
        // for(int i: nums)
        //     count[i]++;
        // int k = 0;
        // for(int i = 0; i<3;i++){
        //     while(count[i]-->0){
        //         nums[k++] = i;
        //     }
        // }
        int n = nums.length;
        int i = -1;
        int j = 0;
        int k = n-1;

        while(j<=k){
            if(nums[j] == 0){
                swap(nums,++i,j++);
            }
            else if(nums[j] == 2){
                swap(nums,k--,j);
            }
            else if(nums[j] == 1)
                j++;
        }
    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}