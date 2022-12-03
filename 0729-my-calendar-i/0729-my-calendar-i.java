class MyCalendar {
    
    TreeMap<Integer,Integer> tm=new TreeMap<>();

    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer,Integer> floor=tm.floorEntry(start);
        if(floor!=null&&floor.getValue()>start)
            return false;
         Map.Entry<Integer,Integer> ceiling=tm.ceilingEntry(start);
        if(ceiling!=null&&ceiling.getKey()<end)
            return false;
        tm.put(start,end);
        return true;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */