/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int low = 0;
        int high = n-2;

        while(low<high){
            int mid = (low+high) >> 1;

            int val = mountainArr.get(mid);
            int nextVal = mountainArr.get(mid+1);

            if(val<nextVal){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }

        int peak = low;

        low = 0;
        high = peak;

        while(low<=high){
            int mid = (low+high) >> 1;

            int val = mountainArr.get(mid);

            if(val == target)
                return mid;
            if(val<target)
                low = mid+1;
            else
                high = mid-1;
        }

        low = peak+1;
        high = n-1;

        while(low<=high){
            int mid = (low+high) >> 1;

            int val = mountainArr.get(mid);

            if(val == target)
                return mid;
            if(val>target)
                low = mid+1;
            else
                high = mid-1;
        }


        return -1;

        
    }
}