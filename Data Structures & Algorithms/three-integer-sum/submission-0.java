class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++)
            map.put(nums[i],i);
        
        int n = nums.length;

        for(int i = 0; i<n; i++){
            for(int j = i + 1; j<n; j++){
                int sum = nums[i] + nums[j];
                int needed = -1*sum;
                if(map.containsKey(needed)){
                    int index = map.get(needed);
                    if(index!=i && index!=j){
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[i]);list.add(nums[j]);list.add(nums[index]);
                        Collections.sort(list);
                        res.add(list);
                    }
                }
            }
        }

        return new LinkedList<>(res);
    }
}
