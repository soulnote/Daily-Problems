class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        char pre = word.charAt(0);
        int i = 1, count = 1;
        while (i < word.length()) {
            char ch = word.charAt(i);
            if (ch == pre) {
                count++;
                if (count == 9) {
                    sb.append(count);
                    sb.append(ch);
                    count = 0;
                }

            } else {
                if (count != 0) {
                    sb.append(count);
                    sb.append(pre);
                    pre = ch;
                    count = 1;
                }
                else{
                    count =1;
                    pre = ch;
                }

            }
            if (count>0 && i == word.length() - 1) {
                sb.append(count);
                sb.append(ch);
            }
            i++;
        }
        if (i == 1 && count>0) {
            sb.append(count);
            sb.append(pre);
        }
        return sb.toString();
    }
}