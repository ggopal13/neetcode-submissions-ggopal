class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();

        for(int h: hand)
            map.put(h, map.getOrDefault(h,0) + 1);

        int k = 0;

        while(k<hand.length){
            int element = hand[k];
            if(map.get(element) <= 0){
                k++;
                continue;
            }
            for(int i = 0; i<groupSize; i++){
                if(!map.containsKey(element + i) || map.get(element + i) <= 0)
                    return false;
                map.put(element + i, map.get(element + i) - 1);
            }
            k++;
        }
        
        return true;

    }
}
