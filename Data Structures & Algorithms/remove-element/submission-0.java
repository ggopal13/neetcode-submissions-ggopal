class Solution {
    public int removeElement(int[] nums, int val) {
        List<Integer> list = new ArrayList<>();
        for(int i: nums){
            if(i!=val)
                list.add(i);
        }

        int count = 0;
        for(int i: list){
            nums[count++] = i;
        }

        return count;
    }
}