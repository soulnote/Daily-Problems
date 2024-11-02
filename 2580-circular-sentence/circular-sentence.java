class Solution {
    public boolean isCircularSentence(String sentence) {
        String[]arr = sentence.split(" ");
        if(arr.length==1)return arr[0].charAt(0)==arr[0].charAt(arr[0].length()-1);
        char first = arr[0].charAt(0);
        char end = arr[0].charAt(arr[0].length()-1);
        for(int i=1;i<arr.length;i++){
            String s = arr[i];
            char start = s.charAt(0);
            if(start != end)return false;
            end = s.charAt(s.length()-1);
        }
        return first == end;
    }
}