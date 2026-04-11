class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(new ArrayList<Integer>(),nums,target,0, 0);
        return res;
    }

   private void backtrack(List<Integer> list, int[] nums, int target, int current, int index){
        if(current == target){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(current > target){
            return;
        }

        for(int j = index; j<nums.length; j++){
            list.add(nums[j]);
            backtrack(list,nums,target,current+nums[j],j);
            list.remove(list.size()-1);
        }

        
    }
}
