class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int ans = 0;
        for(int i=0; i<size; i++) {
            ans ^= i;
            ans ^= nums[i];
        }
        ans ^= size;
        return ans;
    }
}
