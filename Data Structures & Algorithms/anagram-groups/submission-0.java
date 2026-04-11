class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();

        for(String i: strs){
            char[] charArray = i.toCharArray();
            Arrays.sort(charArray);
            int hashCode = Arrays.hashCode(charArray);
            if(!map.containsKey(hashCode))
                map.put(hashCode, new LinkedList<>());
            map.get(hashCode).add(i);
        }

        return new ArrayList<>(map.values());
    }
}
