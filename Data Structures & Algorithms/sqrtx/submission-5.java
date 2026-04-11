class Solution {
    public int mySqrt(int x) {

        if(x==0 || x==1)
            return x;

        int l = 0;
        int r = x;
        int s = 0;

        while(l<=r){
            int mid = l + (r-l)/2;
            
            long exp = (long) mid*mid;
            if(exp == x)
                return mid;
            else if(exp>x)
                r = mid-1;
            else if(exp<x){
                
                s = mid;
                l = mid+1;
            }
        }
        return s;

    }
}