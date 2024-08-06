class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<word.length();i++){ //1
            
            char ch = word.charAt(i);
            if(map.containsKey(ch)){//2
                map.put(ch,map.get(ch)+1);
            }//2
            else{//3
                map.put(ch,1);
                // list.add(ch);
            }//3
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            list.add(value);
        }
        Collections.sort(list, Collections.reverseOrder());
               int sum=0;
               for(int i=0;i<list.size();i++){
                   int ch = list.get(i);
                   if((i+1)<=8){
                       sum+= list.get(i)*1*1;
                   }
                   else if((i+1)<=16){
                       sum+= list.get(i)*2;
                   }
                   else if((i+1)<=24){
                       sum+= list.get(i)*3;
                   }
                   else sum+=list.get(i)*4;
               }
               
               
        return sum;
    }
}