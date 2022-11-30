class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int LEN=nums.length;
        int left=0;
        int right=0;
        int[] freq=new int[100001];
        int counter=0;
        long sum=0;
        long ans=0;
        while(right<LEN&&left<LEN)
        {
            if(counter<k)
            {
                freq[nums[right]]++;
                if(freq[nums[right]]==1)
                    counter++;
                sum+=nums[right];
                right++;
            }
           
          
            while(counter>=k&&left<LEN)
            {
                if(counter==k&&right-left==k)
                {
                    ans=Math.max(ans,sum);
                }
                freq[nums[left]]--;
                if(freq[nums[left]]==0)
                    counter--;
                sum-=nums[left];
                left++;
            }
            }
        
        return ans;
    }
}