class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();

        for(String str : strs) {
            String hashval = customHash(str);
            if(mp.get(hashval) == null) {
                mp.put(hashval, new ArrayList<>());
                mp.get(hashval).add(str);
            }else {
                mp.get(hashval).add(str);
            }
        }

        for(Map.Entry<String, List<String>> entry: mp.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;

    }

    private String customHash(String str) {

        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
