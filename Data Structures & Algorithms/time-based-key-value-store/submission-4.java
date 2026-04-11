class TimeMap {
    private Map<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key,new ArrayList<>());
        map.get(key).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        int index = binarySearch(timestamp,map.get(key));
        if(index==-1) return "";
        return map.get(key).get(index).value;
    }

    private int binarySearch(int timestamp, List<Node> list){
        int low = 0;
        int high = list.size()-1;
        int ans = low;

        while(low<=high){
            int mid = low + (high-low)/2;

            Node midNode = list.get(mid);
            if(midNode.timestamp == timestamp)
                return mid;
            if(midNode.timestamp>timestamp)
                high = mid-1;
            else{
                ans = Math.max(ans,mid);
                low = mid+1;
            }
        }

        return list.get(ans).timestamp <= timestamp ? ans: -1;
    }
}

class Node {
    String value;

    int timestamp;

    public Node(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }

}
