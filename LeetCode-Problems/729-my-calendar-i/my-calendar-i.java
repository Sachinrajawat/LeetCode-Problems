class MyCalendar {
    HashMap<Integer,Integer> map;
    public MyCalendar() {
        map=new HashMap();
    }
    
    public boolean book(int start, int end) {
            for(Integer val:map.keySet())
            {
                if(val<end && map.get(val)>start)
                    return false;
            }
            map.put(start,end);
        return true;
    }
}