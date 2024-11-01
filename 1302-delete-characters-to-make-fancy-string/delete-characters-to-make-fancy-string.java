class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        if(n<=2)return s;
        char pre = s.charAt(0);
        sb.append(pre);
        int count = 1;
        for(int i =1;i<n;i++){
            char c = s.charAt(i);
            if(c==pre){
                count+=1;
                if(count<=2){
                    sb.append(c);
                }
                else continue;
            }
            else{
                count=1;
                pre = c;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}