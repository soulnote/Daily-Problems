class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==']' && st.size()>0  && st.peek()=='['){
                st.pop();
            }
            else if(ch=='['){
                st.push(ch);
            }
            else continue;
        }
        System.out.println(st.size());
        int ans = (int)Math.ceil((st.size()+1)/2);
        return ans;

    }
}