class Solution {

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,new ArrayList<>(),0);

        return res;
    }

    private void backtrack(int[] nums, List<Integer> list, int index){
        
        if(index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        backtrack(nums,list,index+1);
        list.remove(list.size() -1);
        
        while(index + 1 < nums.length && nums[index+1] == nums[index])
            index++;
        
        backtrack(nums,list,index+1);
    }
}
