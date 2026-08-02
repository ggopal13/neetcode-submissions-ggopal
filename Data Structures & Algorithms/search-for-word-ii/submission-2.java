class Solution {
    private Node root = new Node();

    private void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null)
                curr.children[index] = new Node();
            curr = curr.children[index];
        }
        curr.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        Set<String> res = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                backtrack(res, i, j, board, root);
            }
        }

        return new LinkedList<>(res);
    }

    public void backtrack(Set<String> res, int i, int j, char[][] board, Node root) {
        if(board[i][j] == '.' || root.children[board[i][j] - 'a']  == null)
            return;
        
        char c = board[i][j];
        int index = c - 'a';


        root = root.children[index];

        if(root.word!=null){
            res.add(root.word);
        }

        board[i][j] = '.';

        if(i>0) backtrack(res,i-1,j,board,root);
        if(i<board.length-1) backtrack(res,i+1,j,board,root);
        if(j>0) backtrack(res,i,j-1,board,root);
        if(j<board[0].length-1) backtrack(res,i,j+1,board,root);

        board[i][j] = c;
    }
}

class Node {
    String word;
    Node[] children;

    public Node() {
        this.children = new Node[26];
    }
}
