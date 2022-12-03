class MyCalendarTwo {
    List<Integer> start;
    List<Integer> end;

    public MyCalendarTwo() {
        start=new ArrayList<>();
        end=new ArrayList<>();
    }
    
    public boolean book(int st, int en) {
        start.add(st);
        end.add(en);
        Collections.sort(start);
        Collections.sort(end);
        int max=0;
        int current=0;
        int size=start.size();
        int j=0;
        for(int i=0;i<size;i++)
        {
            current++;
            if(j<size&&end.get(j)<=start.get(i))
            {
                current--;
                j++;
            }
            max=Math.max(current,max);
            if(max>=3)
            {
                start.remove(Integer.valueOf(st));
                end.remove(Integer.valueOf(en));
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */