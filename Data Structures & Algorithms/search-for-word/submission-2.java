class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols;j++){
                boolean result = exist(board,i,j,0,word,visited);
                if(result)
                    return true;
            }
        }

        return false;
    }

    private boolean exist(char[][] board,int i, int j, int index, String word, boolean[][] visited){
        
        if(index>=word.length())
            return true;

        if(i>=board.length || j>=board[0].length || i<0 || j<0)
            return false;

        if(visited[i][j])
            return false;

        if(word.charAt(index)!=board[i][j]) return false;

        visited[i][j] = true;
        
        boolean top;
        boolean bottom ;
        boolean right ;
        boolean left ;

        top = exist(board,i-1,j,index+1, word, visited);
        bottom = exist(board,i+1,j,index+1,word,visited);
        left = exist(board,i,j-1,index+1,word,visited);
        right = exist(board,i,j+1,index+1,word,visited);

        visited[i][j]=false;
    
        return top || bottom || right || left;
    }
}
