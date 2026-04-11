class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if(n>m){
            return findMedianSortedArrays(nums2,nums1);
        }

        int total = n+m;
        int lHalf = (total+1)/2;

        int low = 0;
        int high = Math.min(n,lHalf);

        while(low<=high){
            int lMid = low + (high-low)/2;

            int rMid = lHalf - lMid;

            int lMax = lMid > 0? nums1[lMid-1] : Integer.MIN_VALUE;
            int rMax = rMid > 0? nums2[rMid-1] : Integer.MIN_VALUE;
            int lMin = lMid<n? nums1[lMid]: Integer.MAX_VALUE;
            int rMin = rMid<m? nums2[rMid]: Integer.MAX_VALUE;

            if(lMax<=rMin && rMax<=lMin){
                return total%2 == 0? ((Math.max(lMax,rMax) + Math.min(lMin,rMin))/2.0): (Math.max(lMax,rMax));
            }
            if(lMax>rMin){
                high = lMid-1;
            }
            else{
                low = lMid+1;
            }
        }

        return 0.0;
    }
}
