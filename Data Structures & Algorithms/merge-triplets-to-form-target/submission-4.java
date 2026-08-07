class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {


        int count = 0;

        int one = 0;
        int two = 0;
        int three = 0;

        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2])
                continue;
            if(triplet[0] == target[0]) one++;
            if(triplet[1] == target[1]) two++;
            if(triplet[2] == target[2]) three++;
            count++;
        }

        return (one > 0 && two > 0 && three > 0);
    }
}
