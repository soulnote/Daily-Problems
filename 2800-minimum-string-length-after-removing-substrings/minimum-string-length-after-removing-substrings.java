class Solution {
    public int minLength(String s) {
        // StringBUilder sb = new StringBuilder(s);
        boolean isPresent = true;
        while(s.length()>0 && isPresent==true){
            isPresent = false;
            for(int i =1;i<s.length();i++){
                if(s.substring(i-1,i+1).equals("AB")||s.substring(i-1,i+1).equals("CD")){
                    s = s.substring(0,i-1)+""+s.substring(i+1,s.length());
                    isPresent = true;
                }
            }
        }
        return s.length();
    }
}