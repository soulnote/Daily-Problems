class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())return false;
        int idx =0;
        boolean status = true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==goal.charAt(0)){
                status =  check(s,goal, i);
                if(status)return true;
            }
        }
        return false;
    }
    public boolean check(String s, String goal, int idx){
        int i=0;
        for(;i<goal.length() && idx<s.length();i++,idx++){
            if(s.charAt(idx)!=goal.charAt(i))return false;
        }
        for(idx=0;i<s.length();idx++,i++){
            if(s.charAt(idx)!=goal.charAt(i))return false;
        }
        return true;
    }
}