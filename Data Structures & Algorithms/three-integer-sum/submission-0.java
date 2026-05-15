class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    
        Set<List<Integer>> triplets = new HashSet<>();
        int len=nums.length;

        Arrays.sort(nums);

        for(int k=0; k<len; k++) {
            int l=k+1, r=len-1;
            while(l<r) {
                if(nums[l]+nums[r] == -nums[k]) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[k], nums[l], nums[r]));
                    triplets.add(list);
                    l++;
                    r--;
                }
                else if(nums[l]+nums[r] > -nums[k])
                    r--;
                else 
                    l++;
            }
        }

        List<List<Integer>> ans = new ArrayList<>(triplets);
        return ans;
    }
}
