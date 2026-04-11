class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] leftMost = new int[n];
        int[] rightMost = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<n; i++){
            int currHeight = heights[i];

            while(!stack.empty() && heights[stack.peek()] >= currHeight){
                stack.pop();
            }

            if(!stack.empty())
            leftMost[i] = stack.peek() + 1;

            stack.push(i);
        }
        System.out.println(Arrays.toString(leftMost));
        stack.clear();

        for(int i = n-1; i>=0; i--){
            rightMost[i] = n-1;
            int currHeight = heights[i];
            while(!stack.empty() && heights[stack.peek()] >= currHeight){
                stack.pop();
            }

            if(!stack.empty())
                rightMost[i] = stack.peek() - 1;

            stack.push(i);
        }
        System.out.println(Arrays.toString(rightMost));

        int maxRect = 0;

        for(int i = 0; i<n;i++){
            int area = heights[i] * (rightMost[i] - leftMost[i] + 1);
            maxRect = Math.max(area,maxRect);
        }

        return maxRect;
    }
}
