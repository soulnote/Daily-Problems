class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
	    for (char c : s.toCharArray()) {
            if((c == ')' || c=='}' || c==']')&& stack.isEmpty()) return false;
		    if (c == '(' || c=='{' || c=='[') stack.push(c);
		    else if (c ==')' && stack.pop()!='(') return false;
		    else if (c =='}' && stack.pop()!='{') return false;
		    else if (c ==']' && stack.pop()!='[') return false;
            // else continue;
	    }
        if(stack.isEmpty()) return true;
        return false;
    }
}