class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {

        HashSet<String> set = new HashSet<>();
        for(String s : dictionary ){
            set.add(s);
        }

        StringBuilder ans = new StringBuilder("");
        String[] sentenceArr = sentence.split(" ");
        for(int i=0;i<sentenceArr.length;i++){
            String s = sentenceArr[i];
            boolean rootFound = false;
            for(int j=1;j<=s.length();j++){
                String root = s.substring(0,j);
                
                if(set.contains(root)){
                    ans.append(root + " ");
                    rootFound = true;
                    break;
                }
            }
            if(!rootFound){
                ans.append(s + " ");
            }
        }
        return ans.toString().trim();
    }
}