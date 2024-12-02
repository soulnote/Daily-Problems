class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int len = searchWord.length();
        String[]arr = sentence.split(" ");
        for(int i=0;i<arr.length;i++){
            String s = arr[i];
            if(s.length()>=len){
                String check = s.substring(0,len);
                if(check.equals(searchWord)){
                    return i+1;
                }
            }
        }
        return -1;
    }
}