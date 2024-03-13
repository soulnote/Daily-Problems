class Solution {
    public String interpret(String command) {
        String ans = "";
        char last ='(';
        for(int i=0;i<command.length();i++){
            char ch = command.charAt(i);
            if(ch == '('){
                char ch2 = command.charAt(i+1);
                if(ch2==')') {
                    ans+= "o";
                    i+=1;
                }
                else{
                    ans+= "al";
                    i+=3;
                }
            }
            else{
                ans+="G";
            }
            
        }
        return ans;
    }
}