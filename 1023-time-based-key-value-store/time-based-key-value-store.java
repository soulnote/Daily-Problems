class TimeMap {
    class Store{
        String val;
        int time;
        Store(String value, int time){
            this.val  = value;
            this.time = time;
        }
    }
    HashMap<String,List<Store>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // List<Store> list = map.get(key);
        // list.add(new Store(value, timestamp));
        // map.put(key, list);
        if(!map.containsKey(key)){
            List<Store> newList = new ArrayList<>();
            map.put(key, newList);
        }
        map.get(key).add(new Store(value, timestamp));
        // map.put(key, map.get(key).add(new Store(value, timestamp)));
    }
    
    public String get(String key, int timestamp) {
        List<Store> list = map.get(key);
        if(!map.containsKey(key))return "";
        if(list.size()==0)return "";
        int left =0, right = list.size()-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(list.get(mid).time == timestamp)return list.get(mid).val;
            else if(list.get(mid).time > timestamp){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        if(right<0)return "";
        return list.get(right).val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */