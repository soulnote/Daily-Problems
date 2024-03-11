class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        String ans = "";
        HashSet<Character> fset = new HashSet<>();
        for(int i=0;i<order.length();i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                while(map.get(ch)>0){
                    ans+=ch;
                    fset.add(ch);
                    map.put(ch,map.get(ch)-1);
                }  
            }
        }
        
        for(int i=0;i<s.length();i++){
            if(fset.contains(s.charAt(i))){
                continue;
            }
            else ans+=s.charAt(i);
        }
        // for(;i<s.length();i++){
        //     ans+=s.charAt(i);
        // }

        return ans;
    }
}