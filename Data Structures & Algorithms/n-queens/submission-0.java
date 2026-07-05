class Solution {
    private List<List<String>> list = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i<n ;i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        solveQueens(n,0,board);
        return list;
    }

    private void solveQueens(int n, int i, char[][] board){
        if(i>=n){
            List<String> temp = new LinkedList<>();
            for(char[] row: board){
                temp.add(new String(row));
            }
            list.add(temp);
            return;
        }
        for(int k = 0; k<n; k++){
            if(isValid(board,i,k)){
                board[i][k] = 'Q';
                solveQueens(n,i+1,board);
                board[i][k] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int column){
        for(int  j = 0; j<row ; j++){
            if(board[j][column] == 'Q')
                return false;
        }
        for(int i = row-1, j=column-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q')
                return false;
        }
        for(int i = row-1, j = column+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}
