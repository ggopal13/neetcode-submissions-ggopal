class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList<>(),0);
        return res;
    }

    private void backtrack(int[] nums, int target, int index, List<Integer> list, int current){
        if(current > target){
            return;
        }

        if(current == target){
            res.add(new ArrayList<>(list));
        }

        for(int i = index; i<nums.length; i++){
            if(i>index && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            backtrack(nums,target, i+1,list, current + nums[i]);
            list.remove(list.size()-1);
        }
    }
}
