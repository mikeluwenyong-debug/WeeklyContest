class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        Map<Integer,Integer> hm=new HashMap<>();
        int ans=0;
        if(nums[0]==k) ans++;
        hm.put(nums[0],1);
        for(int i=1;i<nums.length;i++)
        {
            int cur=nums[i];
            hm.put(cur,hm.getOrDefault(cur,0)+1);
            Map<Integer,Integer> nm=new HashMap<>();
            for(int kk:hm.keySet())
            {
                int cur_gcd=getGCD(kk,cur);
                int f=hm.get(kk);
                if(cur_gcd==k) ans+=f;
                nm.put(cur_gcd,nm.getOrDefault(cur_gcd,0)+f);
                
            }
            hm=nm;
        }
        return ans;
        
    }
    
    private int getGCD(int a,int b)
    {
        if(b%a==0) return a;
        return getGCD(b%a,a);
    }
}