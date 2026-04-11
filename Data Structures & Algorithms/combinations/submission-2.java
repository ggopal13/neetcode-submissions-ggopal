class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(n,k,0,res,new ArrayList<>());
        return res;
    }

    private void backtrack(int n, int k, int index, List<List<Integer>> res, List<Integer> list){

        if(list.size() == k){
                res.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i<n; i++){
            list.add(i+1);
            backtrack(n,k,i+1,res,list);
            list.remove(list.size()-1);
        }

    }
}