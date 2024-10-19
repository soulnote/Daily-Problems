class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        String preStr = "0";
        if(n==1)return '0';
        while(n>1){
            String newStr = preStr + "1" + reverse(invert(preStr));
            preStr = newStr;
            n--;
        }
        return preStr.charAt(k-1);
    }
    public String reverse(String str){
        StringBuilder s = new StringBuilder(str);
        s.reverse();
        return s.toString();
    }
    public String invert(String str){
        StringBuilder s = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0'){
                s.append('1');
            }
            else{
                s.append('0');
            }
        }
        return s.toString();
    }
}