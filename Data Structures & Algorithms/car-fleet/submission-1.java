class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for(int i = 0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for(int[] pair: cars){
            double timeToTarget = (double)(target-pair[0])/pair[1];
            if(stack.size() >= 1 && stack.peek() >= timeToTarget){
                continue;
            }
            else
                stack.push(timeToTarget);
        }

        return stack.size();
    }
}
