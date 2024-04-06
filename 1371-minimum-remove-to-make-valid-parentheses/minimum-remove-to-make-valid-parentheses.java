class Solution {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                count++;
                st.push('(');
            }
            else if(ch==')'){
                if(count>0){
                    st.push(')');
                    count--;
                }
            }
            else {
                st.push(ch);
            }
        }
        while(st.size()>0){
            char c = st.pop();
            if(c=='(' && count>0){
                count--;
                continue;
            }
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}