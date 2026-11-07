class Solution {
    public int reverseBits(int n) {

        int ans = n&1;
        for(int i=1; i<32; i++) {
            ans = (ans<<1) | (n>>i)&1;
        }
        
        return ans;
    }
}
