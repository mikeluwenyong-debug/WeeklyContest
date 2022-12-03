class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int LEN=intervals.length;
        int max=0;
        int[] start=new int[LEN];
        int[] end=new int[LEN];
        int i=0;
        for(int[] itv:intervals)
        {
            start[i]=itv[0];
            end[i++]=itv[1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int current=0;
        int j=0;
        for(i=0;i<LEN;i++)
        {
            current++;
            
            if(j<LEN&&end[j]<=start[i])
            {
                current--;
                j++;
            }
            max=Math.max(max,current);
        }
        return max;
    }
}