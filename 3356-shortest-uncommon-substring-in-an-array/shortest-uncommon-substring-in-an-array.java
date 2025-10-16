class Solution {
    public String[] shortestSubstrings(String[] arr) {
        Map<Integer, Set<String>> map = new HashMap();
        String[] ans = new String[arr.length];
        Arrays.fill(ans, "");
    
        
      
        for(int i=0; i<arr.length; i++){
            map.put(i, new HashSet());
            String str = arr[i];
            for(int j=0; j<str.length(); j++){
                for(int k=j; k<str.length(); k++){
                    map.get(i).add(str.substring(j,k+1));
                }
            }
            
        }
        
        for(int i=0; i<arr.length; i++){
            String str = arr[i];
            for(int j=0; j<str.length(); j++){
                for(int k=j; k<str.length(); k++){
                    String sub = str.substring(j,k+1);
                    
                    boolean flag = false;
                    for(int l=0; l<arr.length; l++){
                        if(i == l) continue;
                        
                        if(map.get(l).contains(sub)){
                            flag = true;
                            break;
                        }
                    }
                    
                    if(!flag){
                        if(ans[i].isEmpty()){
                            ans[i] = sub;
                        } else{
                            if(sub.length() == ans[i].length() && sub.compareTo(ans[i]) < 0){
                                ans[i] = sub;
                            }else{
                                if(sub.length() < ans[i].length()){
                                    ans[i] = sub;
                                }
                            }
                        }
                    }
                    
                    
                }
            }
            
        }
        
        return ans;
    }
}