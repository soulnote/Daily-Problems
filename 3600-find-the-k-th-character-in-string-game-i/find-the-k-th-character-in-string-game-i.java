class Solution {
    public char kthCharacter(int k) {
        int n = 0;
        while(Math.pow(2,n)<k){
            n++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        while(n>0){
            StringBuilder s = new StringBuilder();
            for(int i=0;i<sb.length();i++){
                char ch = sb.charAt(i);
                if(ch-'a'==25){
                    s.append('a');
                }
                else{
                    ch = (char)(ch+1);
                    s.append(ch);
                }
            }
            sb.append(s.toString());
            s = null;
            n--;
        }
        return sb.charAt(k-1);
    }
}