class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int closestIndex = 0;
        for(int i = 1; i<n;i++){
            if(Math.abs(arr[i]-x) < Math.abs(arr[closestIndex] -x))
                closestIndex = i;
        }

        int left = closestIndex - 1;
        int right = closestIndex+1;

        List<Integer> res = new LinkedList();
        res.add(arr[closestIndex]);

        while(res.size()<k){
            if(left<0){
                res.add(arr[right++]);
            }
            else if(right>n-1){
                res.add(arr[left--]);
            }
            else{
                if(Math.abs(arr[left]-x)>Math.abs(arr[right] -x))
                    res.add(arr[right++]);
                else
                    res.add(arr[left--]);
            }
        }

        Collections.sort(res);
        return res;
    }


}