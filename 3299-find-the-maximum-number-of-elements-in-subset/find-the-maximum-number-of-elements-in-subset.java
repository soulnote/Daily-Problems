class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(map.containsKey(num)){
                map.get(num).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num, list);
            }
        }
        
        int max = 0;
        
        if (map.containsKey(1)) {
            int count1 = map.get(1).size();
            max = (count1 % 2 == 0) ? count1 - 1 : count1;
        }
        
        for(int i=0; i<nums.length; i++){
            long num = nums[i];
            if (num == 1) continue;
            
            long curr = num;
            int count = 0;
            
            while(map.containsKey((int)curr) && map.get((int)curr).size() >= 2){
                count += 2;
                if (curr > 46340) { 
                    curr = curr * curr;
                    break;
                }
                curr = curr * curr; 
            }
            
            if(map.containsKey((int)curr)){
                count += 1;
            } else {
                count -= 1;
            }
            
            max = Math.max(max, count);
        }
        
        return max;
    }
}