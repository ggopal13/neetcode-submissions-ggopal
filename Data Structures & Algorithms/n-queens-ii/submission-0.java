class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }

        return totalNQueens(board,n,0,0,0,0);
    }   

    private int totalNQueens(char[][] board, int n, int colMask, int leftDiagMask, int rightDiagMask, int row){
        if(row>=n){
            return 1;
        }
        int count = 0;
        for(int i=0; i<n; i++){
            boolean colSafe = (colMask & (1<<i)) > 0;
            boolean leftDiagSafe = (leftDiagMask & (1<<(row-i+n))) > 0;
            boolean rightDiagSafe = (rightDiagMask & (1<<(row+i))) > 0;
            if(!colSafe && !leftDiagSafe && !rightDiagSafe){
                board[row][i] = 'Q';
                count = count + totalNQueens(board,n,colMask | (1<<i), leftDiagMask | (1<<(row-i+n)),rightDiagMask | (1<<(row+i)), row+1);
                board[row][i] = '.';
            }
        
        }
        return count;
    }
}