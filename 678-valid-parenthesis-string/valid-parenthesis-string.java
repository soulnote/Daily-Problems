class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openBt = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                openBt.push(i);
            }
            else if(ch==')' ){
                if(openBt.size()>0)openBt.pop();
                else if(star.size()>0)star.pop();
                else return false;
            }
            else{
                star.push(i);
            }
        }
        
        while(openBt.size()>0 && star.size()>0){
            int a = openBt.pop();
            int b=star.pop();
            if(a>b){
                return false;
            }
            else continue;
        }
        if(openBt.size()!=0) return false;
        return true;
    }
}