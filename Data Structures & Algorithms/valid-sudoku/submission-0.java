class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();

        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j]!='.'){
                    if(!set.add(board[i][j]))
                        return false;
                }   
            }
            set.clear();
        }

        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                System.out.println(" " + board[j][i]);
                
                System.out.println(board[j][i] == '.');
                if(board[j][i] != '.'){
                    System.out.println("inside if");
                    if(!set.add(board[j][i]))
                        return false;
                }   
                System.out.println(set);
            }
            set.clear();
        }

        for(int square = 0; square<9; square++){
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    int row = (square/3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    System.out.print(" " + board[row][col]);
                    if(board[row][col]!='.'){
                        if(!set.add(board[row][col]))
                            return false;
                    }      
                }
            }
            set.clear();
        }

        return true;
    }
}
