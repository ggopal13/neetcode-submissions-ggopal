class Solution {
    public boolean makesquare(int[] matchsticks) {
        matchsticks = Arrays.stream(matchsticks)
                         .boxed()
                         .sorted(Collections.reverseOrder())
                         .mapToInt(Integer::intValue)
                         .toArray();
        int n = matchsticks.length;
        int total = 0;

        for(int i = 0; i<n; i++){
            total+=matchsticks[i];
        }

        if(total % 4 != 0)
            return false;
        
        int side = total/4;
        int[] sides = new int[4];

        return backtrack(matchsticks, 0, sides, side);

    }

    private boolean backtrack(int[] matchsticks, int index, int[] sides, int side){
        
        if(index >= matchsticks.length )
            return (sides[0] == sides[1]) && (sides[2] == sides[3]) && (sides[1] == sides[2]);

        for(int i = 0; i<4; i++){
            if(sides[i] + matchsticks[index]<= side){
 sides[i] += matchsticks[index];
            if(backtrack(matchsticks, index+1, sides, side))
                return true;
            sides[i] -= matchsticks[index];
            }
           
        }

        return false;
    }
}