class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int j = 1;

        while(j<nums.length){
            if(nums[j] != nums[index]){
                // int temp = nums[++index];
                nums[++index] = nums[j];
                // nums[j] = temp;
            }
            j++;
        }

        return index+1;
    }
}