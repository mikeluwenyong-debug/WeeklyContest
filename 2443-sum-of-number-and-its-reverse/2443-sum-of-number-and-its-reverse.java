class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i=0;i<=num;i++)
        {
            if(i+rev(i)==num)
                return true;
        }
        return false;
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