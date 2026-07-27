class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        long aNum = getDecimal(a);
        long bNum = getDecimal(b);

        return getBinary(aNum+bNum);
    }

    private long getDecimal(String bin){
        long power = 0;
        long res = 0;
        for(int i = bin.length()-1; i>=0; i--){
            int b = bin.charAt(i) - '0';
            res = res + (b * (long) Math.pow(2,power++));
        }
        return res;
    }

    private String getBinary(long val){
        if(val == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(val!=0){
            sb.insert(0,val%2);
            val/=2;
        }
        return sb.toString();
    }
}