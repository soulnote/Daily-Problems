class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[]ans = new int[arr.length];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }
        Arrays.sort(arr);
        int count = 1;
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            if(!map.containsKey(num))continue;
            List<Integer> idxes = map.get(num);
            map.remove(num);
            for(int j=0;j<idxes.size();j++){
                ans[idxes.get(j)] = count;
            }
            count++;
        }
        return ans;
    }
}