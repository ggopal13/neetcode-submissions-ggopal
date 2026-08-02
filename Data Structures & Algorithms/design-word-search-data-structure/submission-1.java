class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(Node root, String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Node child : curr.children) {
                    if (child != null) {
                        boolean found = search(child, word.substring(i + 1));
                        if (found)
                            return true;
                    }
                }
                return false;
            } else {
                int index = c - 'a';
                if (curr.children[index] == null)
                    return false;
                curr = curr.children[index];
            }
        }
        return curr.isEnd;
    }
}

class Node {
    boolean isEnd;
    Node[] children;

    public Node() {
        this.isEnd = false;
        this.children = new Node[26];
    }
}
