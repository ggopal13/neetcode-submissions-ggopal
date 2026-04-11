class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = maxRight[n-1] = 0;

        for(int i = 1; i<n; i++){
            maxLeft[i] = Math.max(maxLeft[i-1],height[i-1]);
        }

        for(int i = n-2; i>-1; i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }

        int count = 0;

        for(int i = 0; i<n; i++){
            int water = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if(water>0)
            count += (Math.min(maxLeft[i], maxRight[i]) - height[i]);
        }

        return count;
    }
}
