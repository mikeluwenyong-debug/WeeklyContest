class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> hs=new HashSet<>();
        for(int n:nums)
        {
            hs.add(n);
        }
        for(int n:nums)
        {
            hs.add(rev(n));
        }
        return hs.size();
    }
    
    private int rev(int i)
    {
        int k=0;
        while(i>0)
        {
            k=k*10+i%10;
            i=i/10;
        }
        return k;
    }
}