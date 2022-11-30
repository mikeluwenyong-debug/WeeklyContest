class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int[] val=new int[4];
        val[0]=getInt(event1[0]);
        val[1]=getInt(event1[1]);
        val[2]=getInt(event2[0]);
        val[3]=getInt(event2[1]);
        
        return Math.max(val[0],val[2])<=Math.min(val[1],val[3]);
    }
    
    private int getInt(String s)
    {
        String[] ss=s.split(":");
        int h=Integer.valueOf(ss[0]);
        int m=Integer.valueOf(ss[1]);
        return h*60+m;
    }
    
    
}