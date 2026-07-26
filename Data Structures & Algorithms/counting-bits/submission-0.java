class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        while(n>=1){
            int count = 0;
            int r = n;
            while(r!=0){
                count++;
                r = r & (r-1);
            }
            arr[n] = count;
            n--;
        }
        return arr;
    }
}
