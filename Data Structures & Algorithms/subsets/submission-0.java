class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        Set<List<Integer>> set = new HashSet<>();
        compute(nums,0,new ArrayList<>(),set);
        return new ArrayList<>(set);
    }

    private void compute(int[] nums, int index, List<Integer> list, Set<List<Integer>> set){
        if(nums.length == index){
            set.add(new ArrayList<>(list));
            return;
        }
        
        list.add(nums[index]);
        compute(nums,index+1,list,set);
        list.remove(list.size()-1);
        compute(nums,index+1,list,set);

    }
}
