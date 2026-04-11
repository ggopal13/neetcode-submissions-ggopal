class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            int length = str.length();
            sb.append(length);
            sb.append("-");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new LinkedList<>();
        int index = 0;
        while(index<str.length()){
            int lengthEndIndex = str.indexOf("-", index);
            int length = Integer.parseInt(str.substring(index,lengthEndIndex));
            String decodedString = str.substring(lengthEndIndex+1, lengthEndIndex+length+1);
            list.add(decodedString);
            index = lengthEndIndex + length + 1;
        }
        return list;
    }
}
