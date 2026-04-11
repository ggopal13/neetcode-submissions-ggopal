class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");
        System.out.println(Arrays.toString(parts));
        for(String s: parts){
            if(s.length() == 0) 
                continue;
            if(s.equals("..")){
if(!stack.empty())
                    stack.pop();
            }
                
            else if(s.contains("/") || s.equals("."))
                continue;
            else
                stack.push(s);
        }

        StringBuilder sb = new StringBuilder();

        sb.append("/");
        int i = 0;

        for(String p: stack){
            i++;
            sb.append(p);
            if(i<stack.size())
            sb.append("/");
        }
           

        return sb.toString();
    }
}