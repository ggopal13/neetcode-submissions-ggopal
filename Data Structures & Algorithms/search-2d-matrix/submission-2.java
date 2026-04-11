class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int lx = 0;
        int hx = m-1;
        int arrIndex = -1;

        while(lx<=hx){
            int mid = lx + (hx-lx)/2;

            if(matrix[mid][0] == target) return true;
            if(matrix[mid][0] <= target && matrix[mid][n-1] >=target){
                arrIndex = mid;
                break;
            }
            if(matrix[mid][0] > target) hx = mid - 1;
            else{
                lx = mid +1;
                
            }
        }

        if(arrIndex == -1) return false;

        int[] arr = matrix[arrIndex];
        lx = 0;
        hx = n-1; 
        while(lx<=hx){
            int mid = lx + (hx-lx)/2;

            if(arr[mid] == target) return true;
            if(arr[mid] > target) hx = mid-1;
            else lx = mid+1;
        }

        return false;
        
    }
}
