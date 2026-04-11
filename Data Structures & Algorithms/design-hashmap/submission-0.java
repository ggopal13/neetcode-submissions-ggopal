class MyHashMap {

    private int[] map;
    private int currSize;

    public MyHashMap() {
        currSize = 101;
        map = new int[currSize+1];
        Arrays.fill(map,-1);
    }
    
    public void put(int key, int value) {
        if(key > currSize){
            int[] newMap = new int[key+1];
            Arrays.fill(newMap,-1);
            System.arraycopy(map,0,newMap,0,map.length);
            map = newMap;
            currSize = key+1;
        }
        map[key] = value;
    }
    
    public int get(int key) {
        if(key>currSize)
            return -1;
        return map[key];
    }
    
    public void remove(int key) {
        if(key<=currSize) 
        map[key] =-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */