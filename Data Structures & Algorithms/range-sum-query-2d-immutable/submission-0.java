class NumMatrix {

    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        sum = new int[n+1][m+1];

        for(int i = 1; i<=n ;i++){
            for(int j =1; j<=m; j++){
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int leftRegion = sum[row2+1][col1];
        int upperRegion = sum[row1][col2+1];
        int leftCorner = sum[row1][col1];
        return leftCorner - upperRegion - leftRegion + sum[row2+1][col2+1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */