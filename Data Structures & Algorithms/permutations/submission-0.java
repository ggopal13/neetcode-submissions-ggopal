class Solution {

    private List<List<Integer>> res = new LinkedList<>();
    private boolean[] status = new boolean[6];

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,-1,new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int index, List<Integer> list){
        System.out.println("Index " + index + " , list = " + list);
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(status[i]) continue;
            list.add(nums[i]);
            status[i] = true;
            backtrack(nums,i,list);
            list.remove(list.size()-1);
            status[i] = false;
        }
    }
}
