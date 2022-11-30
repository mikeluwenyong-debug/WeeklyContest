class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        int LEN=costs.length;
        int left=candidates-1;
        int right=LEN-candidates;
        long ans=0;
        if(left>=right)
        {
            return total(costs,k);
        }
        else
        {
            for(int i=0;i<candidates;i++)
            {
                pq.add(new int[]{costs[i],i});
                pq.add(new int[]{costs[LEN-1-i],LEN-1-i});
            }
            while(k>0)
            {
                int[] current=pq.poll();
                ans+=current[0];
               
                if(left==right-2)
                {
                    pq.add(new int[]{costs[left+1],left+1});
                    k--;
                    while(k>0)
                    {
                        ans+=pq.poll()[0];
                        k--;
                    }
                    return ans;
                    
                }
                else if(left==right-1)
                {
                    k--;
                    while(k>0)
                    {
                        ans+=pq.poll()[0];
                        k--;
                    }
                    return ans;
                }
                else
                {
                    if(current[1]<=left)
                    {
                        left++;
                        pq.add(new int[]{costs[left],left});
                    }
                    else
                    {
                        right--;
                        pq.add(new int[]{costs[right],right});
                    }
                    k--;
                }
             
            }
            return ans;
        }
    }
    
    private long total(int[] costs,int k)
    {
        Arrays.sort(costs);
        long ans=0;
        int i=0;
        while(i<k)
        {
            ans+=costs[i++];
        }
        return ans;
    }
}