import java.util.Stack;

class Solution {
    public String makeGood(String s) {
        if (s.length() <= 1) return s;

        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty()) {
                char sch = st.peek();
                if (Character.isAlphabetic(sch) && Character.isAlphabetic(ch) &&
                    Character.toLowerCase(sch) == Character.toLowerCase(ch) &&
                    sch != ch) {
                    st.pop();
                } else {
                    st.push(ch);
                }
            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
