class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int low = 0;
        int high = n-1;

        int max = 0;

        while(low<high){
            int water = Math.min(heights[low], heights[high]) * (high - low);

            max = Math.max(max,water);

            if(heights[low] < heights[high])
                low++;
            else
                high--;

        }
        return max;
    }
}
