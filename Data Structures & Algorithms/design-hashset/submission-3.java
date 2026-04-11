class MyHashSet {

    private int[] set;
    int currSize;

    public MyHashSet() {
        currSize = 100;
        set = new int[currSize + 1];
    }
    
    public void add(int key) {
        if(key > currSize){
            int[] newSet = new int[key + 1];
            currSize = key;
             System.arraycopy(set, 0, newSet, 0, set.length);
             set = newSet;
        }
        set[key] = 1;
    }
    
    public void remove(int key) {
        if(key <= currSize)
        set[key] = 0;
    }
    
    public boolean contains(int key) {
        if(key > currSize)
            return false;
        return set[key] > 0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */