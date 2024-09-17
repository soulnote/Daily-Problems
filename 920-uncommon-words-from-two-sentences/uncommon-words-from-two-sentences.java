class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String []ArrS1 = s1.split(" ");
        String []ArrS2 = s2.split(" ");

        HashMap<String,Boolean> map = new HashMap<>();
        for(String s : ArrS1){
            if(!map.containsKey(s)){
                map.put(s,false);
            }
            else{
                map.put(s, true);
            }
        }
        for(String s : ArrS2){
            if(!map.containsKey(s)){
                map.put(s, false);
            }
            else{
                map.put(s, true);
            }
        }
        // String[] ans = new String[]
        ArrayList<String> list = new ArrayList<>();
        for(String s : map.keySet()){
            if(map.get(s)==false){
                list.add(s);
            }
        }
        String[]ans = new String[list.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}